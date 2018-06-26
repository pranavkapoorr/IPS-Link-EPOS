package com.ips.epos.actors;


import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.io.Tcp.CommandFailed;
import akka.io.Tcp.ConnectionClosed;
import akka.io.Tcp.Received;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ips.epos.gui.SIMULATORx;
import com.ips.epos.protocols.StatusMessageJson;


public class TcpConnectionHandlerActor extends AbstractActor {

	private final ObjectMapper mapper;
	
	public TcpConnectionHandlerActor(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public static Props props(ObjectMapper mapper) {
		return Props.create(TcpConnectionHandlerActor.class, mapper);
	}
	
	@Override
	public void preStart() throws Exception {
		
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(Received.class, msg->{
				   
					String messageX = msg.data().utf8String();
					// System.out.println("received: "+messageX);
					 StatusMessageJson json = mapper.readValue(messageX, StatusMessageJson.class);
                     SIMULATORx.statusMessageField.setText(json.getStatusMessage());
				})
			
				.match(ConnectionClosed.class, closed->{
					getContext().stop(getSelf());
				})
				.match(CommandFailed.class, conn->{
					getContext().stop(getSelf());
				})
				.build();
	}
	
	@Override
	public void postStop() throws Exception {
		
	}

}
package com.ips.epos.actors;

import java.net.InetSocketAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.io.TcpMessage;
import akka.io.Tcp.Bound;
import akka.io.Tcp.CommandFailed;
import akka.io.Tcp.Connected;

public class TcpServerActor  extends AbstractActor {
	final ActorRef manager;
	private final ObjectMapper mapper;
	 private TcpServerActor(ActorRef manager,InetSocketAddress serverAddress,ObjectMapper mapper) {
	        this.manager = manager;
	        	manager.tell(TcpMessage.bind(getSelf(),serverAddress,100), getSelf());
	        	this.mapper = mapper;
	    }

	  
	  
	  public static Props props(ActorRef tcpMnager, InetSocketAddress serverAddress,ObjectMapper mapper) {
	    return Props.create(TcpServerActor.class, tcpMnager, serverAddress,mapper);
	  }


	  @Override
	  public Receive createReceive() {
	    return receiveBuilder()
	    	.match(Bound.class, msg -> {
	    	   // System.out.print(msg);
	      })
	      .match(CommandFailed.class, msg -> {
	    	  getContext().stop(getSelf());
	      
	      })
	      .match(Connected.class, conn -> {
	    
	    	  final ActorRef handler = getContext().actorOf(TcpConnectionHandlerActor.props(mapper));
	                /**
	                 * !!NB:
	                 * telling the aforesaid akka internal connection actor that the actor "handler"
	                 * is the one that shall receive its (the internal actor) messages.
	                 */
	                sender().tell(TcpMessage.register(handler), self());
	    	// }
	      })
	      .match(InetSocketAddress.class, clientIp->{
	    //	  removeFromVault(clientIp);
	      })
	      .build();
	  }
	
}
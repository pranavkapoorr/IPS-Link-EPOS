package com.ips.epos.actors;


import java.net.InetSocketAddress;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ips.epos.app.SIMULATORx;
import com.ips.epos.protocols.ErrorJson;
import com.ips.epos.protocols.ReceiptJson;
import com.ips.epos.protocols.StatusMessageJson;

import akka.actor.*;
import akka.io.*;
import akka.util.ByteString;
import akka.io.Tcp.*;

public class tcpClient extends AbstractActor {
    
	    private final ActorRef tcpActor;
	    private final InetSocketAddress remote;
	    private ActorRef sender;
	    private ObjectMapper mapper;
	    public static Props props(InetSocketAddress remote, ObjectMapper mapper) {
	        return Props.create(tcpClient.class, remote, mapper);
	    }

	    private tcpClient( InetSocketAddress terminalIPandPort , ObjectMapper mapper) {
	        this.remote = terminalIPandPort;
	        this.mapper = mapper;
	        this.tcpActor = Tcp.get(getContext().system()).manager();
                this.tcpActor.tell(TcpMessage.connect(remote), getSelf());
	      }
	    

		@Override
		public Receive createReceive() {
			return receiveBuilder()
					.match(CommandFailed.class, conn->{
						SIMULATORx.details.setText(conn.causedByString());
						getContext().stop(getSelf());
                                                getContext().getSystem().terminate();
                                                SIMULATORx.isConnected = false;
					})
					.match(Connected.class, conn->{
                                            SIMULATORx.details.setText(conn.toString());
                                            getSender().tell(TcpMessage.register(getSelf()), getSelf());
                                            getContext().become(connected(getSender()));
                                            SIMULATORx.isConnected = true;
					}).build();
		}
		 private Receive connected(ActorRef Serverconnection) {
		        return receiveBuilder()
		               .match(Received.class, msg->{
		            	   String message = msg.data().utf8String();
		            	            if(message.startsWith("{")&&message.endsWith("}")){
                                    	if(message.contains("receipt")){
		                                    ReceiptJson json = mapper.readValue(message, ReceiptJson.class);
		                                    SIMULATORx.details.setText("FINISHED TRANSACTION");
		                                    SIMULATORx.receiptField.setText(json.getReceipt());
                                    	}else if(message.contains("statusMessage")){
                                            StatusMessageJson json = mapper.readValue(message, StatusMessageJson.class);
                                            SIMULATORx.statusMessageField.setText(json.getStatusMessage());
                                        }else{
                                    		ErrorJson json = mapper.readValue(message,ErrorJson.class);
		                                    SIMULATORx.details.setText("ERROR in transaction");
		                                    SIMULATORx.receiptField.setText(json.getErrorText());
                                    	}
                                    }else{
                                    	SIMULATORx.receiptField.setText(message);
                                    }
                                
						})
		               .match(String.class,msg->{
							SIMULATORx.details.setText("sending json String "+msg);
							Serverconnection.tell(TcpMessage.write(ByteString.fromString(msg)), getSelf());
						})
		               .match(ConnectionClosed.class, closed->{
                                    SIMULATORx.isConnected = false;
                                    SIMULATORx.details.setText("connectin cLOSED:"+closed);
                                    getContext().stop(getSelf());
                                    getContext().getSystem().terminate();
		               }).match(CommandFailed.class, conn->{
                                    SIMULATORx.isConnected = false;
                                    SIMULATORx.details.setText("connectin Failed:"+conn);
                                    getContext().stop(getSelf());
                                    getContext().getSystem().terminate();
				})
		               .build();
		    }
                
	}



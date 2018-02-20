package com.ips.epos.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusMessageJson {
    @JsonProperty
    private String statusMessage ;

    public StatusMessageJson() {
    //empty Constructor
    }
    public void setStatusMessage(String statusMessage){
        this.statusMessage = statusMessage;
    }
    public String getStatusMessage(){
        return this.statusMessage;
    }
}

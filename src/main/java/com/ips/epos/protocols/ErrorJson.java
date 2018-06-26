package com.ips.epos.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorJson {
	@JsonProperty
	private String errorText ;
	@JsonProperty
    private String errorCode ;

	public ErrorJson() {
	//empty Constructor
	}
	public void setErrorText(String errorText){
		this.errorText = errorText;
	}
	public String getErrorText(){
		return this.errorText;
	}
	public void setErrorCode(String errorCode){
        this.errorCode = errorCode;
    }
    public String getErrorCode(){
        return this.errorCode;
    }
}

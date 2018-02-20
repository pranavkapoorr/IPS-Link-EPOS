package com.ips.epos.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorJson {
	@JsonProperty
	private String errorText ;

	public ErrorJson() {
	//empty Constructor
	}
	public void setErrorText(String errorText){
		this.errorText = errorText;
	}
	public String getErrorText(){
		return this.errorText;
	}
}

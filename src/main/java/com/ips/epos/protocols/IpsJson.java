package com.ips.epos.protocols;


import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IpsJson {
	@JsonProperty
	private String printFlag ;
	@JsonProperty
	private String messageCode ;
	@JsonProperty
	private String amount;
	@JsonProperty
	private String terminalIp;
	@JsonProperty
	private String statusMessageIp;
	@JsonProperty
	private String GTbit;
	@JsonProperty
	private String statusMessagePort;
	@JsonProperty
	private String terminalPort;
	@JsonProperty
	private String GTmessage;
	@JsonProperty
	private String timeOut;
	@JsonProperty
    private String wait4CardRemoved;
	
	public IpsJson() {
	//empty Constructor
	}
	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setTerminalIp(String terminalIp) {
		this.terminalIp = terminalIp;
	}
	public void setStatusMessageIp(String statusMessageIp) {
		this.statusMessageIp = statusMessageIp;
	}
	public void setGTbit(String gTbit) {
		GTbit = gTbit;
	}
	public void setStatusMessagePort(String statusMessagePort) {
		this.statusMessagePort = statusMessagePort;
	}
	public void setTerminalPort(String terminalPort) {
		this.terminalPort = terminalPort;
	}
	public void setGTmessage(String gTmessage) {
		GTmessage = gTmessage;
	}
	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}
	public void setWait4CardRemoved(String yesOrNo) {
        this.wait4CardRemoved = yesOrNo;
    }
	
}

package com.ips.epos.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptJson {
    @JsonProperty
    private String terminalId;
    @JsonProperty
    private String transactionStatus;
    @JsonProperty
    private String transactionStatusText;
    @JsonProperty
    private String aquirerCode;
    @JsonProperty
    private String STAN;
    @JsonProperty
    private String amount;
    @JsonProperty
    private String transactionType;
    @JsonProperty
    private String aquirerId;
    @JsonProperty
    private String cardType;
    @JsonProperty
    private String cardPAN;
    @JsonProperty
    private String actionCode;
    @JsonProperty
    private String progressiveNumber;
    @JsonProperty
    private String authCode;
    @JsonProperty
    private String transactionDate;
    @JsonProperty
    private String transactionTime;
    @JsonProperty
    private String hostTotalAmount;
    @JsonProperty
    private String hostTotalAmountReqByHost;
    @JsonProperty
    private String cardPresentToken;
    @JsonProperty
    private String omniChannelToken;
    @JsonProperty
    private String omniChannelGUID;
    @JsonProperty
    private String pedDate;
    @JsonProperty
    private String pedTime;
    @JsonProperty
    private String pedStatus;
    @JsonProperty
    private String firmwareVersion;
    @JsonProperty
    private String partNumber;
    @JsonProperty
    private String serialNumber;
    @JsonProperty
    private String DccAmount;
    @JsonProperty
    private String DccCurrency;
    @JsonProperty
    private String DccCurrencyCode;
    @JsonProperty
    private String DccConversionRate;
    @JsonProperty
    private String DccTransactionAmount;
    @JsonProperty
    private String DccTransactionCurrencyDecimal;
       

        

        @JsonProperty
        private String receipt;
        
        public ReceiptJson() {
            //empty Constructor
            }
       
        public String getReceipt(){
            return this.receipt;
        }

        public String getTerminalId() {
            return terminalId;
        }

        public String getTransactionStatus() {
            return transactionStatus;
        }

        public String getAquirerCode() {
            return aquirerCode;
        }

        public String getSTAN() {
            return STAN;
        }

        public String getAmount() {
            return amount;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public String getAquirerId() {
            return aquirerId;
        }

        public String getCardType() {
            return cardType;
        }

        public String getCardPAN() {
            return cardPAN;
        }

        public String getActionCode() {
            return actionCode;
        }

        public String getProgressiveNumber() {
            return progressiveNumber;
        }

        public String getAuthCode() {
            return authCode;
        }
        public String getTransactionDate() {
            return transactionDate;
        }
        public String getTransactionTime() {
            return transactionTime;
        }

        public String getHostTotalAmount() {
            return hostTotalAmount;
        }

        public String getHostTotalAmountReqByHost() {
            return hostTotalAmountReqByHost;
        }

        public String getTransactionStatusText() {
            return transactionStatusText;
        }

        public String getCardPresentToken() {
            return cardPresentToken;
        }

        public String getOmniChannelToken() {
            return omniChannelToken;
        }

        public String getOmniChannelGUID() {
            return omniChannelGUID;
        }

     
        public String getPedDate() {
            return pedDate;
        }

        public String getPedTime() {
            return pedTime;
        }

        public String getPedStatus() {
            return pedStatus;
        }

        public String getFirmwareVersion() {
            return firmwareVersion;
        }

        public String getPartNumber() {
            return partNumber;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public String getDccAmount() {
            return DccAmount;
        }

        public String getDccCurrency() {
            return DccCurrency;
        }

        public String getDccCurrencyCode() {
            return DccCurrencyCode;
        }

        public String getDccConversionRate() {
            return DccConversionRate;
        }

        public String getDccTransactionAmount() {
            return DccTransactionAmount;
        }

        public String getDccTransactionCurrencyDecimal() {
            return DccTransactionCurrencyDecimal;
        }
        /**shows receipt fields in receipt area of simulator**/
       public String getFormattedReceipt(){
           return ifNotNull(new String[]{terminalId, transactionStatus,transactionStatusText, aquirerCode, STAN, amount, 
                   transactionType, aquirerId, cardType, cardPAN, actionCode, progressiveNumber, authCode, transactionDate,
                   transactionTime, hostTotalAmount, hostTotalAmountReqByHost, cardPresentToken,omniChannelToken,omniChannelGUID,pedDate, pedTime ,pedStatus,
                   firmwareVersion, partNumber, serialNumber, DccAmount, DccCurrency, DccCurrencyCode, DccConversionRate, DccTransactionAmount, DccTransactionCurrencyDecimal,
                   (char)10 + receipt + (char)10});
       }
       /**formats the fields and remove the null values to show in simulato receipt area**/
       private String ifNotNull(String toDisplay[]){
           StringBuffer buffer = new StringBuffer();
           for(int i = 0; i < toDisplay.length ; i++){
              if(toDisplay[i] != null && !toDisplay[i].contains("null")){
                  buffer.append(toDisplay[i] +";");
              }
           }
           return buffer.toString();
    } 
}



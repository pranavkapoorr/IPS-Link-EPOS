package com.ips.epos.protocols;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceiptJson {
        @JsonProperty
        private String terminalId;
        @JsonProperty
        private String transactionStatus;
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
        private String transactionTime;
        @JsonProperty
        private String hostTotalAmount;
        @JsonProperty
        private String hostTotalAmountReqByHost;
        @JsonProperty
        private String details;
        @JsonProperty
        private String transactionReference;
        @JsonProperty
        private String probeDate;
        @JsonProperty
        private String probeStatus;
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

        public String getTransactionTime() {
            return transactionTime;
        }

        public String getHostTotalAmount() {
            return hostTotalAmount;
        }

        public String getHostTotalAmountReqByHost() {
            return hostTotalAmountReqByHost;
        }

        public String getDetails() {
            return details;
        }

        public String getTransactionReference() {
            return transactionReference;
        }

        public String getProbeDate() {
            return probeDate;
        }

        public String getProbeStatus() {
            return probeStatus;
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
        
       public String getFormattedReceipt(){
           return terminalId +";"+ transactionStatus +";"+ aquirerCode +";"+ STAN +";"+ amount +";"+ 
                   transactionType +";"+ aquirerId +";"+ cardType +";"+ cardPAN +";"+ actionCode +";"+ progressiveNumber +";"+ authCode +";"+ 
                   transactionTime +";"+ hostTotalAmount +";"+ hostTotalAmountReqByHost +";"+ details +";"+ transactionReference +";"+ probeDate +";"+ probeStatus +";"+
                   DccAmount +";"+ DccCurrency +";"+ DccCurrencyCode +";"+ DccConversionRate +";"+ DccTransactionAmount +";"+ DccTransactionCurrencyDecimal +";"+
                   (char)10+ receipt + (char)10 +";";
       }
        
}



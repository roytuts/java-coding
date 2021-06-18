package com.roytuts.java.misc;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankPaymentData implements Cloneable {
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("payment_id")
    private String paymentNumber;
    @JsonProperty("debtor_iban")
    private String debtorIban;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("creditor_name")
    private String creditorName;
    @JsonProperty("creditor_iban")
    private String creditorIban;
    @JsonProperty("purpose")
    private String purpose;
    @JsonProperty("referenceNumber")
    private String referenceNumber = "";


    @Setter(AccessLevel.NONE)
    @JsonProperty("status")
    private String status;

    @JsonProperty("status_code")
    private String statusCode;


    public void setStatus(String status) {
        String lowerCaseStatus = status.toLowerCase();
        if (lowerCaseStatus.contains("executed") || lowerCaseStatus.contains("processed") || lowerCaseStatus.contains("accepted")) {
            this.status = "SETTLED";
            this.statusCode = "ACSC";
        } else if (lowerCaseStatus.contains("partially") || lowerCaseStatus.contains("partly")) {
            this.status = "PARTIALLY SIGNED";
            this.statusCode = "PATC";
        }
        else if (lowerCaseStatus.contains("signed") || lowerCaseStatus.contains("under execution")  || lowerCaseStatus.contains("sent")) {
            this.status = "WAITING FOR A SETTLEMENT";
            this.statusCode = "ACTC";
        }
        else if (lowerCaseStatus.contains("rejected") || lowerCaseStatus.contains("suspended sepa")) {
            this.status = "REJECTED";
            this.statusCode = "RJCT";
        }
        else if (lowerCaseStatus.contains("new") || lowerCaseStatus.contains("unsigned")) {
            this.status = "UNCONFIRMED";
            this.statusCode = "RCVD";
        }
        else {
            this.status = status;
        }

    }

    @Override
    public BankPaymentData clone() {
        try {
            return (BankPaymentData) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

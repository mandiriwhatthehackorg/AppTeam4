package id.co.mandiri.onepushservices.model.transaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transactions {
    @SerializedName("batchNumber")
    @Expose
    private String batchNumber;
    @SerializedName("sequenceNumber")
    @Expose
    private String sequenceNumber;
    @SerializedName("cardNumber")
    @Expose
    private String cardNumber;
    @SerializedName("amountSign")
    @Expose
    private String amountSign;
    @SerializedName("transactionDetails")
    @Expose
    private TransactionDetails transactionDetails;
    @SerializedName("entryDate")
    @Expose
    private String entryDate;
    @SerializedName("valueDate")
    @Expose
    private String valueDate;
    @SerializedName("cardAcceptorName")
    @Expose
    private String cardAcceptorName;

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAmountSign() {
        return amountSign;
    }

    public void setAmountSign(String amountSign) {
        this.amountSign = amountSign;
    }

    public TransactionDetails getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(TransactionDetails transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getCardAcceptorName() {
        return cardAcceptorName;
    }

    public void setCardAcceptorName(String cardAcceptorName) {
        this.cardAcceptorName = cardAcceptorName;
    }
}

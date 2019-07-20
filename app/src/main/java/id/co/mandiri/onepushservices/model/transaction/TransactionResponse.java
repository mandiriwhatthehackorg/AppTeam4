package id.co.mandiri.onepushservices.model.transaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransactionResponse {
    @SerializedName("TransactionException")
    @Expose
    private TransactionException transactionException;
    @SerializedName("transactions")
    @Expose
    private List<Transactions> transactions = null;

    public TransactionException getTransactionException() {
        return transactionException;
    }

    public void setTransactionException(TransactionException transactionException) {
        this.transactionException = transactionException;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
}

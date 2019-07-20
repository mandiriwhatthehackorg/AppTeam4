package id.co.mandiri.onepushservices.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerResponse {

    @SerializedName("TransactionException")
    @Expose
    private Exception exception;
    @SerializedName("cif")
    @Expose
    private Cif cif;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Cif getCif() {
        return cif;
    }

    public void setCif(Cif cif) {
        this.cif = cif;
    }
}

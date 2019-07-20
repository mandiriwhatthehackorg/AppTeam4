package id.co.mandiri.onepushservices.model.customer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {
    @SerializedName("Response")
    @Expose
    private CustomerResponse response;

    public CustomerResponse getResponse() {
        return response;
    }

    public void setResponse(CustomerResponse response) {
        this.response = response;
    }
}

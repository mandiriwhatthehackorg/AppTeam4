package id.co.mandiri.onepushservices.data.remote;

import id.co.mandiri.onepushservices.model.transaction.Transaction;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("ServicingAPI/1.0/customer/creditcard/{accountNumber}/transaction?period=2015-12")
    Call<Transaction> getTransaction(@Header("Authorization") String authHeader,
                                     @Path("accountNumber") String accountNumber);
}

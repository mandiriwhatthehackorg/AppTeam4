package id.co.mandiri.onepushservices.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import id.co.mandiri.onepushservices.R;
import id.co.mandiri.onepushservices.data.remote.ApiClient;
import id.co.mandiri.onepushservices.data.remote.ApiInterface;
import id.co.mandiri.onepushservices.model.transaction.Transaction;
import id.co.mandiri.onepushservices.model.transaction.TransactionResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Transaction> call = apiInterface.getTransaction(
                "Bearer eyJraWQiOiJqd3RrZXkiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxMzhmYzM0NC0xNTI4LTQzODItYjczMS0wMzRiMzg5ZTc4ZWEiLCJhdWQiOlsiZjY0MjBiNTQtYTdmYi00ZDliLWJiZDMtNzBhODU2YjcyYzFkIiwibWFuZGlyaV9oYWNrYXRob25fdGVhbSJdLCJuYmYiOjE1NjM1NDc2NjgsImlzcyI6Imh0dHBzOlwvXC93d3cuYmFua21hbmRpcmkuY28uaWRcLyIsImV4cCI6MTU2Mzc2MzY2OCwiaWF0IjoxNTYzNTQ3NjY4LCJhcHBfaWQiOiJmNjQyMGI1NC1hN2ZiLTRkOWItYmJkMy03MGE4NTZiNzJjMWQifQ.Peud9HU1dIx2ALTYZR296PwcOOfSMpC-SZTfrvROYE8ZjUXkiwB-alSPvRRwwocfNnx4iydnDMAHTHvgg8SpjsHFvVX8U-8zoKDCVpSH_H5kT3G9hNYM1K-jZvk3gfTN79jeoQhrPoX9kz6H5VEha5caHnl7a9pR3Q5yjBYZBv4",
                "1111006397775");

        call.enqueue(new Callback<Transaction>() {
            @Override
            public void onResponse(Call<Transaction> call, Response<Transaction> response) {
                if (response.isSuccessful()) {
                    Log.d("isSuccessfull", response.toString());
                    Log.d("isSuccessfull", response.body().toString());
                    Log.d("isSuccessfull", response.body().getResponse().getTransactions().get(0).getCardNumber());

                } else {
                    Log.d("isFailed", "fail");
                    Log.d("isFailed", String.valueOf(response.code()));
                    Log.d("isFailed", response.message());
                    Log.d("isFailed", response.toString());
                }
            }

            @Override
            public void onFailure(Call<Transaction> call, Throwable t) {
                Log.e("response", t.getMessage());
            }
        });
    }

}

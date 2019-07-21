package id.co.mandiri.onepushservices.ui.creditcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import id.co.mandiri.onepushservices.R;

import static id.co.mandiri.onepushservices.Constant.MY_PREF_NAME;

public class BlockCreditCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_credit_card);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Blokir Kartu Kredit");

        findViewById(R.id.confirm_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = getSharedPreferences(MY_PREF_NAME, MODE_PRIVATE).edit();
                editor.putBoolean("isBlocked", true);
                editor.apply();

                Intent intent = new Intent(BlockCreditCardActivity.this, DashboardCreditCardActivity.class);
                intent.putExtra("status", 1);
                startActivity(intent);
                finish();
            }
        });


    }
}

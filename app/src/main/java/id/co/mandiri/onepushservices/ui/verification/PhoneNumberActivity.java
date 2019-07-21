package id.co.mandiri.onepushservices.ui.verification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

import id.co.mandiri.onepushservices.R;

public class PhoneNumberActivity extends AppCompatActivity {

    private EditText numberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        numberEditText = findViewById(R.id.number_ed);

        String phonenumber = getIntent().getStringExtra("phonenumber");

        if (phonenumber != null) {
            numberEditText.setText(phonenumber);
        }

        findViewById(R.id.send_otp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = "+62";

                String number = numberEditText.getText().toString().trim();

                if (number.isEmpty() || number.length() < 5) {
                    numberEditText.setError("Valid number is required");
                    numberEditText.requestFocus();
                    return;
                }

                String phoneNumber = code + number;

                Intent intent = new Intent(PhoneNumberActivity.this, VerifyOtpActivity.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);

            }
        });
    }
}

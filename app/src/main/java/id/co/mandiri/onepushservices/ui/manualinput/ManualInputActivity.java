package id.co.mandiri.onepushservices.ui.manualinput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import id.co.mandiri.onepushservices.R;
import id.co.mandiri.onepushservices.ui.verification.PhoneNumberActivity;

public class ManualInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_input);

        EditText editTextNumber = findViewById(R.id.phone_number_ed);

        final String phoneNumber = editTextNumber.getText().toString();

        findViewById(R.id.lanjutkan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManualInputActivity.this, PhoneNumberActivity.class);
                intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
            }
        });

    }
}

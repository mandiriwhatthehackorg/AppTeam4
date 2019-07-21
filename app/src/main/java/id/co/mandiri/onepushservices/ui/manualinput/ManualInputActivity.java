package id.co.mandiri.onepushservices.ui.manualinput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import id.co.mandiri.onepushservices.R;
import id.co.mandiri.onepushservices.ui.verification.PhoneNumberActivity;

public class ManualInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_input);

        final EditText editTextNumber = findViewById(R.id.phone_number_ed);

        final EditText birthdateEd = findViewById(R.id.birthdate);

        final BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
        final View sheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_datepicker, null);
        mBottomSheetDialog.setContentView(sheetView);

        findViewById(R.id.lanjutkan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = editTextNumber.getText().toString().trim();

                if (number.isEmpty() || number.length() < 5) {
                    editTextNumber.setError("Valid number is required");
                    editTextNumber.requestFocus();
                    return;
                }

                String phoneNumber = number;

                Intent intent = new Intent(ManualInputActivity.this, PhoneNumberActivity.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);
            }
        });

        findViewById(R.id.birthdate).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mBottomSheetDialog.show();
                return true;
            }
        });

        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                DatePicker datePicker;
                datePicker = sheetView.findViewById(R.id.datePicker);

                String day = datePicker.getDayOfMonth() + "/";
                String month = "" + (datePicker.getMonth()+1) + "/";
                String year = "" + datePicker.getYear();

                birthdateEd.setText(day + month + year);

            }
        });

        TextView textView = sheetView.findViewById(R.id.selesai);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetDialog.dismiss();
            }
        });


    }
}

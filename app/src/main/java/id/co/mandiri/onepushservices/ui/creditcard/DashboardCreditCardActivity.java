package id.co.mandiri.onepushservices.ui.creditcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import id.co.mandiri.onepushservices.R;

public class DashboardCreditCardActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private Toolbar mToolbar;

    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_credit_card);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(viewPagerAdapter);

        Log.d("current", String.valueOf(viewPager.getCurrentItem()));

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Credit Card Center");

        // delete session
        FirebaseAuth.getInstance().signOut();

    }
}

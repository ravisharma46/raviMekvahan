package com.naruto.mekvahandelivery.vendor_pickup;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.naruto.mekvahandelivery.R;
import static com.naruto.mekvahandelivery.CommonFiles.CommonVaribalesFunctions.dropConfirm;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;
import com.naruto.mekvahandelivery.customer_report.ViewCustomerReport;

public class OngoingBookingCustomerDrop extends AppCompatActivity {

    private Button btadd_report,bt_drop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_booking_customerdrop);

        btadd_report= findViewById(R.id.bt_addReport);
        bt_drop=findViewById(R.id.bt_drop);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Ongoing booking</font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        btadd_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OngoingBookingCustomerDrop.this, ViewCustomerReport.class));
            }
        });

        bt_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dropConfirm(OngoingBookingCustomerDrop.this);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

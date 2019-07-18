package com.naruto.mekvahandelivery.customer_pickup;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.naruto.mekvahandelivery.R;
import com.naruto.mekvahandelivery.customer_report.AddCustomerReport;
import com.naruto.mekvahandelivery.customer_report.ViewCustomerReport;

public class OnGoingBookingVendorDrop extends AppCompatActivity {
    private LinearLayout paint_linear;
    private TextView tvDetails, date, time;
    private ImageView call;
    private Button report_show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoingbooking_vendordrop);

        paint_linear = findViewById(R.id.linear_paint_1);
        tvDetails = findViewById(R.id.tvDetails_1);

        report_show=findViewById(R.id.report_view);

        call = findViewById(R.id.call);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>#123</font>"));
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);


        tvDetails.setOnClickListener(new View.OnClickListener() {
            int check = 1;

            @Override
            public void onClick(View view) {

                if (check == 1) {
                    paint_linear.setVisibility(View.VISIBLE);
                    check = 0;
                } else {
                    paint_linear.setVisibility(View.GONE);
                    check = 1;
                }


            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:123456789"));
                startActivity(callIntent);
            }
        });
        report_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnGoingBookingVendorDrop.this, ViewCustomerReport.class));
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




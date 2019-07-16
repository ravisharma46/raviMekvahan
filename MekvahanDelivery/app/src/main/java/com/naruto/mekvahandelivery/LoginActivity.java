package com.naruto.mekvahandelivery;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    ImageView iv_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iv_bg = findViewById(R.id.bg_img);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int windowWidth = size.x;
        int windowHeight = size.y;

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                windowWidth, (windowHeight / 2)-40);
        iv_bg.setLayoutParams(params);
        iv_bg.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    public void loginSubmit(View view) {
        Intent intent = new Intent(LoginActivity.this, NavActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

package com.saini.testhome.views.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.saini.testhome.R;
import com.saini.testhome.views.adapter.ViewAdapter;

public class AppIntroActivity extends AppCompatActivity {

    ViewPager mViewPager;
    ViewAdapter mViewAdapter;
    Button mNextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_app_intro);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        uiInitialization();

        setUpViewPager();
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AppIntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void uiInitialization() {
        mNextButton = findViewById(R.id.button_app_intro_next);
        mViewPager = findViewById(R.id.viewPagerIntro);
    }

    public void setUpViewPager() {
        mViewAdapter = new ViewAdapter(this);
        mViewPager.setAdapter(mViewAdapter);
    }
}
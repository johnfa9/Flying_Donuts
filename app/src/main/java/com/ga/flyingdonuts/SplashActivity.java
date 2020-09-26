package com.ga.flyingdonuts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashActivity extends AppCompatActivity {
// Uses EasySplash which is added to the Gradle build
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EasySplashScreen welcome =new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#F0B3A6"))
                .withHeaderText("Welcome to Flying Donuts !")
                .withLogo(R.mipmap.ic_launcher_round);
        welcome.getHeaderTextView().setTextColor(Color.BLACK);
        View welcomeSplashScreen = welcome.create();
        setContentView(welcomeSplashScreen);  //splash screen does not have a layout


    }
}
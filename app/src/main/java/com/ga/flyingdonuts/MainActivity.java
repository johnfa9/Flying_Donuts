package com.ga.flyingdonuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //User selected registration
    public void NavigateToRegister(View view) {
        Intent intentRegistration = new Intent(this, ActivityRegistration.class);
        startActivity(intentRegistration);

    }
    //user selected login
    public void NavigateToLogin(View view) {
        Intent intentLogin = new Intent(this, Login1.class);
        startActivity(intentLogin);
    }
}

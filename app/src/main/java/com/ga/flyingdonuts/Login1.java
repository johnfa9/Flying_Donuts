package com.ga.flyingdonuts;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Login1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
    }

    public void LoginUser(View view) {
        EditText email = (EditText) findViewById(R.id.editTextEmailAddressLogin);
        EditText password = (EditText) findViewById(R.id.editTextPasswordLogin);
        TextView result = (TextView) findViewById(R.id.textViewResult);

        String emailText= email.getText().toString();
        String passwordText= password.getText().toString();
        //retrieve users data submitted in ActivityRegistration
        ArrayList<DonutUser> data = ActivityRegistration.retrieveLogins();
        //retrieve users data from ArrayList
        DonutUser userValue = data.get(0);

        //Compare data entered by user on login to registration
        if (userValue.getEmail().equals(emailText) && userValue.getPassword().equals(passwordText))
        {
            result.setTextColor(Color.BLUE);
            result.setText("Login Success...Welcome to Flying Donuts !");

        }
        else {
            result.setTextColor(Color.RED);
            result.setText("Login Failed...Please enter a valid email and password");
        }




    }
}
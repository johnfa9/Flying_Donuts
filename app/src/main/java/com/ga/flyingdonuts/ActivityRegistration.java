package com.ga.flyingdonuts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class ActivityRegistration extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    boolean dateValid= false;  //date is entered by user
    private static ArrayList<DonutUser> nameList= new ArrayList<>();  //hold registration info
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void SaveRegistration(View view) {
        EditText firstName = (EditText) findViewById(R.id.editTextFirstName);
        EditText lastName = (EditText) findViewById(R.id.editTextLastName);
        EditText dt = (EditText) findViewById(R.id.editTextDate);
        EditText email = (EditText) findViewById(R.id.editTextEmailAddress);
        EditText password = (EditText) findViewById(R.id.editTextPassword);
        //Check if all views have been populated by user

        if (firstName.getText().toString().trim().equalsIgnoreCase("")) {
            firstName.setError("This field can not be blank");
            return;
        }

        if (lastName.getText().toString().trim().equalsIgnoreCase("")) {
            lastName.setError("This field can not be blank");
            return;
        }

        if (dt.getText().toString().trim().equalsIgnoreCase("")) {
            dt.setError("This field can not be blank");
            return;
        }

        if (email.getText().toString().trim().equalsIgnoreCase("")) {
            email.setError("This field can not be blank");
            return;
        }

        if (password.getText().toString().trim().equalsIgnoreCase("")) {
            password.setError("This field can not be blank");
            return;
        }
        //Check length of first name
        if (firstName.getText().toString().trim().length() < 3) {
            firstName.setError("First name must be at least 3 characters");
            return;
        }

        //Check Length of last name
        if (lastName.getText().toString().trim().length() < 3) {
            lastName.setError("Last name must be at least 3 characters");
            return;
        }
        //Check length of password
        if (password.getText().toString().length()<8) {
            password.setError("Password must be at least 8 characters");
            return;
        }

        //Check if user entered a valid date
        dateValid= checkDate(dt.getText().toString());
        if (!dateValid ) {
            dt.setError(("Please enter a correct date (mm/dd/yyyy"));
            return;
        }

        //Check if user entered correct email address
        if ((!email.getText().toString().trim().matches(emailPattern)) ) {
            email.setError(("Please enter a correct email address"));
            return;
        }


        DonutUser donutUser= new DonutUser(
                firstName.getText().toString(),
                lastName.getText().toString(),
                email.getText().toString(),
                dt.getText().toString(),
                password.getText().toString());

        nameList.add(donutUser);
        DonutUser vak = nameList.get(0);
        Toast.makeText(getApplicationContext(), vak.getBirthDate(),
                Toast.LENGTH_SHORT).show();

        Log.i(TAG, nameList.get(0).getLastName());

        //User successfully created, return to MainActivity
        Intent loginIntent = new Intent(this, MainActivity.class);
        startActivity(loginIntent);
    }

    public boolean checkDate(String dateVal)
            //check if a valid date was entered in the registration
    {
        String errorReturn="";
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");

        Date testDate = null;
        try
        {
            testDate = sdf.parse(dateVal);
        }
        catch (ParseException | java.text.ParseException e)
        {
            errorReturn = "invalid date" +
                    " format.";
            return false;
        }
        if (!sdf.format(testDate).equals(dateVal))
        {
            errorReturn = "Invalid date.";
            return false;
        }
        return true;
    }

    public static ArrayList<DonutUser> retrieveLogins() {
        return nameList;
    }
}
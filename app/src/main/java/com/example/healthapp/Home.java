package com.example.healthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.healthapp.Session.SessionManager;

public class Home extends AppCompatActivity {

    // Session Manager Class
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Session class instance
        session = new SessionManager(getApplicationContext());

        /**
         * Call this function to check user login
         * This will redirect user to LoginActivity if he is not
         * logged in
         * */
        session.checkLogin();

        Intent intent = getIntent();
    }

    public void reportsBtn(View view){
        Intent intent = new Intent(this, Reports.class);
        startActivity(intent);
    }
}

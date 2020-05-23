package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mobileapp.user.MainActivityUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Search search = new Search();

        final EditText login = findViewById(R.id.login);
        final EditText pass = findViewById(R.id.password);

        Button btn = findViewById(R.id.auth);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = login.getText().toString().trim();
                String pas = pass.getText().toString().trim();

                if(log.equals("admin") & pas.equals("admin")){

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivityUser.class);
                    startActivity(intent);
                }
            }
        });

    }


}

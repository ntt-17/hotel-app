package com.example.hotel_booking;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {
    TextView mTxtDK;
    EditText mEdtEmail;
    EditText mEdtPassword;
    Button mBtnDN;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtDK = (TextView) findViewById(R.id.txtDK);
        mEdtEmail = (EditText) findViewById(R.id.inputMail);
        mEdtPassword = (EditText) findViewById(R.id.edtMK);
        mBtnDN = (Button) findViewById(R.id.btnDK);

        mTxtDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        mBtnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckCrededentials();
            }
        });
    }
    private void CheckCrededentials(){
        String email = mEdtEmail.getText().toString();
        String password = mEdtPassword.getText().toString();

        if(email.isEmpty() || !email.contains("@")) {
            showError(mEdtEmail, "Your email is not valid!");
        }

        if(password.isEmpty() || password.length() < 8)
            showError(mEdtPassword, "Your password should have more than 8 letters!");
        }


    private void showError(EditText mEdt, String s){
        mEdt.setError(s);
    }
}
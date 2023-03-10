package com.example.hotel_booking;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class RegisterActivity extends AppCompatActivity {

    EditText mEdtUsername;
    EditText mEdtEmail;
    EditText mEdtPassword;
    EditText mEdtConfirmPass;
    Button mBtnDK;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEdtUsername = (EditText) findViewById(R.id.edtUsername);
        mEdtEmail = (EditText) findViewById(R.id.inputMail);
        mEdtPassword = (EditText) findViewById(R.id.edtMK);
        mEdtConfirmPass = (EditText) findViewById(R.id.edtPassword);
        mBtnDK = (Button) findViewById(R.id.btnDK);

        mBtnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckCededentials();
            }
        });
    }
    private void CheckCededentials(){
        String username = mEdtUsername.getText().toString();
        String email = mEdtEmail.getText().toString();
        String password = mEdtPassword.getText().toString();
        String confirmPass = mEdtConfirmPass.getText().toString();

        if(username.isEmpty() || username.length() < 8)
            showError(mEdtUsername, "Your user is not valid");

        if(email.isEmpty() || !email.contains("@")) {
            showError(mEdtEmail, "Your email is not valid!");
        }

        if(password.isEmpty())
            showError(mEdtPassword, "Your password can't be empty");
        else if(password.length() < 8)
            showError(mEdtPassword, "Password should be more than 8 letters");

        if(!confirmPass.matches(password))
            showError(mEdtConfirmPass, "Your password does not match");
        if(confirmPass.isEmpty())
            showError(mEdtConfirmPass, "Please, confirm your password");
    }

    private void showError(EditText mEdt, String s)
    {
        mEdt.setError(s);
    }
}
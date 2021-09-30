package com.example.android_example_mvp_java.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_example_mvp_java.Contract;
import com.example.android_example_mvp_java.LoginPresenter;
import com.example.android_example_mvp_java.R;
import com.example.android_example_mvp_java.data.LoginCredentials;

public class MainActivity extends AppCompatActivity implements Contract.LoginView {
    private EditText username;
    private EditText password;
    private Button loginBtn;

    private ProgressDialog progressDialog;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        presenter = new LoginPresenter(this);
        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        loginBtn = findViewById(R.id.bt_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailVal = username.getText().toString();
                String passwordVal = password.getText().toString();

                LoginCredentials credentials = new LoginCredentials(emailVal, passwordVal);
                presenter.start(credentials);
            }
        });
    }

    @Override
    public void showProgressBar() {
        progressDialog.show();
    }

    @Override
    public void hideProgressBar() {
        progressDialog.dismiss();
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(this, DashBoardActivity.class));
        finish();
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
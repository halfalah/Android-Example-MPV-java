package com.example.android_example_mvp_java.data;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;

import androidx.core.util.PatternsCompat;

import com.example.android_example_mvp_java.Contract;

import java.util.regex.Pattern;

public class LoginInteractor {
    private Contract.LoginListener loginListener;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    public LoginInteractor(Contract.LoginListener loginListener) {
        this.loginListener = loginListener;
    }
    public void  login(LoginCredentials loginCredentials){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(hasError(loginCredentials)){
                    return;
                }else{
                    loginListener.onSuccess();
                }
            }
        },3000);
    }
    private boolean hasError(LoginCredentials loginCredentials){
        String username = loginCredentials.getUsername();
        String password = loginCredentials.getPassword();

        if(TextUtils.isEmpty(username)){
            loginListener.onFailed("Email is empty");
            return true;
        }

        if(!username.matches(emailPattern) && username.length() > 0){
            loginListener.onFailed("Email invalid");
            return true;
        }

        if(TextUtils.isEmpty(password)){
            loginListener.onFailed("Password is empty");
            return true;
        }
        return false;
    }
}

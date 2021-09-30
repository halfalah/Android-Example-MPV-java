package com.example.android_example_mvp_java;

import com.example.android_example_mvp_java.data.LoginCredentials;
import com.example.android_example_mvp_java.data.LoginInteractor;

public class LoginPresenter implements  Contract.LoginListener{
    private Contract.LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(Contract.LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractor(this);
    }

    public  void start(LoginCredentials loginCredentials){
        loginView.showProgressBar();
        loginInteractor.login(loginCredentials);
    }

    @Override
    public void onSuccess() {
        loginView.hideProgressBar();
        loginView.onSuccess();
    }

    @Override
    public void onFailed(String message) {
        loginView.hideProgressBar();
        loginView.onFailed(message);
    }
}

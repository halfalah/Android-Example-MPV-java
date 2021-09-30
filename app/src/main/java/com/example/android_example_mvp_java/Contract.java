package com.example.android_example_mvp_java;

public interface Contract {
    interface LoginView{
        void showProgressBar();
        void hideProgressBar();
        void onSuccess();
        void onFailed(String message);
    }
    interface LoginListener{
        void onSuccess();
        void onFailed(String message);
    }
}

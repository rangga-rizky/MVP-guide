package com.example.ranggarizky.mvplatihan.main;


import android.app.ProgressDialog;

import com.example.ranggarizky.mvplatihan.BaseView;

public interface MainView extends BaseView {
    void showToast(String message);
    void showProgressdialog();
    void hideProgressdialog();
}
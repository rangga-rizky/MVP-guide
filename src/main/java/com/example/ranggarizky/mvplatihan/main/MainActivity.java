package com.example.ranggarizky.mvplatihan.main;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ranggarizky.mvplatihan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    MainPresenter presenter;
    @BindView(R.id.editUsername)
    EditText editUsername;
    @BindView(R.id.editPassword)
    EditText editPassword;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initPresenter();
        onAttachView();
    }

    @Override
    public void onAttachView() {
        progressDialog = new ProgressDialog(this);
        presenter.onAttach(this);
    }

    private void initPresenter() {
        presenter = new MainPresenter();
    }


    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    @OnClick(R.id.btnLogin)
    public void login(){
        presenter.login(editUsername.getText().toString(),editPassword.getText().toString());
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressdialog() {
        progressDialog.show();
    }

    @Override
    public void hideProgressdialog() {
        progressDialog.hide();
    }
}

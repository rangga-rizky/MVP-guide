package com.example.ranggarizky.mvplatihan.main;


import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.ranggarizky.mvplatihan.API;
import com.example.ranggarizky.mvplatihan.Presenter;
import com.example.ranggarizky.mvplatihan.model.ResponseApi;
import com.example.ranggarizky.mvplatihan.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements Presenter<MainView> {
    private MainView mView;

    @Override
    public void onAttach(final MainView view) {
        mView = view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }

    public void login(String username,String password) {
        mView.showProgressdialog();

        API apiService = API.client.create(API.class);
        Call<ResponseApi> call = apiService.login(username,password);

        //proses call
        call.enqueue(new Callback<ResponseApi>() {
            @Override
            public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
                ResponseApi apiresponse = response.body();
                if(apiresponse!=null){
                    if(apiresponse.getError().equals("false")){
                        mView.showToast("Sukses");

                    }else{
                        mView.showToast(apiresponse.getMessage());
                    }
                }else{
                    mView.showToast("Server No Response");
                }

                mView.hideProgressdialog();
            }


            @Override
            public void onFailure(Call<ResponseApi> call, Throwable t) {
                Log.e("cok", "onFailure: ", t.fillInStackTrace());
                mView.showToast("Failed to Connect Internet");
                mView.hideProgressdialog();

            }
        });
    }
}
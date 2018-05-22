package com.example.ranggarizky.mvplatihan;


public interface Presenter<T extends BaseView> {
    void onAttach(T view);

    void onDetach();
}
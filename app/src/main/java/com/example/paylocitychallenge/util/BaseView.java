package com.example.paylocitychallenge.util;

public interface BaseView<T> {
    void setPresenter(T presenter);
    void showErrorAndKill(int messageId, boolean shouldKill);
    void showErrorDialog(int dialogTitleResId, int dialogMessageResId);
    void showToast(int toastMessage, int length);
    void killActivity();
}
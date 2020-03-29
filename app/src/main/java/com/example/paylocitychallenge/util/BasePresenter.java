package com.example.paylocitychallenge.util;

import androidx.annotation.VisibleForTesting;

public interface BasePresenter {
    @VisibleForTesting
    BaseView getView();
    boolean start();
    void stop();
}
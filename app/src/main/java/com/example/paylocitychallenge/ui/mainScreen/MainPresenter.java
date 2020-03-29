package com.example.paylocitychallenge.ui.mainScreen;

import androidx.annotation.VisibleForTesting;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;

    MainPresenter(MainContract.View mainView) {
        this.mMainView = mainView;
        mMainView.setPresenter(this);
    }

    @Override
    public MainContract.View getView() {
        return mMainView;
    }

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public void stop() {

    }

    @VisibleForTesting
    public void setView(MainContract.View view){
        mMainView = view;
    }
}
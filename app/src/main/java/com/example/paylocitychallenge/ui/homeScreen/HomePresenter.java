package com.example.paylocitychallenge.ui.homeScreen;

import androidx.annotation.VisibleForTesting;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mHomeView;

    HomePresenter(HomeContract.View HomeView) {
        this.mHomeView = HomeView;
        mHomeView.setPresenter(this);
    }

    @Override
    public HomeContract.View getView() {
        return mHomeView;
    }

    @Override
    public boolean start() {
        return false;
    }

    @Override
    public void stop() {

    }

    @VisibleForTesting
    public void setView(HomeContract.View view){
        mHomeView = view;
    }
}
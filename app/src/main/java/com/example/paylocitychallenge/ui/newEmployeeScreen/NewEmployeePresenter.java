package com.example.paylocitychallenge.ui.newEmployeeScreen;

public class NewEmployeePresenter implements NewEmployeeContract.Presenter {

    private NewEmployeeContract.View mNewEmployeeView;

    NewEmployeePresenter(NewEmployeeContract.View HomeView) {
        this.mNewEmployeeView = HomeView;
        mNewEmployeeView.setPresenter(this);
    }

    @Override
    public NewEmployeeContract.View getView() { return mNewEmployeeView; }

    @Override
    public boolean start() { return false; }

    @Override
    public void stop() { }

    //TODO Needed if we implemented testing
//    public void setView(NewEmployeeContract.View view){ mNewEmployeeView = view; }
}
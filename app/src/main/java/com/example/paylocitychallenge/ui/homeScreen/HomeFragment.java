package com.example.paylocitychallenge.ui.homeScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paylocitychallenge.databinding.FragmentHomeBinding;
import com.example.paylocitychallenge.ui.homeScreen.HomeActivity;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class HomeFragment extends Fragment implements HomeContract.View {

    private View mRoot;
    private HomeContract.Presenter mPresenter;
    private FragmentHomeBinding mBinding;

    static HomeFragment newInstance() { return new HomeFragment();}

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showErrorAndKill(int messageId, boolean shouldKill) {

    }

    @Override
    public void showErrorDialog(int dialogTitleResId, int dialogMessageResId) {

    }

    @Override
    public void showToast(int toastMessage, int length) {

    }

    @Override
    public void killActivity() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mBinding = FragmentHomeBinding.inflate(inflater, container, false);
        mRoot = mBinding.getRoot();

        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}

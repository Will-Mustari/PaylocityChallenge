package com.example.paylocitychallenge.ui.mainScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paylocitychallenge.databinding.FragmentMainBinding;
import com.example.paylocitychallenge.ui.homeScreen.HomeActivity;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class MainFragment extends Fragment implements MainContract.View {

    private View mRoot;
    private MainContract.Presenter mPresenter;
    private FragmentMainBinding mBinding;

    static MainFragment newInstance() { return new MainFragment();}

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
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

        mBinding = FragmentMainBinding.inflate(inflater, container, false);
        mRoot = mBinding.getRoot();

        mBinding.continueButton.setOnClickListener(new ContinueButtonOnClickListener(getContext()));

        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    private class ContinueButtonOnClickListener implements View.OnClickListener {

        private Context mContext;

        ContinueButtonOnClickListener(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    }
}

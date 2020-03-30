package com.example.paylocitychallenge.ui.newEmployeeScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.paylocitychallenge.databinding.FragmentNewEmployeeBinding;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class NewEmployeeFragment extends Fragment implements NewEmployeeContract.View {

    private View mRoot;
    private NewEmployeeContract.Presenter mPresenter;
    private FragmentNewEmployeeBinding mBinding;

    static NewEmployeeFragment newInstance() { return new NewEmployeeFragment();}

    @Override
    public void setPresenter(NewEmployeeContract.Presenter presenter) { mPresenter = presenter; }

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

        mBinding = FragmentNewEmployeeBinding.inflate(inflater, container, false);
        mRoot = mBinding.getRoot();
        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}

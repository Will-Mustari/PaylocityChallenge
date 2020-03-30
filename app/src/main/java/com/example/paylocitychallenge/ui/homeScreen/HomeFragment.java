package com.example.paylocitychallenge.ui.homeScreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.paylocitychallenge.databinding.FragmentHomeBinding;
import com.example.paylocitychallenge.ui.newEmployeeScreen.NewEmployeeActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class HomeFragment extends Fragment implements HomeContract.View {

    private View mRoot;
    private HomeContract.Presenter mPresenter;
    private FragmentHomeBinding mBinding;
    private ArrayList<EmployeeCard> mEmployeeCardList;

    static HomeFragment newInstance() { return new HomeFragment();}

    @Override
    public void setPresenter(HomeContract.Presenter presenter) { mPresenter = presenter; }

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
        loadEmployeeData();

        mEmployeeCardList.add(new EmployeeCard(
                "Will Mustari",
                "None",
                "$1000"));
        mEmployeeCardList.add(new EmployeeCard(
                "Bob Smith",
                "None",
                "$1000"));
        mEmployeeCardList.add(new EmployeeCard(
                "Fred Jones",
                "None",
                "$1000"));

        mBinding.addEmployeeButton.setOnClickListener(new AddEmployeeOnClickListener(getContext()));
        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.recyclerView.setAdapter(new HomeAdapter(mEmployeeCardList));

        return mRoot;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    private void loadEmployeeData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<EmployeeCard>>() {}.getType();
        mEmployeeCardList = gson.fromJson(json, type);

        if (mEmployeeCardList == null) {
            mEmployeeCardList = new ArrayList<>();
        }
    }

    private class AddEmployeeOnClickListener implements View.OnClickListener {

        private Context mContext;

        AddEmployeeOnClickListener(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, NewEmployeeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    }
}

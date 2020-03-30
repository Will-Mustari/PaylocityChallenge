package com.example.paylocitychallenge.ui.newEmployeeScreen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.paylocitychallenge.R;
import com.example.paylocitychallenge.ui.homeScreen.EmployeeCard;
import com.example.paylocitychallenge.ui.homeScreen.HomeActivity;
import com.example.paylocitychallenge.util.ActivityUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class NewEmployeeActivity extends AppCompatActivity implements DependentDialogFragment.DependentDialogListener {

    private NewEmployeeContract.Presenter mPresenter;
    private TextView mCurrentDependents;
    private ArrayList<String> mDependentList;
    private ArrayList<EmployeeCard> mEmployeeCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_employee);

        NewEmployeeFragment newEmployeeFragment = (NewEmployeeFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentPanel);
        if(newEmployeeFragment == null) {
            newEmployeeFragment = NewEmployeeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), newEmployeeFragment,
                    R.id.contentPanel);
        }

        mPresenter = new NewEmployeePresenter(newEmployeeFragment);
        mCurrentDependents = findViewById(R.id.current_dependents);
        Button mAddDependent = findViewById(R.id.add_dependant_button);
        Button mSaveEmployee = findViewById(R.id.save_employee_button);

        mAddDependent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        mSaveEmployee.setOnClickListener(new SaveEmployeeOnClickListener(this));

    }

    public void openDialog() {
        DependentDialogFragment dependentDialogFragment = new DependentDialogFragment();
        dependentDialogFragment.show(getSupportFragmentManager(), "dependent dialog");
    }

    @Override
    public void applyTexts(String name) {
        if(mDependentList == null) {
            mDependentList = new ArrayList<>();
            mDependentList.add(name);
        } else {
            mDependentList.add(name);
        }

        String dependentList = "";
        for(String s : mDependentList) {
            dependentList = dependentList.concat(s + '\n');
        }
        mCurrentDependents.setText(dependentList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.stop();
    }

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }

    private class SaveEmployeeOnClickListener implements View.OnClickListener {
        private Context mContext;

        SaveEmployeeOnClickListener(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public void onClick(View view) {

            int totalCost = 0;
            TextInputEditText text = findViewById(R.id.textInput);

            if(text != null) {
                String name = Objects.requireNonNull(text.getText()).toString();
                if(name.toLowerCase().startsWith("a")) {
                    totalCost += 900;
                } else {
                    totalCost += 1000;
                }

                String dependentList = "";
                if(mDependentList == null) {
                    dependentList = "None";
                } else {
                    for(String s : mDependentList) {
                        if(s.toLowerCase().startsWith("a")) {
                            totalCost += 450;
                        } else {
                            totalCost += 500;
                        }
                    }

                    for(String s : mDependentList) {
                        dependentList = dependentList.concat(s + " ");
                    }
                }

                int diff = 52000 - totalCost;
                String cost = String.valueOf(totalCost);
                String difference = String.valueOf(diff);

                String costCalc = "$52,000\n"+"-$"+cost+"\n$"+difference;

                ArrayList<EmployeeCard> mEmployeeCardList = new ArrayList<>();
                mEmployeeCardList.add(new EmployeeCard(
                        name,
                        dependentList,
                        costCalc));

                getEmployeeData();
                saveEmployeeData(mEmployeeCardList.get(0));
                Intent intent = new Intent(mContext, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }

        }
    }

    private void getEmployeeData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<EmployeeCard>>() {}.getType();
        mEmployeeCardList = gson.fromJson(json, type);

        if (mEmployeeCardList == null) {
            mEmployeeCardList = new ArrayList<>();
        }
    }

    private void saveEmployeeData(EmployeeCard list) {
        mEmployeeCardList.add(list);
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mEmployeeCardList);
        editor.putString("task list", json);
        editor.apply();
    }
}

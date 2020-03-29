package com.example.paylocitychallenge.ui.homeScreen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.paylocitychallenge.R;
import com.example.paylocitychallenge.util.ActivityUtils;

public class HomeActivity extends AppCompatActivity {

    private HomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeFragment homeFragment = (HomeFragment) getSupportFragmentManager()
                .findFragmentById(R.id.contentPanel);
        if(homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), homeFragment,
                    R.id.contentPanel);
        }

        mPresenter = new HomePresenter(homeFragment);
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
}

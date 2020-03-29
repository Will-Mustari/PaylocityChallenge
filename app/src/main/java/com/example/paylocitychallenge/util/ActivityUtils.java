package com.example.paylocitychallenge.util;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import static androidx.core.util.Preconditions.checkNotNull;

public class ActivityUtils {
    @SuppressLint("RestrictedApi")
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int fragmentId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(fragmentId, fragment);
        transaction.commit();
    }

    public static void replaceFragment(@NonNull FragmentManager fragmentManager,
                                       @NonNull Fragment fragment, int fragmentId){
        fragmentManager.beginTransaction().replace(fragmentId, fragment).commit();
    }
}
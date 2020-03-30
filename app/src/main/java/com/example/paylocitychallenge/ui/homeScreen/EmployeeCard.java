package com.example.paylocitychallenge.ui.homeScreen;

public class EmployeeCard {
    private String mName;
    private String mDependants;
    private String mCost;

    public EmployeeCard(String name, String dependants, String cost) {
        mName = name;
        mDependants = dependants;
        mCost = cost;
    }

    public String getName() {
        return mName;
    }

    public String getDependants() {
        return mDependants;
    }

    public String getCost() {
        return mCost;
    }

    //TODO Useful if we want to implement a way to edit an existing EmployeeCard
//    public void setName(String mName) {
//        this.mName = mName;
//    }
//
//    public void setNumDependants(String mNumDependants) {
//        this.mNumDependants = mNumDependants;
//    }
//
//    public void setCost(String mCost) {
//        this.mCost = mCost;
//    }
}

package com.phamngoclinh.loginfbfirebase;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class OderFoodPagerAdapter extends FragmentPagerAdapter {
    public OderFoodPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentAppetizer();
            case 1:
                return new FragmentMaindishes();
            case 2:
                return new FragmentSup();
            case 3:
                return new FragmentDesserts();
            case 4:
                return new FragmentDrinks();
            default:
                return new FragmentAppetizer();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Appetizer";
            case 1:
                return "Maindishes";
            case 2:
                return "Sup";
            case 3:
                return "Desserts";
            case 4:
                return "Drinks";
            default:
                return "Appetizer";
        }
    }
}

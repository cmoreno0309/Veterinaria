package com.veterinaria.proyecto.veterinaria;

//import android.app.Fragment;
//import android.app.FragmentManager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

//import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by nirmal on 12/08/15.
 */
public class ImageViewPagerAdapterMascota extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;

    public ImageViewPagerAdapterMascota(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();
        switch (position) {
            case 0:
                f = new RegistroMascota();
                break;
            case 1:
                f = new DetalleFoto();
                break;
        }
        return f;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}



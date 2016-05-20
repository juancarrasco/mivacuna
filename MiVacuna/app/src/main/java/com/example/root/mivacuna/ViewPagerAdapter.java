package com.example.root.mivacuna;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.Locale;

import static android.support.v4.content.res.TypedArrayUtils.getString;

/**
 * Created by root on 16/05/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
        Resources resources;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);


    }

    @Override
    public int getCount() {
        // Returns the number of tabs
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        // Returns a new instance of the fragment
        switch (position) {
            case 0:
                return new CalendarioFragment();
            case 1:
                return new ConsultarCalendarioFragment();

        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "Calendario";
            case 1:
                return "Consultar Calendario";

        }
        return null;
    }



}

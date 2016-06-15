package com.shogonir.android_sample.CustomAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shogo on 2016/06/15.
 */
public class CustomAdapterPagerAdapter extends FragmentPagerAdapter {

    private List<Integer> items;

    public CustomAdapterPagerAdapter (FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        for (int i=0; i<3; i++) {
            items.add(i);
        }
    }

    @Override
    public Fragment getItem(int position) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=20*position; i<20*(position+10); i++) {
            list.add(String.format("%02d", i));
        }
        return CustomAdapterFragment.newInstance(position, list);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}

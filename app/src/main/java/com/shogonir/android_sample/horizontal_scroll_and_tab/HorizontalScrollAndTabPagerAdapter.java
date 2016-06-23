package com.shogonir.android_sample.horizontal_scroll_and_tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shogo on 2016/06/11.
 */
public class HorizontalScrollAndTabPagerAdapter extends FragmentPagerAdapter {

    private List<Integer> items;

    public HorizontalScrollAndTabPagerAdapter(FragmentManager fm) {
        super(fm);
        items = new ArrayList<>();
        for (int i=0; i<3; i++) {
            items.add(i);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return HorizontalScrollAndTabFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}

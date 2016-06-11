package com.shogonir.android_sample.HorizontalScrollAndTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shogonir.android_sample.R;

/**
 * Created by shogo on 2016/06/11.
 */
public class HorizontalScrollAndTabFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "sectionNumber";

    public static HorizontalScrollAndTabFragment newInstance(int sectionNumber) {
        HorizontalScrollAndTabFragment fragment = new HorizontalScrollAndTabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        TextView textView = (TextView) inflater.inflate(R.layout.layout_drag_list_item, container, false);
        textView.setText("Item " + getArguments().getInt(ARG_SECTION_NUMBER, 0));
        return textView;
    }
}

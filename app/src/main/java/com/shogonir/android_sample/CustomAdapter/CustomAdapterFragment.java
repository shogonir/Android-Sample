package com.shogonir.android_sample.CustomAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shogonir.android_sample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shogo on 2016/06/15.
 */
public class CustomAdapterFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "sectionNumber";
    private static final String ARG_LIST = "list";

    private List<String> mList;

    public static CustomAdapterFragment newInstance (int sectionNumber, ArrayList<String> list) {
        CustomAdapterFragment fragment = new CustomAdapterFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, sectionNumber);
        bundle.putStringArrayList(ARG_LIST, list);
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
        ListView listView = (ListView)inflater.inflate(R.layout.layout_custom_adapter_list, container, false);
        Bundle bundle = getArguments();
        ArrayList<String> list = bundle.getStringArrayList(ARG_LIST);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                container.getContext(),
                R.layout.layout_drag_list_item,
                R.id.drag_list_item_text,
                list==null ? new ArrayList<String>() : list
        );
        listView.setAdapter(adapter);
        return listView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}

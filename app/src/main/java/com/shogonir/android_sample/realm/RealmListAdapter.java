package com.shogonir.android_sample.realm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.shogonir.android_sample.R;
import com.shogonir.android_sample.data.NameCode;

import java.util.List;

/**
 * Created by shogo on 2016/06/23.
 */
public class RealmListAdapter extends BaseAdapter {

    private List<NameCode> mItems;
    private LayoutInflater mInflater;

    public RealmListAdapter (List<NameCode> items, LayoutInflater inflater) {
        mItems = items;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.layout_realm_list_item, viewGroup, false);
            view.setTag(new ViewHolder(view));
        } else {
            view = convertView;
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        NameCode item = mItems.get(i);
        holder.mName.setText(item.getName());
        holder.mCode.setText(item.getCode());
        return view;
    }

    private class ViewHolder {

        private TextView mName;
        private TextView mCode;

        ViewHolder (View view) {
            mName = (TextView) view.findViewById(R.id.realm_list_name);
            mCode = (TextView) view.findViewById(R.id.realm_list_code);
        }
    }
}

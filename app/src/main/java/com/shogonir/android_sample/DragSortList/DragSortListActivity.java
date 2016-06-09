package com.shogonir.android_sample.DragSortList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;
import com.shogonir.android_sample.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DragSortListActivity extends AppCompatActivity {

    private static final String TAG = "DragSortListActivity";

    private DragSortListView listView;
    private ArrayAdapter<String> adapter;

    private DragSortListView.DropListener onDrop = new DragSortListView.DropListener() {
        @Override
        public void drop(int from, int to) {
            if (from != to) {
                Log.d(TAG, String.format("drop: from:%d to:%d", from, to) + adapter);
                String item = adapter.getItem(from);
                adapter.remove(item);
                adapter.insert(item, to);
            }
        }
    };

    private DragSortListView.RemoveListener onRemove = new DragSortListView.RemoveListener() {
        @Override
        public void remove(int which) {
            adapter.remove(adapter.getItem(which));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_sort_list);

        listView = (DragSortListView) findViewById(R.id.drag_sort_list_list);
        String[] names = getResources().getStringArray(R.array.random_names);
        ArrayList<String> list = new ArrayList(Arrays.asList(names));
        adapter = new ArrayAdapter<String>(
                this,
                R.layout.layout_drag_list_item,
                R.id.drag_list_item_text,
                list
        );
        listView.setAdapter(adapter);
        listView.setDropListener(onDrop);
        listView.setRemoveListener(onRemove);

        DragSortController controller = new DragSortController(listView);
        ////controller.setDragHandleId(R.id.imageView1);
        //controller.setClickRemoveId(R.id.);
        controller.setRemoveEnabled(false);
        controller.setSortEnabled(true);
        controller.setDragInitMode(1);
        //controller.setRemoveMode(removeMode);

        listView.setFloatViewManager(controller);
        listView.setOnTouchListener(controller);
        listView.setDragEnabled(true);
    }
}

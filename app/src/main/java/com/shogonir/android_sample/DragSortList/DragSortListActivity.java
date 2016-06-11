package com.shogonir.android_sample.DragSortList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortItemView;
import com.mobeta.android.dslv.DragSortListView;
import com.shogonir.android_sample.R;

import java.util.ArrayList;
import java.util.Arrays;

public class DragSortListActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String TAG = "DragSortListActivity";

    private DragSortListView listView;
    private ArrayAdapter<String> adapter;
    private boolean canDrag = true;

    private DragSortListView.DropListener onDrop = new DragSortListView.DropListener() {
        @Override
        public void drop(int from, int to) {
            if (from != to) {
                Log.d(TAG, String.format("drop: from:%d to:%d", from, to));
                String item = adapter.getItem(from);
                adapter.remove(item);
                adapter.insert(item, to);
            }
        }
    };

    private DragSortListView.RemoveListener onRemove = new DragSortListView.RemoveListener() {
        @Override
        public void remove(int which) {
            Log.d(TAG, String.format("remove: which:%d", which));
            adapter.remove(adapter.getItem(which));
        }
    };

    private DragSortListView.DragListener onDrag = new DragSortListView.DragListener() {
        @Override
        public void drag(int from, int to) {
            Log.d(TAG, String.format("drag: from:%d to:%d", from, to));
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_sort_list);
        findViewById(R.id.drag_sort_list_button).setOnClickListener(this);

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
        listView.setDragListener(onDrag);
        listView.setDropListener(onDrop);
        listView.setRemoveListener(onRemove);
        listView.setOnItemClickListener(this);

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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "onItemClick: ");
        TextView textView = (TextView)view.findViewById(R.id.drag_list_item_text);
        Toast.makeText(this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.drag_sort_list_button :
                canDrag = !canDrag;
                listView.setDragEnabled(canDrag);
                String button_label = getString(
                        canDrag ?
                                R.string.drag_sort_list_button_draggable :
                                R.string.drag_sort_list_button_not_draggable
                );
                ((Button)view).setText(button_label);
                break;
        }
    }
}

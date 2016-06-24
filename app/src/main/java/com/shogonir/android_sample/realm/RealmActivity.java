package com.shogonir.android_sample.realm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.shogonir.android_sample.R;
import com.shogonir.android_sample.data.NameCode;

import java.util.List;

public class RealmActivity extends AppCompatActivity  implements View.OnClickListener {

    public static final int CODE_INSERT = 4423;

    private ListView mListView;
    private NameCodeDao mNameCodeDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        mListView = (ListView) findViewById(R.id.realm_list);
        mNameCodeDao = new NameCodeDao(this);

        updateList();

        findViewById(R.id.realm_insert).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.realm_insert :
                Intent intent = new Intent(this, RealmInsertActivity.class);
                startActivityForResult(intent, CODE_INSERT);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        Bundle bundle = data.getExtras();
        switch (requestCode) {
            case CODE_INSERT :
                String name = bundle.getString(RealmInsertActivity.KEY_NAME);
                String code = bundle.getString(RealmInsertActivity.KEY_CODE);
                mNameCodeDao.insertNameCode(name, code);
                updateList();
        }
    }

    public void updateList () {
        List<NameCode> items = mNameCodeDao.findAllNameCodes();
        RealmListAdapter adapter = new RealmListAdapter(items, getLayoutInflater());
        mListView.setAdapter(adapter);
    }
}

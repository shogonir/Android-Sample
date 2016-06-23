package com.shogonir.android_sample.realm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.shogonir.android_sample.R;

public class RealmInsertActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_NAME = "name";
    public static final String KEY_CODE = "code";

    private EditText mName;
    private EditText mCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_insert);

        mName = (EditText) findViewById(R.id.realm_insert_name);
        mCode = (EditText) findViewById(R.id.realm_insert_code);

        findViewById(R.id.realm_insert_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.realm_insert_button :
                String name = mName.getText().toString();
                String code = mCode.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(code)) {
                    toastEmpty();
                } else {
                    setResultNameCode(name, code);
                }
                break;
        }
    }

    public void toastEmpty () {
        Toast.makeText(
                this,
                getString(R.string.realm_insert_toast_empty),
                Toast.LENGTH_SHORT
        ).show();
    }

    public void setResultNameCode (String name, String code) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NAME, name);
        bundle.putString(KEY_CODE, code);
        Intent data = new Intent();
        data.putExtras(bundle);
        setResult(RealmActivity.CODE_INSERT, data);
        finish();
    }
}

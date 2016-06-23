package com.shogonir.android_sample.realm;

import android.content.Context;

import com.shogonir.android_sample.data.NameCode;
import com.shogonir.android_sample.data.NameCodeRealm;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by shogo on 2016/06/23.
 */
public class NameCodeDao {

    private Context mContext;

    NameCodeDao (Context context) {
        mContext = context;
    }

    public NameCode toData (NameCodeRealm nameCodeRealm) {
        NameCode nameCode = new NameCode();
        nameCode.setName(nameCodeRealm.getName());
        nameCode.setCode(nameCodeRealm.getCode());
        return nameCode;
    }

    public List<NameCode> findAllNameCodes () {
        List<NameCode> nameCodes = new ArrayList<>();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(mContext).build();
        Realm.setDefaultConfiguration(realmConfig);
        Realm realm = Realm.getDefaultInstance();
        for (NameCodeRealm nameCodeRealm : realm.where(NameCodeRealm.class).findAll()) {
            nameCodes.add(toData(nameCodeRealm));
        }
        realm.close();
        return nameCodes;
    }

    public void insertNameCode (String name, String code) {
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(mContext).build();
        Realm.setDefaultConfiguration(realmConfig);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        NameCodeRealm nameCodeRealm = realm.createObject(NameCodeRealm.class);
        nameCodeRealm.setName(name);
        nameCodeRealm.setCode(code);
        realm.commitTransaction();
        realm.close();
    }
}

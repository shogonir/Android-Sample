package com.shogonir.android_sample.data;

import io.realm.RealmObject;

/**
 * Created by shogo on 2016/06/23.
 */
public class NameCodeRealm extends RealmObject {

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

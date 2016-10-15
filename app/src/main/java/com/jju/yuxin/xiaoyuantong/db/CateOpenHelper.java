package com.jju.yuxin.xiaoyuantong.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong.db
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 9:25.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class CateOpenHelper extends SQLiteOpenHelper {
    private static CateOpenHelper numberOpenHelper;
    private final String CREATE_DB = "create table cate(_id Integer primary key autoincrement,cate text)";
    private static final String TABLENAME = "category.db";

    public static CateOpenHelper getInstance(Context context) {
        if (numberOpenHelper == null) {
            numberOpenHelper = new CateOpenHelper(context, TABLENAME, null, 1);
        }
        return numberOpenHelper;
    }

    public CateOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

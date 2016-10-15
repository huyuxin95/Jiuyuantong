package com.jju.yuxin.xiaoyuantong.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jju.yuxin.xiaoyuantong.db.CateOpenHelper;
import com.jju.yuxin.xiaoyuantong.db.NumberOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong.dao
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 9:54.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class NumberDataBase {
    private NumberOpenHelper numberOpenHelper;
    private CateOpenHelper cateopenHelper;
    private final SQLiteDatabase numdb;
    private final SQLiteDatabase catedb;

    public NumberDataBase(Context context) {
        numberOpenHelper = NumberOpenHelper.getInstance(context);
        cateopenHelper=CateOpenHelper.getInstance(context);
        catedb=cateopenHelper.getWritableDatabase();
        numdb = numberOpenHelper.getWritableDatabase();
    }

    public List<Map<String, String>> getGroupData() {
        List<Map<String, String>> groupdata = new ArrayList<>();
        Cursor cursor = catedb.query("cate", new String[]{"_id","cate"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Map<String, String> map = new HashMap<>();
            int anInt = cursor.getInt(0);
            String string = cursor.getString(1);
            map.put("id", String.valueOf(anInt));
            map.put("cate", string);
            groupdata.add(map);
            map = null;
        }
        cursor.close();
        return groupdata;
    }

    public List<List<Map<String, String>>> getChildData() {
        List<List<Map<String, String>>> childdata=new ArrayList<>();

        List<Map<String, String>> groupData = getGroupData();
        for (int i=0;i<groupData.size();i++){
            List<Map<String,String>> list=new ArrayList<>();
            Map<String, String> map = groupData.get(i);
            String cateid = map.get("id");
            Cursor cursor = numdb.rawQuery("select _id,name,number from number where cateid=?",new String[]{cateid});
            while (cursor.moveToNext()){
                Map<String,String> maps=new HashMap<>();
                int _id = cursor.getInt(0);
                String name = cursor.getString(1);
                String number = cursor.getString(2);
                maps.put("id", String.valueOf(_id));
                maps.put("name",name);
                maps.put("number",number);
                list.add(maps);
            }
            cursor.close();
            childdata.add(list);
        }
        return childdata;
    }

    public void addNumber(String name,String number,String cate){
        Cursor cursor = catedb.rawQuery("select _id from cate where cate=?", new String[]{cate});
        if (cursor != null && cursor.getCount()>0){
                cursor.moveToFirst();
                int cateid = cursor.getInt(0);
                //insert into links(name,address) values('jerichen','gdsz');
                numdb.execSQL("insert into number(name,number,cateid)values(?,?,?)",new String[]{name,number, String.valueOf(cateid)});

        }else{
            catedb.execSQL("insert into cate(cate)values(?)",new String[]{cate});
            Cursor cursorid = catedb.rawQuery("select _id from cate where cate=?", new String[]{cate});
            cursorid.moveToFirst();
            int cateid2 = cursorid.getInt(0);
            //insert into links(name,address) values('jerichen','gdsz');
            numdb.execSQL("insert into number(name,number,cateid)values(?,?,?)",new String[]{name,number, String.valueOf(cateid2)});
        }
    }


}

package com.jju.yuxin.xiaoyuantong.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.xiaoyuantong
 * Created by yuxin.
 * Created time 2016/10/9 0009 下午 8:02.
 * Version   1.0;
 * Describe :
 * History:
 * ==============================================================================
 */

public class Youwan implements Parcelable {
    public int img;
    public String name;
    public String content;
    public String show;

    public Youwan(int img, String name, String content, String show) {
        this.img = img;
        this.name = name;
        this.content = content;
        this.show = show;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.img);
        dest.writeString(this.name);
        dest.writeString(this.content);
        dest.writeString(this.show);
    }

    public Youwan() {
    }

    protected Youwan(Parcel in) {
        this.img = in.readInt();
        this.name = in.readString();
        this.content = in.readString();
        this.show = in.readString();
    }

    public static final Parcelable.Creator<Youwan> CREATOR = new Parcelable.Creator<Youwan>() {
        @Override
        public Youwan createFromParcel(Parcel source) {
            return new Youwan(source);
        }

        @Override
        public Youwan[] newArray(int size) {
            return new Youwan[size];
        }
    };
}

package com.android.settings.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParcelable implements Parcelable {
    private int oldStandard;
    private int confirmTimes;


    public int getOldStandard() {
        return oldStandard;
    }
    public int getConfirmTimes() {
        return confirmTimes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        oldStandard = dest.readInt();
        // 继续添加
    }

    /**
     * 给Resolution留的接口
     * */
    public MyParcelable(int oldStandard, int confirmTimes) {
        this.oldStandard = oldStandard;
        this.confirmTimes = confirmTimes;
    }



    private MyParcelable(Parcel in) {
        oldStandard = in.readInt();
        // 继续添加
    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel source) {
            return new MyParcelable(source);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

}

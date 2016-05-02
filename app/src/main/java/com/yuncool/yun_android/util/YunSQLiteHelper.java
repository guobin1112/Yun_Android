package com.yuncool.yun_android.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yuncool.yun_android.model.UserInfoModel;

/**
 * Created by Black on 2016/5/2.
 */
public class YunSQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    public YunSQLiteHelper(Context context) {
        super(context, "YunDB", null, DATABASE_VERSION);
    }

    private static final String USER_INFO_TABLE_CREATE =
            "CREATE TABLE \"UserInfo\" (" +
                    "\"UserId\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                    "\"UserName\" VARCHAR  NOT NULL , " +
                    "\"Password\" VARCHAR  NOT NULL , " +
                    "\"PhoneNumber\" VARCHAR NOT NULL , " +
                    "\"Money\" FLOAT  NOT NULL , " +
                    "\"Gender\" INTEGER  NOT NULL , " +
                    "\"Discount\" FLOAT  NOT NULL , " +
                    "\"Address\" VARCHAR NOT NULL , " +
                    "\"RealName\" VARCHAR NOT NULL ) ";

    private static final String USER_INFO_TABLE_DROP =
            "drop table if exists UserInfo";

    public long register(UserInfoModel model) {
        ContentValues cv = new ContentValues();
        cv.put("UserName", model.userName);
        cv.put("Password", model.password);
        cv.put("Money", 0f);
        cv.put("Discount", 0f);
        cv.put("PhoneNumber", "");
        cv.put("Address", "");
        cv.put("RealName", "");
        cv.put("Gender", 1);

        SQLiteDatabase db = this.getWritableDatabase();
        long affectedRows = db.insert("UserInfo", "", cv);
        db.close();
        return affectedRows;

    }

    public UserInfoModel queryUserInfo(int userId) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.query("UserInfo", null,
                "UserId == ? ", new String[]{userId + ""}, null, null, null, null);
        UserInfoModel model = null;
        while (cur.moveToNext()) {
            model = new UserInfoModel();
            model.userId = cur.getInt(cur.getColumnIndex("UserId"));
            model.phoneNumber = cur.getString(cur.getColumnIndex("PhoneNumber"));
            model.userName = cur.getString(cur.getColumnIndex("UserName"));
            model.money = cur.getFloat(cur.getColumnIndex("Money"));
            model.discount = cur.getFloat(cur.getColumnIndex("Discount"));
            model.address = cur.getString(cur.getColumnIndex("Address"));
            model.realName = cur.getString(cur.getColumnIndex("RealName"));

            break;
        }
        db.close();
        return model;

    }


    public long updateUserInfo(int userId, String realName, int gender, String phoneNumber, String address, boolean isFirstUpdate) {

        ContentValues cv = new ContentValues();
        cv.put("PhoneNumber", phoneNumber);
        cv.put("RealName", realName);
        cv.put("Gender", gender);
        cv.put("Address", address);

        if (isFirstUpdate) {
            cv.put("Money", queryUserInfo(userId).money + 10);
        }

        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = {String.valueOf(userId)};
        long affectedRows = db.update("UserInfo", cv, "UserId=?", args);
        db.close();
        return affectedRows;

    }

    public UserInfoModel login(String account, String password) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.query("UserInfo", null,
                "PhoneNumber == ? and Password ==?", new String[]{account, password}, null, null, null, null);
        UserInfoModel model = null;
        while (cur.moveToNext()) {
            model = new UserInfoModel();
            model.userId = cur.getInt(cur.getColumnIndex("UserId"));
            model.phoneNumber = cur.getString(cur.getColumnIndex("PhoneNumber"));
            model.userName = cur.getString(cur.getColumnIndex("UserName"));
            model.money = cur.getFloat(cur.getColumnIndex("Money"));
            model.discount = cur.getFloat(cur.getColumnIndex("Discount"));
            model.address = cur.getString(cur.getColumnIndex("Address"));
            model.realName = cur.getString(cur.getColumnIndex("RealName"));

            break;
        }

        if (model != null) {

            db.close();
            return model;

        } else {

            cur = db.query("UserInfo", null,
                    "UserName == ? and Password ==?", new String[]{account, password}, null, null, null, null);
            while (cur.moveToNext()) {
                model = new UserInfoModel();
                model.userId = cur.getInt(cur.getColumnIndex("UserId"));
                model.phoneNumber = cur.getString(cur.getColumnIndex("PhoneNumber"));
                model.userName = cur.getString(cur.getColumnIndex("UserName"));
                model.money = cur.getFloat(cur.getColumnIndex("Money"));
                model.discount = cur.getFloat(cur.getColumnIndex("Discount"));
                model.address = cur.getString(cur.getColumnIndex("Address"));
                model.realName = cur.getString(cur.getColumnIndex("RealName"));
                break;
            }

            db.close();

            return model;

        }

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(USER_INFO_TABLE_CREATE);//创建用户记录表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

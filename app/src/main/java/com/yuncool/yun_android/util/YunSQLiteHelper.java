package com.yuncool.yun_android.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yuncool.yun_android.model.FileModel;
import com.yuncool.yun_android.model.ShopModel;
import com.yuncool.yun_android.model.UserInfoModel;

import java.util.ArrayList;
import java.util.List;

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

    private static final String FILE_UPLOADED_TABLE_CREATE =
            "CREATE TABLE \"FileUploaded\" (" +
                    "\"FileId\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                    "\"FileName\" VARCHAR  NOT NULL , " +
                    "\"FileType\" INTEGER  NOT NULL , " +
                    "\"UserId\" INTEGER  NOT NULL ) ";

    private static final String SHOP_TABLE_CREATE =
            "CREATE TABLE \"ShopInfo\" (" +
                    "\"ShopId\" INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL , " +
                    "\"ShopName\" VARCHAR  NOT NULL , " +
                    "\"ShopImageResId\" INTEGER  NOT NULL , " +
                    "\"ShopPartName\" VARCHAR NOT NULL , " +
                    "\"ShopAddress\" VARCHAR  NOT NULL , " +
                    "\"ShopPhoneNumber\" VARCHAR  NOT NULL , " +
                    "\"Discount\" FLOAT  NOT NULL , " +
                    "\"Area\" VARCHAR NOT NULL ) ";

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


    public long updateUserInfo(int userId, String realName, int gender,
                               String phoneNumber, String address, boolean isFirstUpdate) {

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

    public long addMoney(int userId, float addMoney) {

        ContentValues cv = new ContentValues();
        cv.put("Money", queryUserInfo(userId).money + addMoney);

        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = {String.valueOf(userId)};
        long affectedRows = db.update("UserInfo", cv, "UserId=?", args);
        db.close();
        return affectedRows;
    }

    public long addDiscount(int userId, float addDiscount) {

        ContentValues cv = new ContentValues();
        cv.put("Discount", queryUserInfo(userId).discount + addDiscount);

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

    public List<FileModel> getFileList(int userId, int fileType) {
        List<FileModel> modelList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.query("FileUploaded", null,
                "UserId == ? and FileType=? ", new String[]{userId + "", fileType + ""}, null, null, null, null);
        FileModel model = null;
        while (cur.moveToNext()) {
            model = new FileModel();
            model.fileId = cur.getInt(cur.getColumnIndex("FileId"));
            model.fileName = cur.getString(cur.getColumnIndex("FileName"));
            model.fileType = cur.getInt(cur.getColumnIndex("FileType"));
            model.userId = cur.getInt(cur.getColumnIndex("UserId"));
            modelList.add(model);

            break;
        }
        db.close();
        return modelList;
    }

    public List<FileModel> getFileList(int userId) {
        List<FileModel> modelList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.query("FileUploaded", null,
                "UserId == ?", new String[]{userId + ""}, null, null, null, null);
        FileModel model = null;
        while (cur.moveToNext()) {
            model = new FileModel();
            model.fileId = cur.getInt(cur.getColumnIndex("FileId"));
            model.fileName = cur.getString(cur.getColumnIndex("FileName"));
            model.fileType = cur.getInt(cur.getColumnIndex("FileType"));
            model.userId = cur.getInt(cur.getColumnIndex("UserId"));
            modelList.add(model);

            break;
        }
        db.close();
        return modelList;
    }

    public long upLoadFile(int userId, FileModel model) {
        ContentValues cv = new ContentValues();
        cv.put("FileName", model.fileName);
        cv.put("FileType", model.fileType);
        cv.put("UserId", userId);

        SQLiteDatabase db = this.getWritableDatabase();
        long affectedRows = db.insert("FileUploaded", "", cv);
        db.close();
        return affectedRows;

    }

    public List<ShopModel> getShopList() {
        List<ShopModel> modelList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.query("ShopInfo", null,
                null, null, null, null, null);
        ShopModel model = null;
        while (cur.moveToNext()) {
            model = new ShopModel();
            model.shopId = cur.getInt(cur.getColumnIndex("ShopId"));
            model.shopName = cur.getString(cur.getColumnIndex("ShopName"));
            model.shopImageResId = cur.getInt(cur.getColumnIndex("ShopImageResId"));
            model.shopPartName = cur.getString(cur.getColumnIndex("ShopPartName"));
            model.shopAddress = cur.getString(cur.getColumnIndex("ShopAddress"));
            model.shopPhoneNumber = cur.getString(cur.getColumnIndex("ShopPhoneNumber"));
            model.discount = cur.getFloat(cur.getColumnIndex("Discount"));
            model.area = cur.getString(cur.getColumnIndex("Area"));

            modelList.add(model);

            break;
        }
        db.close();
        return modelList;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(USER_INFO_TABLE_CREATE);
        sqLiteDatabase.execSQL(FILE_UPLOADED_TABLE_CREATE);
        sqLiteDatabase.execSQL(SHOP_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

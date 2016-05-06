package com.yuncool.yun_android.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Black on 2016/2/12.
 */
public class ShopModel implements Parcelable {
    public int shopId;
    public int shopImageResId;
    public String shopName;
    public String area;
    public String shopPartName;
    public String shopAddress;
    public String shopPhoneNumber;
    public float discount;

    public ShopModel() {
    }

    public ShopModel(int shopImageResId, String shopName) {
        this.shopImageResId = shopImageResId;
        this.shopName = shopName;
    }

    public ShopModel(String shopName, String area, int shopImageResId) {
        this.shopName = shopName;
        this.area = area;
        this.shopImageResId = shopImageResId;
    }

    public ShopModel(int shopId, int shopImageResId, String shopName, String area,
                     String shopPartName, String shopAddress, String shopPhoneNumber, float discount) {
        this.shopId = shopId;
        this.shopImageResId = shopImageResId;
        this.shopName = shopName;
        this.area = area;
        this.shopPartName = shopPartName;
        this.shopAddress = shopAddress;
        this.shopPhoneNumber = shopPhoneNumber;
        this.discount = discount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.shopId);
        dest.writeInt(this.shopImageResId);
        dest.writeString(this.shopName);
        dest.writeString(this.area);
        dest.writeString(this.shopPartName);
        dest.writeString(this.shopAddress);
        dest.writeString(this.shopPhoneNumber);
        dest.writeFloat(this.discount);
    }

    protected ShopModel(Parcel in) {
        this.shopId = in.readInt();
        this.shopImageResId = in.readInt();
        this.shopName = in.readString();
        this.area = in.readString();
        this.shopPartName = in.readString();
        this.shopAddress = in.readString();
        this.shopPhoneNumber = in.readString();
        this.discount = in.readFloat();
    }

    public static final Parcelable.Creator<ShopModel> CREATOR = new Parcelable.Creator<ShopModel>() {
        @Override
        public ShopModel createFromParcel(Parcel source) {
            return new ShopModel(source);
        }

        @Override
        public ShopModel[] newArray(int size) {
            return new ShopModel[size];
        }
    };
}

package com.yuncool.yun_android.model;

/**
 * Created by Black on 2016/2/12.
 */
public class ShopModel {
    public int shopImageResId;
    public String shopName;
    public String area;

    public ShopModel(int shopImageResId, String shopName) {
        this.shopImageResId = shopImageResId;
        this.shopName = shopName;
    }

    public ShopModel(String shopName, String area) {
        this.shopName = shopName;
        this.area = area;
    }
}

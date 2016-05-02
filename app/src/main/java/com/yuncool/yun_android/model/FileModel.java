package com.yuncool.yun_android.model;

/**
 * Created by Black on 2016/3/17.
 */
public class FileModel {
    public int fileId;
    public String fileName;
    public String filePath;
    public String fileUrl;
    public int fileType;
    public int userId;

    public static final int DOC = 1;
    public static final int PPT = 2;
    public static final int XLS = 3;
    public static final int PDF = 4;
    public static final int TXT = 5;
    public static final int OTHER = 6;
}

package com.yuncool.yun_android.util;

import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Black on 2016/3/15.
 */
public class Base64Helper {


    /**
     * base64 编码
     *
     * @param path
     * @return
     */
    public static String base64Encode(String path) {

        File file = new File(path);

        byte[] bytes = getBytesFromFile(file);

        String strBase64 = new String(Base64.encode(bytes, Base64.DEFAULT));

        return strBase64;
    }

    /**
     * 文件转化为byte流
     *
     * @param f
     * @return
     */
    public static byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

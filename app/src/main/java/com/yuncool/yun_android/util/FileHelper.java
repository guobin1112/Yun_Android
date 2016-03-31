package com.yuncool.yun_android.util;

import android.os.Environment;

import com.yuncool.yun_android.model.FileModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Black on 2016/3/17.
 */
public class FileHelper {

    public static List<String> searchResultFileNameList = new ArrayList<>();

    public static boolean HasSDCard() {

        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

    }

    public static String getRootPath() {

        if (HasSDCard()) {

            return Environment.getExternalStorageDirectory().getPath();

        } else {
            return "";
        }

    }

    public static List<FileModel> getFileList(String path) {

        File root = new File(path);

        if (root.exists()) {

            File[] files = root.listFiles();

            List<FileModel> fileModelList = new ArrayList<>();

            for (int i = 0; i < files.length; i++) {

                FileModel model = new FileModel();

                model.fileName = files[i].getName();

                model.filePath = files[i].getPath();

                fileModelList.add(model);

            }

            return fileModelList;


        } else {
            return null;
        }

    }

    private static void search(String rootPath, String keyWord)

    {

        try {

            File root = new File(rootPath);

            if (root != null) {

                File[] files = root.listFiles();

                if (files.length > 0)

                {

                    for (int j = 0; j < files.length; j++)

                    {

                        if (!files[j].isDirectory())

                        {

                            if (files[j].getName().indexOf(keyWord) > -1)

                            {
                                searchResultFileNameList.add(files[j].getName());

                            }

                        } else {

                            search(files[j].getPath(), keyWord);

                        }

                    }
                }

            } else {

                return;

            }

        } catch (Exception e)

        {


        }

    }


}

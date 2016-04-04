package com.yuncool.yun_android.util;

/**
 * Created by Black on 2016/4/4.
 */
public class Constant {

    public static class IntentArgs {
        public static final String INT_FILE_TYPE = "fileType";
    }

    public enum FileType {
        LOCAL("local", 1), DOC("doc", 2), PPT("ppt", 3), XLS("xls", 4), PDF("pdf", 5), TXT("txt", 6), OTHER("other", 7);

        private int val;
        private String des;

        FileType(String des, int val) {
            this.val = val;
            this.des = des;
        }


        public static String getDes(int val) {

            for (FileType item : FileType.values()) {
                if (item.val == val) {
                    return item.des;
                }
            }

            return "";
        }

        public static int getVal(String des) {
            for (FileType item : FileType.values()) {
                if (item.des == des) {
                    return item.val;
                }
            }

            return 0;
        }

        public String getDes() {
            return des;
        }

        public int getVal() {
            return val;
        }
    }

}

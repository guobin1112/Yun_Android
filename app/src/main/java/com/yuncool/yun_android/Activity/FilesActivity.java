package com.yuncool.yun_android.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.FileModel;
import com.yuncool.yun_android.util.Constant;
import com.yuncool.yun_android.util.FileHelper;
import com.yuncool.yun_android.util.YunSQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class FilesActivity extends BaseActivity {

    private static final int FILE_SELECT_CODE = 1;
    private ListView lv_file;
    private List<FileModel> fileList = new ArrayList<>();
    private List<String> fileNameList = new ArrayList<>();

    private String path;
    private int fileType;

    private YunSQLiteHelper yunSqliteHelper;

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_files);

        yunSqliteHelper = new YunSQLiteHelper(this);

        fileType = getIntent().getIntExtra(Constant.IntentArgs.INT_FILE_TYPE, 0);
        queue = Volley.newRequestQueue(FilesActivity.this);

        if (fileType == Constant.FileType.LOCAL.getVal()) {
            //local
            path = FileHelper.getRootPath() + "/yun/";

            fileList = FileHelper.getFileList(path);

            fileNameList.clear();

            for (FileModel model : fileList) {

                fileNameList.add(model.fileName);

            }

            lv_file = (ListView) findViewById(R.id.lv_file);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    FilesActivity.this, android.R.layout.simple_list_item_1, fileNameList);

            lv_file.setAdapter(adapter);

            lv_file.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });

            //暂时屏蔽调用接口
//            lv_file.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
//
//                    String url = "http://115.28.221.169:12345/uploadFile.ashx";
//
//                    // Request a string response from the provided URL.
//                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                            new Response.Listener<String>() {
//                                @Override
//                                public void onResponse(String response) {
//                                    Toast.makeText(FilesActivity.this, response, Toast.LENGTH_SHORT).show();
//                                }
//                            }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(FilesActivity.this, fileNameList.get(i) + "上传失败", Toast.LENGTH_SHORT);
//                        }
//                    }) {
//                        @Override
//                        protected Map<String, String> getParams() throws AuthFailureError {
//
//                            HashMap<String, String> params = new HashMap<>();
//                            params.put("fileName", fileNameList.get(i));
//                            params.put("fileBase64String", Base64Helper.base64Encode(path + fileNameList.get(i)));
//
//                            return params;
//                        }
//                    };
//
//                    // Add the request to the RequestQueue.
//                    queue.add(stringRequest);
//                }
//            });
//
//        } else {
//            //server
//
//            // Instantiate the RequestQueue.
//
//            String url = "http://115.28.221.169:12345/getFileList.ashx?type="
//                    + Constant.FileType.getDes(fileType);
//
//            // Request a string response from the provided URL.
//            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//
//                            Gson gson = new Gson();
//                            FileListModel model = gson.fromJson(response, FileListModel.class);
//
//                            if (model.fileList.size() > 0) {
//
//                                fileList = model.fileList;
//
//                                fileNameList.clear();
//
//                                for (FileModel item : fileList) {
//
//                                    fileNameList.add(item.fileName);
//                                }
//
//                                lv_file = (ListView) findViewById(R.id.lv_file);
//
//                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                                        FilesActivity.this, android.R.layout.simple_list_item_1, fileNameList);
//
//                                lv_file.setAdapter(adapter);
//
//                            } else {
//                                Toast.makeText(FilesActivity.this, "你暂时还没有上传该类文件哦", Toast.LENGTH_SHORT).show();
//                            }
//
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(FilesActivity.this, "获取失败，请重试", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            // Add the request to the RequestQueue.
//            queue.add(stringRequest);
//
//        }
        }

    }

}

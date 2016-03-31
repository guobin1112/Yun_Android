package com.yuncool.yun_android.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.FileModel;
import com.yuncool.yun_android.util.Base64Helper;
import com.yuncool.yun_android.util.FileHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalFilesActivity extends Activity {

    private ListView lv_file;
    private List<FileModel> fileList = new ArrayList<>();
    private List<String> fileNameList = new ArrayList<>();

    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_files);

        path = FileHelper.getRootPath() + "/yun/";


        fileList = FileHelper.getFileList(path);

        fileNameList.clear();

        for (FileModel model : fileList) {

            fileNameList.add(model.fileName);

        }

        lv_file = (ListView) findViewById(R.id.lv_file);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                LocalFilesActivity.this, android.R.layout.simple_list_item_1, fileNameList);

        lv_file.setAdapter(adapter);

        lv_file.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                // Instantiate the RequestQueue.
                final RequestQueue queue = Volley.newRequestQueue(LocalFilesActivity.this);
                String url = "http://115.28.221.169:12345/uploadFile.ashx";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(LocalFilesActivity.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LocalFilesActivity.this, fileNameList.get(i) + "上传失败", Toast.LENGTH_SHORT);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap<String, String> params = new HashMap<>();
                        params.put("fileName", fileNameList.get(i));
                        params.put("fileBase64String", Base64Helper.base64Encode(path + fileNameList.get(i)));

                        return params;
                    }
                };

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });


    }
}

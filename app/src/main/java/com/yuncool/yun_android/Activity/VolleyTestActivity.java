package com.yuncool.yun_android.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.util.Base64Helper;

import java.util.HashMap;
import java.util.Map;

public class VolleyTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_test);

        final TextView mTextView = (TextView) findViewById(R.id.text);

        final String mTag = "TAG";

        // Instantiate the RequestQueue.
        final RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://115.28.221.169:12345/uploadFile.ashx";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(VolleyTestActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                String path = Environment.getExternalStorageDirectory().getPath();

                HashMap<String, String> params = new HashMap<>();
                params.put("fileName", "a.txt");
                params.put("fileBase64String", Base64Helper.base64Encode(path + "/a.txt"));

                return params;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}

package com.yuncool.yun_android.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuncool.yun_android.MainApplication;
import com.yuncool.yun_android.R;
import com.yuncool.yun_android.model.FileModel;
import com.yuncool.yun_android.util.Constant;
import com.yuncool.yun_android.util.YunSQLiteHelper;

public class MyDocumentActivity extends BaseActivity implements View.OnClickListener {

    private static final int FILE_SELECT_CODE = 1;
    private Button btn_doc, btn_ppt, btn_xls, btn_pdf, btn_txt, btn_other, btn_category, btn_common_softwafe;
    private TextView tv_download, tv_print;
    YunSQLiteHelper yunSqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_document);

        initData();
        initView();
        initEvent();
    }

    private void initData() {
        yunSqliteHelper = new YunSQLiteHelper(this);

    }

    private void initView() {

        btn_doc = (Button) findViewById(R.id.btn_doc);
        btn_ppt = (Button) findViewById(R.id.btn_ppt);
        btn_xls = (Button) findViewById(R.id.btn_xls);
        btn_pdf = (Button) findViewById(R.id.btn_pdf);
        btn_txt = (Button) findViewById(R.id.btn_txt);
        btn_other = (Button) findViewById(R.id.btn_other);
        btn_category = (Button) findViewById(R.id.btn_category);
        btn_common_softwafe = (Button) findViewById(R.id.btn_common_software);
        tv_download = (TextView) findViewById(R.id.tv_download);
        tv_print = (TextView) findViewById(R.id.tv_print);

    }

    private void initEvent() {

        btn_doc.setOnClickListener(this);
        btn_ppt.setOnClickListener(this);
        btn_xls.setOnClickListener(this);
        btn_pdf.setOnClickListener(this);
        btn_txt.setOnClickListener(this);
        btn_other.setOnClickListener(this);
        btn_category.setOnClickListener(this);
        btn_common_softwafe.setOnClickListener(this);
        tv_download.setOnClickListener(this);
        tv_print.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {
            case R.id.btn_doc:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, FileModel.DOC);
                startActivity(intent);

                break;
            case R.id.btn_ppt:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, FileModel.PPT);
                startActivity(intent);

                break;
            case R.id.btn_xls:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, FileModel.XLS);
                startActivity(intent);

                break;
            case R.id.btn_pdf:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, FileModel.PDF);
                startActivity(intent);

                break;
            case R.id.btn_txt:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, FileModel.TXT);
                startActivity(intent);

                break;
            case R.id.btn_other:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, FileModel.OTHER);
                startActivity(intent);
                break;

            case R.id.btn_category:

                showFileChooser();

                break;
            case R.id.btn_common_software:

                Toast.makeText(MyDocumentActivity.this, "正在开发中,敬请期待!", Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_download:

                intent = new Intent(MyDocumentActivity.this, FilesActivity.class);
                intent.putExtra(Constant.IntentArgs.INT_FILE_TYPE, Constant.FileType.LOCAL.getVal());
                startActivity(intent);

                break;
            case R.id.tv_print:

                intent = new Intent(MyDocumentActivity.this, PrintActivity.class);
                startActivity(intent);

                break;
        }
    }


    /**
     * 调用文件选择软件来选择文件
     **/
    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try {
            startActivityForResult(Intent.createChooser(intent, "请选择一个要上传的文件"),
                    FILE_SELECT_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(MyDocumentActivity.this, "请安装文件管理器", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    /**
     * 根据返回选择的文件，来进行上传操作
     **/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            // Get the Uri of the selected file
            Uri uri = data.getData();

            FileModel model = new FileModel();

            model.fileName = uri.toString().substring(uri.toString().lastIndexOf("/") + 1);
            model.fileType = getFileType(model.fileName);

            showProgressDialog();


            if (yunSqliteHelper.upLoadFile(MainApplication.getLoginUserInfo().userId, model) > 0) {
                Toast.makeText(MyDocumentActivity.this, "文件上传成功，请在“上传文件-待打印”中查看", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MyDocumentActivity.this, "文件上传失败啦，退出再试试吧", Toast.LENGTH_SHORT).show();
            }


        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public int getFileType(String fileName) {

        String typeStr = fileName.substring(fileName.lastIndexOf(".") + 1);

        if (typeStr.equals("doc") || typeStr.equals("docx")) {
            return FileModel.DOC;
        }

        if (typeStr.equals("ppt") || typeStr.equals("pptx")) {
            return FileModel.PPT;
        }

        if (typeStr.equals("xls") || typeStr.equals("xlsx")) {
            return FileModel.XLS;
        }

        if (typeStr.equals("pdf")) {
            return FileModel.PDF;
        }

        if (typeStr.equals("txt") || typeStr.equals("docx")) {
            return FileModel.TXT;
        }

        return FileModel.OTHER;
    }

}

package com.ztnhlwc.paragraphlwc;

import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.ztnhlwc.baselibrary.ioc.ViewUtils;
import com.ztnhlwc.framelibrary.BaseSkinActivity;

import java.io.File;
import java.io.IOException;

public class MainActivity extends BaseSkinActivity implements View.OnClickListener {


    @Override
    protected void initData() {

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

        this.findViewById(R.id.tv_test).setOnClickListener(this);

        //上传异常信息到服务器


        //测试，直接获取本地内存卡里面的fix.apatch
        File fileFix = new File(Environment.getExternalStorageDirectory(), "fix.apatch");
        if (fileFix.exists()) {
            //修复bug
            try {
                BaseApplication.getInstanse().mPatchManager.addPatch(fileFix.getAbsolutePath());
                Toast.makeText(this, "修复成功", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "修复失败", Toast.LENGTH_LONG).show();
            }

        }


    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
        ViewUtils.inJect(this);

    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this, 2 / 1 + "=test ioc", Toast.LENGTH_LONG).show();
    }
}

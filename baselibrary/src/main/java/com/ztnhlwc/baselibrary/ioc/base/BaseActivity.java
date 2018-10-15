package com.ztnhlwc.baselibrary.ioc.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @Description: BaseActivity
 * @Author: lingwancai
 * @Time: 2018/10/15 13:54
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局layout
        setContentView();
        //初始化view
        initView();
        //初始化title头部
        initTitle();
        //初始化数据
        initData();

    }

    protected abstract void initData();

    protected abstract void initTitle();

    protected abstract void initView();

    protected abstract void setContentView();

    /**
     * 启动Activity
     *
     * @param clazz
     */
    public void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


}

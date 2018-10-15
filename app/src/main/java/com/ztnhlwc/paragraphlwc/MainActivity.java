package com.ztnhlwc.paragraphlwc;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ztnhlwc.baselibrary.ioc.OnClick;
import com.ztnhlwc.baselibrary.ioc.ViewById;
import com.ztnhlwc.baselibrary.ioc.ViewUtils;
import com.ztnhlwc.framelibrary.BaseSkinActivity;

public class MainActivity extends BaseSkinActivity {


    @ViewById(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void initData() {

    }

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
        ViewUtils.inJect(this);

    }


    @OnClick(R.id.tv_test)
    public void onClick(View view){
        Toast.makeText(this,"test ioc",Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.iv_test)
    private void onImageOnClick(){
        Toast.makeText(this,"iv onclick ioc",Toast.LENGTH_LONG).show();
    }

}

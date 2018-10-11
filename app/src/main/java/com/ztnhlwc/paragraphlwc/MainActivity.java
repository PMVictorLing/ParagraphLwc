package com.ztnhlwc.paragraphlwc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ztnhlwc.baselibrary.ioc.OnClick;
import com.ztnhlwc.baselibrary.ioc.ViewById;
import com.ztnhlwc.baselibrary.ioc.ViewUtils;

public class MainActivity extends AppCompatActivity {


    @ViewById(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewUtils.inJect(this);

        tvTest.setText("ioc注解");

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

package com.ztnhlwc.paragraphlwc;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * Created by lingwancai on
 * 2018/10/16 15:02
 */
public class BaseApplication extends Application {


    private static BaseApplication mInstanse;
    public PatchManager mPatchManager;

    public static BaseApplication getInstanse() {
        return mInstanse;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstanse = this;

        //初始化全局的异常捕获


        //初始化阿里热修复
        mPatchManager = new PatchManager(this);
        mPatchManager.init(getPackageNames());
        //加载之前的patch
        mPatchManager.loadPatch();


    }

    /**
     *
     * 获取应用版本name
     *
     * @return
     */
    public String getPackageNames() {
        PackageManager manager = this.getPackageManager();
        String name = null;
        try {
            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
            name = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return name;
    }
}




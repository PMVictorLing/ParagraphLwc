package com.ztnhlwc.baselibrary.ioc;

import android.app.Activity;
import android.view.View;

import com.ztnhlwc.baselibrary.R;

/**
 * View的FindById的辅助类
 *
 * Created by lingwancai on
 * 2018/10/11 16:16
 */
public class ViewFinder {
    private Activity mActivity;
    private View mView;

    public ViewFinder(Activity activity){
        this.mActivity = activity;
    }

    public ViewFinder(View view){
        this.mView= view;
    }

    public View findViewById(int viewId){
        return mActivity != null ? mActivity.findViewById(viewId) : mView.findViewById(viewId);
    }
}

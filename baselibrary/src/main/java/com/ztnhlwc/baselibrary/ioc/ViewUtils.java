package com.ztnhlwc.baselibrary.ioc;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解工具类
 * <p>
 * Created by lingwancai on
 * 2018/10/11 16:07
 */
public class ViewUtils {
    //在activity中
    public static void inJect(Activity activity) {
        inJect(new ViewFinder(activity), activity);
    }

    //在view中
    public static void inJect(View view) {
        inJect(new ViewFinder(view), view);
    }

    //在fragment
    public static void inJect(View view, Object object) {
        inJect(new ViewFinder(view), object);
    }

    //兼容 上面三个方法 object --> 反射需要执行的类
    private static void inJect(ViewFinder finder, Object object) {
        inJectFeild(finder, object);
        inJectEvent(finder, object);

    }

    /**
     * 注入事件--与注入属性思路一样
     *
     * @param finder
     * @param object
     */
    private static void inJectEvent(ViewFinder finder, Object object) {
        //1.获取类里面所有的方法
        Class<?> clazz = object.getClass();
        //包括共有和私有的
        Method[] methods = clazz.getDeclaredMethods();
        //2.循环遍历所有方法找到value
        for (Method method : methods) {
            OnClick onClick = method.getAnnotation(OnClick.class);
            if (onClick != null) {
                int viewId = onClick.value();
                //3.通过findViewById 找到View
                View view = finder.findViewById(viewId);
                //4.设置view.setOnclickListener 请查看View 源码DeclaredOnClickListener
                view.setOnClickListener(new DeclaredOnClickListener(method, object));
            }

        }


    }

    /**
     * 注入属性
     *
     * @param finder
     * @param object
     */
    private static void inJectFeild(ViewFinder finder, Object object) {
        //思路
        //1.获取类里面所有的属性
        Class<?> clazz = object.getClass();
        //包括私有和共有的
        Field[] fields = clazz.getDeclaredFields();

        //2.获取ViewById里面的value值
        for (Field field : fields) {
            ViewById viewById = field.getAnnotation(ViewById.class);
            if (viewById != null) {
                //获取注解里面的id值 --> R.id.tv_test
                int viewId = viewById.value();
                //3.通过viewId findViewById 找到View
                View view = finder.findViewById(viewId);
                if (view != null) {
                    //能够注入所有的修饰符 public private pretote...
                    field.setAccessible(true);
                    //4.动态注入找到的View
                    try {
                        field.set(object, view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    private static class DeclaredOnClickListener implements View.OnClickListener {
        private Method mMethod;
        private Object mObject;

        /**
         * 点击会调用该方法
         *
         * @param v
         */
        @Override
        public void onClick(View v) {
            try {
                //所有的方法都可以 共有和私有
                mMethod.setAccessible(true);
                //5.反射执行方法
                mMethod.invoke(mObject, v);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    mMethod.invoke(mObject, null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }


        }

        public DeclaredOnClickListener(Method method, Object object) {
            this.mMethod = method;
            this.mObject = object;
        }
    }
}

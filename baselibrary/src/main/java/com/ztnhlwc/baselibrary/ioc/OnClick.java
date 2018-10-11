package com.ztnhlwc.baselibrary.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * View注解的Annotation
 *
 * Created by lingwancai on
 * 2018/10/11 15:30
 */
@Target(ElementType.METHOD)//代表Annotation的位置 FIELD属性 METHOD方法 type类上 Constructor构造函数上
@Retention(RetentionPolicy.RUNTIME)//什么时候生效 CLASS编译时 RUNTIME运行时 SOURCE源码资源
public @interface OnClick {
    //-->@ViewById(R.id.xxx)
    int value();
}

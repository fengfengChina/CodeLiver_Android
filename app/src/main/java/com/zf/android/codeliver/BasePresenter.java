package com.zf.android.codeliver;

import android.content.Context;

/**
 * Created by zengfeng on 16/4/25.
 */
public abstract class BasePresenter <T extends BaseView>{

    protected Context context;
    protected T iView;


    public BasePresenter(Context context, T iView) {
        this.context = context;
        this.iView = iView;
    }


    public void init(){
        iView.initView();
    }


}

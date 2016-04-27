package com.zf.android.codeliver;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;

/**
 * Created by zengfeng on 16/4/27.
 */
public abstract class BaseActivity<T extends BasePresenter> extends Activity {
    String TAG = this.getClass().getSimpleName();
    T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        initPresenter();
    }

    protected abstract void initPresenter();

    protected abstract int getLayoutResId();

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
        Log.i(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onResume(this);
        Log.i(TAG, "onPause");

    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        Log.i(TAG, "onDestroy");

    }



}

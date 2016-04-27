package com.zf.android.codeliver.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.zf.android.codeliver.R;

/**
 * Created by zengfeng on 16/4/27.
 */
public class EmptyLayout extends RelativeLayout {
    private ImageView errorView;
    private ImageView noDateView;
    private View loadingView;

    private Context context;
    private EmtryListner mListner;
    private int errorDrawable;
    private int noDateDrawable;



    public enum State {
        LOADING,NODATA,ERROR,NOMAL
    }

    public EmptyLayout(Context context) {
        super(context);
    }
    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public EmptyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }

    /**
     * 初始化view
     */
    private void initView(Context context,AttributeSet attrs) {
        this.context = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EmtryLayout);
        errorDrawable = a.getResourceId(R.styleable.EmptyLayout_errorDrawable, -1);
        noDateDrawable = a.getResourceId(R.styleable.EmptyLayout_noDataDrawable, -1);
        if (errorDrawable == -1 && noDateDrawable == -1 ) throw new IllegalArgumentException("please set errorDrawable or noDateDrawable in your xml");
        initErrorView();
        initNoDataView();
        initLoadingView();
        setState(State.LOADING);
    }

    /**
     * 初始化loading status
     */
    private void initLoadingView() {
        loadingView = new ProgressBar(context);
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        p.addRule(CENTER_IN_PARENT);
        loadingView.setLayoutParams(p);
        addView(loadingView);
    }

    /**
     * 设置状态
     * @param state
     */
    public void setState(State state){
        switch (state){
            case LOADING:
                setViewState(loadingView);
                break;
            case NODATA:
                setViewState(noDateView);
                break;
            case ERROR:
                setViewState(errorView);
                break;

        }
    }
    /**
     * 设置状态
     * @param state
     */
    public void setState(State state,View yourChildView){
        switch (state){
            case LOADING:
                setViewState(loadingView);
                break;
            case NODATA:
                setViewState(noDateView);
                break;
            case ERROR:
                setViewState(errorView);
                break;
            case NOMAL:
                setViewState(yourChildView);
                break;
        }
    }

    /**
     * 设置emtryState
     * @param viewState
     */
    public void setViewState(View viewState) {
        this.removeAllViews();
        addView(viewState);
//        viewState.setVisibility(View.VISIBLE);
    }


    /**
     * 回调监听
     */
    public interface EmtryListner {
        void onNoDataClick();
        void onErrorClick();
    }



    /**
     * 初始化无数据imageview
     */
    private void initNoDataView() {
        noDateView = new ImageView(context);
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        p.addRule(CENTER_IN_PARENT);
        noDateView.setLayoutParams(p);
        noDateView.setImageResource(noDateDrawable);
        noDateView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListner.onNoDataClick();
            }
        });
        addView(noDateView);
    }

    /**
     * 初始化error view
     */
    private void initErrorView() {
        errorView = new ImageView(context);
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        p.addRule(CENTER_IN_PARENT);
        errorView.setLayoutParams(p);
        errorView.setImageResource(errorDrawable);
        errorView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListner.onErrorClick();
            }
        });
        addView(errorView);
    }

    public EmtryListner getEmtryListner() {
        return mListner;
    }

    public void setEmtryListner(EmtryListner mListner) {
        this.mListner = mListner;
    }

    public ImageView getErrorView() {
        return errorView;
    }

    public void setErrorView(ImageView errorView) {
        this.errorView = errorView;
    }

    public ImageView getNoDateView() {
        return noDateView;
    }

    public void setNoDateView(ImageView noDateView) {
        this.noDateView = noDateView;
    }

}

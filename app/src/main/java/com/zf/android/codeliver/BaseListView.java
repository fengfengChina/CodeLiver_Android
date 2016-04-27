package com.zf.android.codeliver;

import java.util.List;

/**
 * Created by zengfeng on 16/4/27.
 */
public interface BaseListView extends BaseView<BasePresenter>{
    /**
     * 加载中
     */
    void showProgressBar();

    /**
     * 隐藏加载
     */
    void hideProgressBar();

    /**
     * 错误加载
     */
    void showErrorView();

    /**
     * 无更多数据
     */
    void showNoMoreData();


    /**
     * 刷新数据
     */
    void refreshData(List<?> objects);

    /**
     * 显示listview数据
     * @param gankList
     */
    void showListView(List<?> gankList);

}

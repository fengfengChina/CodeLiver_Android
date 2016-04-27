package com.zf.android.codeliver.welcome;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.zf.android.codeliver.BaseListView;
import com.zf.android.codeliver.BasePresenter;

import java.util.List;

/**
 * Created by zengfeng on 16/4/25.
 */
public class WelcomePresenter extends BasePresenter<BaseListView> {

    private WelcomeModel welcomeModel;
    public WelcomePresenter(Context context, BaseListView iView) {
        super(context, iView);
        welcomeModel = new WelcomeModel();
    }

    public void fetchData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                strings = welcomeModel.fetchData();
                if (strings == null) {
                  handler.sendEmptyMessage(1);
                }
                if (strings.size() == 0) {
                    handler.sendEmptyMessage(1);
                } else {
                    handler.sendEmptyMessage(1);
                }
            }
        }).start();
    }
    private List<String> strings;
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                iView.showErrorView();
            }
            if (msg .what== 2) {
                iView.showNoMoreData();
            } else {
                iView.showListView(strings);
            }
            return false;
        }
    });
}

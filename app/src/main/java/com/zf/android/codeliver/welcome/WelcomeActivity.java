package com.zf.android.codeliver.welcome;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zf.android.codeliver.BaseActivity;
import com.zf.android.codeliver.BaseListView;
import com.zf.android.codeliver.R;
import com.zf.android.codeliver.util.EmtryLayout;

import java.util.List;

import butterknife.Bind;

/**
 * Created by zengfeng on 16/4/25.
 */
public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements BaseListView {


    @Bind(R.id.rv_main_active)
    RecyclerView rvMainActive;
    WelcomePresenter welcomePresenter;
    @Bind(R.id.emtry_main_layout)
    EmtryLayout emtryMainLayout;

    @Override
    protected void initPresenter() {
        welcomePresenter = new WelcomePresenter(this, this);
        welcomePresenter.init();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.content_main;
    }

    @Override
    public void showProgressBar() {
        emtryMainLayout.setState(EmtryLayout.State.LOADING);
    }

    @Override
    public void hideProgressBar() {
        emtryMainLayout.setState(EmtryLayout.State.NOMAL,rvMainActive);
    }

    @Override
    public void showErrorView() {
        emtryMainLayout.setState(EmtryLayout.State.ERROR);
    }

    @Override
    public void showNoMoreData() {
        Toast.makeText(this,"showNoMoreData",Toast.LENGTH_LONG).show();
    }

    @Override
    public void refreshData(List<?> objects) {
        Toast.makeText(this,"refreshData",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showListView(final List<?> gankList) {
        WelcomeAdapter welcomeAdapter = new WelcomeAdapter(WelcomeActivity.this, (List<String>) gankList);
        rvMainActive.setAdapter(welcomeAdapter);
    }

    @Override
    public void initView() {
        emtryMainLayout.setEmtryListner(new EmtryLayout.EmtryListner() {
            @Override
            public void onNoDataClick() {
                Toast.makeText(WelcomeActivity.this,"onNoDataClick",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onErrorClick() {
                Toast.makeText(WelcomeActivity.this,"onErrorClick",Toast.LENGTH_LONG).show();
            }
        });
        welcomePresenter.fetchData();
    }

    static class WelcomeAdapter extends RecyclerView.Adapter<WelcomeAdapter.MyViewHolder>{
        List<String> data;
        Context context;
        WelcomeAdapter(Context context , List<String> data){
            this.context = context;
            this.data = data;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    context).inflate(android.R.layout.simple_list_item_1, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            MyViewHolder.tv.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            if (data == null) return 0;
            return data.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {
            static TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(android.R.id.text1);
            }
        }

    }
}

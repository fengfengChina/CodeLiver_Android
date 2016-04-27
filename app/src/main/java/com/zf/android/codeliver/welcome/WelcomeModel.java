package com.zf.android.codeliver.welcome;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by zengfeng on 16/4/27.
 */
public class WelcomeModel {

    public List<String> fetchData() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Lists.asList("1",new String[]{"2","3","4"});
    }
}

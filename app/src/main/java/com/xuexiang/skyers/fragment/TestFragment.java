/*
 * Copyright (C) 2021 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.skyers.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.next.easynavigation.view.EasyNavigationBar;
import com.xuexiang.skyers.R;
import com.xuexiang.skyers.activity.MainActivity;
import com.xuexiang.skyers.core.BaseFragment;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.widget.actionbar.TitleBar;
import com.xuexiang.xui.widget.actionbar.TitleUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Page(name = "测试主页")
public class TestFragment extends BaseFragment {

    @BindView(R.id.myEasyNavigationBar)
    EasyNavigationBar navigationBar;

    private String[] texts = new String[]{"广场","关注","消息","个人中心"};
    private List<Fragment> fragments = new ArrayList<>();

    private int[] unselected_icons = new int[]{R.drawable.ic_plaza,R.drawable.ic_attention,R.drawable.ic_message,R.drawable.ic_mine};
    private int[] selected_icons = new int[]{R.drawable.ic_plaza_selected,R.drawable.ic_attention_selected,R.drawable.ic_message_selected,R.drawable.ic_mine_selected};

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initPage() {
        initMainActionBar();
        initViews();
        initListeners();
    }

    protected void initMainActionBar(){
        
    }

    @Override
    protected void initViews() {

        fragments.add(new PlazaFragment());
        fragments.add(new AttentionFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());

        navigationBar.titleItems(texts)
                .normalIconItems(unselected_icons)
                .selectIconItems(selected_icons)
                .iconSize(32)
                .tabTextSize(10)
                .tabTextTop(2)
                .mode(EasyNavigationBar.NavigationMode.MODE_ADD)
                .centerTextStr("添加")
                .centerImageRes(R.drawable.ic_add)
                .centerIconSize(42)
                .centerLayoutHeight(80)
                .centerLayoutBottomMargin(12)
                .centerTextTopMargin(9)
                .fragmentList(fragments)
                .fragmentManager(getFragmentManager())
                .build();
    }
}

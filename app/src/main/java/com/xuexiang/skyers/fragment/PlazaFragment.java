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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.xuexiang.skyers.R;
import com.xuexiang.skyers.core.BaseFragment;
import com.xuexiang.skyers.fragment.tabs.Tab1Fragment;
import com.xuexiang.skyers.fragment.tabs.Tab2Fragment;
import com.xuexiang.skyers.fragment.tabs.Tab3Fragment;
import com.xuexiang.skyers.fragment.tabs.Tab4Fragment;
import com.xuexiang.skyers.fragment.tabs.Tab5Fragment;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.adapter.FragmentAdapter;
import com.xuexiang.xui.widget.actionbar.TitleBar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Page(name = "广场")
public class PlazaFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_container)
    ViewPager viewPager;

    private String[] pages = {"大厅","画廊","故事会","景点","寻友"};
    private List<Fragment> fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_plaza;
    }

    @Override
    protected TitleBar initTitle() {
        return null;
    }

    @Override
    protected void initViews() {
        FragmentAdapter<Fragment> adapter = new FragmentAdapter<>(getChildFragmentManager());
        fragments = new ArrayList<>();
        fragments.add(new Tab1Fragment());
        fragments.add(new Tab2Fragment());
        fragments.add(new Tab3Fragment());
        fragments.add(new Tab4Fragment());
        fragments.add(new Tab5Fragment());
        for (int i = 0; i < pages.length; i++){
            adapter.addFragment(fragments.get(i),pages[i]);
        }
        tabLayout.addOnTabSelectedListener(this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        
    }
}

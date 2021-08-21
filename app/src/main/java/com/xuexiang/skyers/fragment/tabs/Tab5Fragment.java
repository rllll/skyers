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

package com.xuexiang.skyers.fragment.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xuexiang.rxutil2.rxjava.DisposablePool;
import com.xuexiang.rxutil2.rxjava.RxJavaUtils;
import com.xuexiang.skyers.R;
import com.xuexiang.skyers.adapter.Tab3Adapter;
import com.xuexiang.skyers.adapter.Tab5Adapter;
import com.xuexiang.skyers.core.BaseFragment;
import com.xuexiang.skyers.entity.DataProvider;
import com.xuexiang.skyers.widget.CustomRefreshFooter;
import com.xuexiang.skyers.widget.CustomRefreshHeader;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xui.utils.WidgetUtils;
import com.xuexiang.xui.widget.actionbar.TitleBar;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

@Page(name = "寻友")
public class Tab5Fragment extends BaseFragment {

    @BindView(R.id.refreshFriends)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recyclerViewOfFriend)
    RecyclerView mRecyclerView;

    private Tab5Adapter mAdapter;
    
    private CustomRefreshHeader mRefreshHeader;

    private int progress = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tab5;
    }

    @Override
    protected TitleBar initTitle() {
        return null;
    }

    @Override
    protected void initViews() {
        WidgetUtils.initRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter = new Tab5Adapter());
        mRefreshLayout.setRefreshHeader(mRefreshHeader = new CustomRefreshHeader(getContext()));
        mRefreshLayout.setRefreshFooter(new CustomRefreshFooter(getContext()));
    }

    @Override
    protected void initListeners() {
        mRefreshLayout.setOnRefreshListener(refreshLayout -> handleRefresh());
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> refreshLayout.getLayout().postDelayed(() -> {
            mAdapter.loadMore(DataProvider.getFriend());
            refreshLayout.finishLoadMore();
        }, 2000));
        mRefreshLayout.autoRefresh();//第一次进入触发自动刷新，演示效果
    }
    private void handleRefresh() {
        progress = 0;
        DisposablePool.get().add(RxJavaUtils.polling(0, 50, TimeUnit.MILLISECONDS)
                .subscribe(aLong -> {
                    if (progress <= 100) {
                        updateProgress(progress++);
                    } else {
                        mAdapter.refresh(DataProvider.getFriend());
                        if (mRefreshLayout != null) {
                            mRefreshLayout.finishRefresh(true);
                        }
                        DisposablePool.get().remove("refresh_polling");
                    }

                }), "refresh_polling");
    }
    @MainThread
    private void updateProgress(int progress) {
        if (mRefreshHeader != null) {
            mRefreshHeader.refreshMessage("正在同步数据（" + progress + "%）");
        }
    }

    @Override
    public void onDestroyView() {
        DisposablePool.get().remove("refresh_polling");
        super.onDestroyView();
    }
}

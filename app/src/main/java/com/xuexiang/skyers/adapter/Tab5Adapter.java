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

package com.xuexiang.skyers.adapter;

import com.scwang.smartrefresh.layout.adapter.SmartRecyclerAdapter;
import com.scwang.smartrefresh.layout.adapter.SmartViewHolder;
import com.xuexiang.skyers.R;
import com.xuexiang.skyers.entity.Friend;
import com.xuexiang.xui.widget.textview.supertextview.SuperTextView;

import java.text.SimpleDateFormat;
import java.util.Collection;

public class Tab5Adapter extends SmartRecyclerAdapter<Friend> {
    public Tab5Adapter(){super(R.layout.adapter_item_friend);}
    public Tab5Adapter(Collection<Friend> data){
        super(data,R.layout.adapter_item_friend);
    }
    @Override
    protected void onBindViewHolder(SmartViewHolder holder, Friend model, int position) {
        SuperTextView superTextView = holder.findViewById(R.id.friendHead);
        superTextView.setLeftTopString(model.getNickName());
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        superTextView.setLeftBottomString(ft.format(model.getPushDate()));
        holder.text(R.id.friendContent,model.getInContent());
        holder.text(R.id.friendTransmitCnt,String.valueOf(model.getTransmitCount()));
        holder.text(R.id.friendCommentCnt,String.valueOf(model.getCommentsCount()));
        holder.text(R.id.friendLikeCnt,String.valueOf(model.getLikeCount()));
    }
}

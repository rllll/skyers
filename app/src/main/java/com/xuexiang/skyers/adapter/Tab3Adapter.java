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

import android.widget.TextView;

import com.scwang.smartrefresh.layout.adapter.SmartRecyclerAdapter;
import com.scwang.smartrefresh.layout.adapter.SmartViewHolder;
import com.xuexiang.skyers.R;
import com.xuexiang.skyers.entity.Story;

import java.util.Collection;

public class Tab3Adapter extends SmartRecyclerAdapter<Story> {
    public Tab3Adapter(){
        super(R.layout.adapter_item_story);
    }
    public Tab3Adapter(Collection<Story> data){
        super(data,R.layout.adapter_item_story);
    }
    @Override
    protected void onBindViewHolder(SmartViewHolder holder, Story model, int position) {
        holder.text(R.id.storyTitle,model.getTitle());
        holder.text(R.id.storyContent,model.getContent());
        holder.text(R.id.hotsCnt,String.valueOf(model.getHotCount()));
        holder.text(R.id.commentsCnt,String.valueOf(model.getCommentsCount()));
        holder.text(R.id.storyOwnName,model.getOwnerName());
    }
}

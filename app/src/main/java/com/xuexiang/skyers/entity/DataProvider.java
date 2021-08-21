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

package com.xuexiang.skyers.entity;

import com.umeng.commonsdk.debug.D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class DataProvider {
    private static List<Story> storyDataList;
    private static List<Friend> friendDataList;

    public DataProvider(){}

    public static List<Story> getStory(){
        storyDataList = new ArrayList<>();
        for (long i = 0; i < 10; i++){
            Story story = new Story(i,Story.TITLE,Story.CONTENT,Story.HOTSCOUNT,Story.COMMENTSCOUNT,
                    new Date(),i,Story.OWNERNAME);
            storyDataList.add(story);
        }
        return storyDataList;
    }
    public static List<Friend> getFriend(){
        friendDataList = new ArrayList<>();
        for (long i = 0; i < 10; i++){
            String content;
            if (i % 2 == 0){
                content = Friend.CONTENT1;
            }else{
                content = Friend.CONTENT2;
            }
            Friend friend = new Friend(i,Friend.NICKNAME,new Date(),content,i+4,i+21,i+44);
            friendDataList.add(friend);
        }
        return friendDataList;
    }
}

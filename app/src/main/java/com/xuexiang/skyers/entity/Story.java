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

import java.util.Date;

public class Story {

    public static String TITLE = "墓土捡到的萌新竟是我前男友？？？";
    public static String CONTENT = "天呐姐妹们光遇真是太小了这都能给我遇到，真是晦气，有耳朵吗？吃个饭回来讲";
    public static long HOTSCOUNT = 1000;
    public static long COMMENTSCOUNT = 10000;
    public static String OWNERNAME = "珈珈本珈";

    // 故事ID
    private long ID;
    // 故事标题
    private String Title;
    // 故事内容
    private String Content;
    // 热度数
    private long HotCount;
    // 评论数
    private long CommentsCount;
    // 最后更新时间
    private Date LastDate;
    // 故事发布者ID
    private long OwnerID;
    // 故事发布者名字
    private String OwnerName;

    public Story(long id, String title, String content, long hotCnt, long commentsCount, Date date, long ownerID, String name){
        this.ID = id;
        this.Title = title;
        this.Content = content;
        this.HotCount = hotCnt;
        this.CommentsCount = commentsCount;
        this.LastDate = date;
        this.OwnerID = ownerID;
        this.OwnerName = name;
    }

    public long getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return Content;
    }

    public long getHotCount() {
        return HotCount;
    }

    public long getCommentsCount() {
        return CommentsCount;
    }

    public Date getLastDate() {
        return LastDate;
    }

    public long getOwnerID() {
        return OwnerID;
    }

    public String getOwnerName() {
        return OwnerName;
    }
}

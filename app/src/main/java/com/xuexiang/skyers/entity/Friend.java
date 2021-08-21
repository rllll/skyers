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

public class Friend {
    // 发布者ID
    private long ID;
    // 发布者昵称
    private String nickName;
    // 发布日期
    private Date pushDate;
    // 发布内容
    private String inContent;
    // 转发数
    private long transmitCount;
    // 评论数
    private long commentsCount;
    // 点赞数
    private long likeCount;

    public static String NICKNAME = "珈珈本珈";
    public static String CONTENT1 = "今天在墓土被撞掉翼了，有一个大佬很热心的帮忙捡翼和恢复能量，有被暖到！" +
            "大佬穿的禁阁二级蓝斗篷，背的烟花棒，武士裤，斗笠 狐狸面具，感觉希望很渺茫但是好想捞到大佬，想给大佬送心心！";
    public static String CONTENT2 = "找cp求求了，我可甜可盐，会跑图会遛龙会直飞。从圣岛季开始全季节毕业，礼包没有灯笼。" +
            "性别不卡死，来个20岁左右的！我超乖！";

    public Friend(){}

    public Friend(long id, String nick_name, Date push_date, String in_content, long n1, long n2, long n3){
        this.ID = id;
        this.nickName = nick_name;
        this.pushDate = push_date;
        this.inContent = in_content;
        this.transmitCount = n1;
        this.commentsCount = n2;
        this.likeCount = n3;
    }

    public long getID() {
        return ID;
    }

    public String getNickName() {
        return nickName;
    }

    public String getInContent() {
        return inContent;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public long getTransmitCount() {
        return transmitCount;
    }

    public long getCommentsCount() {
        return commentsCount;
    }

    public long getLikeCount() {
        return likeCount;
    }
}

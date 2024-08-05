package com.huejo.spring100studies.user.service;

import com.huejo.spring100studies.user.entity.User;
import com.huejo.spring100studies.user.model.UserLogCount;
import com.huejo.spring100studies.user.model.UserNoticeCount;
import com.huejo.spring100studies.user.model.UserSummary;

import java.util.List;

public interface UserService {

    UserSummary getUserStatusCount();

    List<User> getTodayUsers();

    List<UserNoticeCount> getUserNoticeCount();

    List<UserLogCount> getUserLogCount();

    List<UserLogCount> getUserLikeBest();
}

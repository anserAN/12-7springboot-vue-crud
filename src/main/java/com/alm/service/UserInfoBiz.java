package com.alm.service;

import com.alm.entity.UserInfo;

import java.util.List;

public interface UserInfoBiz {

	List<UserInfo>findAllUser();

	UserInfo getUserInfoById(Integer id);

	void updateUserInfo(UserInfo userinfo);

	int insertUser(UserInfo userinfo);

	String removeUser(Integer id);

}

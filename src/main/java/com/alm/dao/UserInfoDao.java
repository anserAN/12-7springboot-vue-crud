package com.alm.dao;

import com.alm.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserInfoDao {

	List<UserInfo> findAllUser();

	UserInfo getUserInfo(Integer id);

	void updateUserInfo(UserInfo userinfo);

	Integer insertUser(UserInfo userinfo);

	Integer removeUser(Integer id);
	
}

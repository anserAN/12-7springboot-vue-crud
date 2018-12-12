package com.alm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alm.dao.UserInfoDao;
import com.alm.entity.ResultCode;
import com.alm.entity.UserInfo;
import com.alm.service.UserInfoBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Administrator
 *
 */
@Service
public class UserInfoBizImpl implements UserInfoBiz {


	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private UserInfoDao userInfoDao;
	/**
	 * 获取所有的userinfo
	 */
	@Override
	public List<UserInfo> findAllUser() {
		
		return userInfoDao.findAllUser();
	}

	/**
	 * 修改时 获取需要修改的userinfo
	 */
	@Override
	public UserInfo getUserInfoById(Integer id) {
		
		return userInfoDao.getUserInfo(id);
	}

	/**
	 * 去增加的jsp页面
	 */
	@Override
	public void updateUserInfo(UserInfo userinfo) {
	
		 userInfoDao.updateUserInfo(userinfo);
	}

	/**
	 * 增加方法
	 */
	@Override
	public int insertUser(UserInfo userinfo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(new Date());
		userinfo.setCreatetime(format);
		Integer id = userInfoDao.insertUser(userinfo);//返回受影响的行数
		Integer id2 = userinfo.getId();//返回主键
		System.out.println(id);
		System.out.println(id2);
		return id2;
	}

	/**
	 * 删除方法
	 */
	@Override
	public String removeUser(Integer id) {
		
		ResultCode result = new ResultCode();
		
		Integer row = userInfoDao.removeUser(id);
		if (row == 1) {
			
			result.setCode(100);
			result.setDesc("删除成功！");
		}else {
			result.setCode(200);
			result.setDesc("删除失败！");
		}
		
		String json = JSON.toJSONString(result);
		return json;
	}

}

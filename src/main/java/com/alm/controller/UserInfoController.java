package com.alm.controller;

import com.alm.entity.UserInfo;
import com.alm.service.UserInfoBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoController extends BaseController {

	@Autowired
	private UserInfoBiz userInfoImpl;
	@RequestMapping("/toShowUser")
	public String toShowUser(){
		return "toShowUser";
	}
	@RequestMapping("/toShowUserElement")
	public String toShowUserElement(){
		return "toShowUserElement";
	}

	/**
	 * 查找所有userinfo 返回视图
	 * @param session
	 * @return
	 */
	@RequestMapping("/findAllUser")
	public String findAllUser(HttpSession session) {
		List<UserInfo> userList = userInfoImpl.findAllUser();
		session.setAttribute("userList", userList);
		
		return "showUser";
	}
	/**
	 * 查找所有userinfo 返回视图使用thymeleaf
	 * @param
	 * @return
	 */
	@RequestMapping("/findAllUserTh")
	public String findAllUserTh(Model model) {
		List<UserInfo> userList = userInfoImpl.findAllUser();
		//model 回传数据
		model.addAttribute("myUserList",userList);

		return "toShowUserTh";
	}
	@RequestMapping("/findAllUserJson")
	@ResponseBody
	public List<UserInfo> findAllUserJson() {
		List<UserInfo> userList = userInfoImpl.findAllUser();

		return userList;
	}
	@RequestMapping("/toSave")
	public String toSaveUserinfo(){
		return "toSave";
	}
	/**
	 * 根据ID 获取该userinfo 将数据共享到修改的jsp页面 
	 * @param session
	 * @param id
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public String toUpdate(HttpSession session, Integer id){
		UserInfo userInfo = userInfoImpl.getUserInfoById(id);
		System.out.println(userInfo);
		session.setAttribute("userInfo", userInfo);
		return "toUpdate";
	}
	/**
	 * 根据userinfo修改信息 返回修改后的数据新视图
	 * @param userinfo
	 * @return
	 */
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(UserInfo userinfo){
		userInfoImpl.updateUserInfo(userinfo);
		System.out.println(userinfo);

		
		return redirect("findAllUser");
	}
	/**
	 * 因为jsp文件在web-inf下 所以通过controller来跳转界面
	 * @return
	 */
	@RequestMapping("/toInsert")
	public String toInsert(){
		return "insertUser";
	}
	/**
	 * 添加新的userinfo
	 * @param userinfo
	 * @return
	 */
	@RequestMapping("/insertUser")
	public String insertUser(UserInfo userinfo){
		userInfoImpl.insertUser(userinfo);
		
		return redirect("findAllUser");
	}
	/**
	 * 根据id删除选择的userinfo
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/removeUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String removeUser(Integer id){
		System.out.println(id);
		return userInfoImpl.removeUser(id);
	}
}

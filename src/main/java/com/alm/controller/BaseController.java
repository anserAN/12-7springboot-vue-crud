package com.alm.controller;

import com.alm.entity.ResultModel;

/**
 * @author Administrator
 * 返回是否成功的信息
 */
public class BaseController {

	public String redirect(String path){
		return "redirect:"+path+".do";
	}

	/**
	 * 返回成功方法
	 * @param message
	 * @return
	 */
	public ResultModel returnSuccessInfo(String message) {
		ResultModel rm = new ResultModel();
		rm.setRetStatus(0);
		rm.setMessage(message);
		return rm;
	}

	/**
	 * 返回成功通用方法
	 * @param message
	 * @param obj
	 * @return
	 */
	public ResultModel returnSuccessInfo(String message, Object obj) {
		ResultModel rm = new ResultModel();
		rm.setRetStatus(0);
		rm.setMessage(message);
		rm.setObj(obj);
		return rm;
	}

	/**
	 * 返回失败信息 仅有message
	 * @param message
	 * @return
	 */
	public ResultModel returnErrorInfo(String message) {
		ResultModel rm = new ResultModel();
		rm.setRetStatus(1);
		rm.setMessage(message);
		return rm;
	}

	/**
	 * 通用返回失败方法
	 * @param message
	 * @param obj
	 * @return
	 */
	public ResultModel returnErrorInfo(String message, Object obj) {
		ResultModel rm = new ResultModel();
		rm.setRetStatus(1);
		rm.setMessage(message);
		rm.setObj(obj);
		return rm;
	}
}

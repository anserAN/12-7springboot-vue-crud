package com.alm.controller;

import com.alm.entity.Dept;
import com.alm.entity.ResultModel;
import com.alm.service.DeptBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : An
 * @Date : Create in 2018/12/7 000713:55
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {
    @Autowired
    DeptBiz deptBizImpl;
    @RequestMapping("/toFindAllDept")
    public String toFindAllDept(){
              return "dept";
    }

    @RequestMapping("/findAllDept")
    @ResponseBody
    public Map findAllDept(@RequestBody Map<String,Object> query){
        Map map = deptBizImpl.findAllDept(query);
        return map;
    }
    @RequestMapping("/toInsert")
    public String toInsertDept(){
        return "toInsert";
    }

    /**
     * 添加信息
     * @param dept
     * @return 返回状态信息
     */
    @RequestMapping("/insertDept")
    @ResponseBody
    public ResultModel insertDept(@RequestBody Dept dept){

        int row = deptBizImpl.insertDept(dept);

        if (row > 0) {
            return returnSuccessInfo("添加成功");
        }else {
            return  returnErrorInfo("添加失败");
        }

    }

    /**
     * 删除操作
     * 前后台路径传参
     * 1参数名保持一致
     * 2使用@PathVariable("deptno") 前台/{deptno}
     * 3使用@RequestParam("id") 前台?id=""
     * @param deptno
     * @return
     */
    @RequestMapping("/deleteDeptById")
    @ResponseBody
    public ResultModel deleteDeptById(@RequestParam("id") Integer deptno) {
        System.out.println(deptno);
        int row = deptBizImpl.removeDept(deptno);
        if (row > 0) {
            return returnSuccessInfo("删除成功");
        }else {
            return  returnErrorInfo("删除失败");
        }
    }

    /**
     *
     * @param dept
     * @return
     */
    @RequestMapping("/updateDept")
    @ResponseBody
    public ResultModel updateDept(@RequestBody Dept dept) {
        System.out.println(dept);
        int row = deptBizImpl.updateDept(dept);
        if (row > 0) {
            return returnSuccessInfo("修改成功");
        }else {
            return  returnErrorInfo("修改失败");
        }
    }
}

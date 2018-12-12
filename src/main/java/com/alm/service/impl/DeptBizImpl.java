package com.alm.service.impl;

import com.alm.dao.DeptDao;
import com.alm.entity.Dept;
import com.alm.service.DeptBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
 * @Date : Create in 2018/12/7 000713:51
 */
@Service
public class DeptBizImpl implements DeptBiz {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private DeptDao deptDao;
    @Override
    public Map findAllDept(Map<String,Object> query) {
        Map map = new HashMap();
        List<Dept> list = deptDao.findAllDeptByPage(query);
        int total = deptDao.getTotal(query);
        map.put("rowList",list);
        map.put("totalRow", total);
        return map;
    }

    @Override
    public Dept getDept(Integer id) {
        return deptDao.getDept(id);
    }

    /**
     * 修改信息
     * @param dept
     * @return
     */
    @Override
    public int updateDept(Dept dept) {
       return deptDao.updateDept(dept);
    }

    /**
     * 处理业务 返回的数据是否应放在此处而不是controller
     * @param dept
     * @return
     */
    @Override
    public int insertDept(Dept dept) {
       return deptDao.insertDept(dept);

    }

    @Override
    public int removeDept(Integer id) {
        return deptDao.removeDept(id);
    }
}

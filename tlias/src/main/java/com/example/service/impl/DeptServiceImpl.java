package com.example.service.impl;

import com.example.mapper.DeptMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Dept;
import com.example.pojo.DeptLog;
import com.example.service.DeptLogService;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

//    默认情况下，RuntimeException才回滚异常。rollbackFor属性用于控制出现何种异常类型，回滚异常
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Integer id){

        try {
            deptMapper.delete(id);

            Integer i = 1/0; //模拟错误
//        if(true){
//            throw new Exception("出错啦。。。。");
//        }

            empMapper.deleteByDepId(id);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此次解散的是" + id + "号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void insert(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept get(Integer id) {
        return deptMapper.get(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}

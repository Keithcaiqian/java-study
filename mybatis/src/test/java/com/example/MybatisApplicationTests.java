package com.example;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Options;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete(){
        empMapper.delete(17);
    }


    @Test
    public void testAdd(){
        Emp emp = new Emp();
        emp.setUsername("Tom3");
        emp.setName("汤姆");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setDeptId(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate(){
        Emp emp = new Emp();
        emp.setId(21);
        emp.setUsername("Tom3");
        emp.setName("汤姆3");
        emp.setGender((short) 1);
        emp.setImage("1.jpg");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setDeptId(1);
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }


}

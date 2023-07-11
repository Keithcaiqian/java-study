package com.example;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Options;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void testDelete(){
        empMapper.delete(17);
    }

    @Test
    public void testDeleteByIds(){
        List<Integer> list = Arrays.asList(18, 20, 21);
        empMapper.deleteByIds(list);
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
        emp.setId(18);
        emp.setUsername("Tom111");
        emp.setName("汤姆111");
//        emp.setGender((short) 1);
//        emp.setImage("1.jpg");
//        emp.setJob((short) 1);
//        emp.setEntrydate(LocalDate.of(2000, 1, 1));
//        emp.setDeptId(1);
        emp.setUpdateTime(LocalDateTime.now());
//        empMapper.update(emp);
        empMapper.update2(emp);
    }

    @Test
    public void testSelect(){
        Emp emp = empMapper.getById(6);
        System.out.println(emp);
    }

    @Test
    public  void testList(){
//        List<Emp> empList = empMapper.getList("张", (short) 1, null,  null);
        List<Emp> empList = empMapper.getList(null, null, null,  null);
        System.out.println(empList);
    }

}

package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    public void deleteByIds(List<Integer> ids);

    @Options(keyProperty = "id", useGeneratedKeys = true)
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "VALUES (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    @Update("update emp set username = #{username}," +
            "    name        = #{name}," +
            "    gender      = #{gender}," +
            "    image       = #{image}," +
            "    job         = #{job}," +
            "    entrydate   = #{entrydate}," +
            "    dept_id     = #{deptId}," +
            "    update_time = #{updateTime}" +
            "where id = #{id};")
    public void update(Emp emp);

    public void update2(Emp emp);

//    方案三： 开启mybatis的驼峰命名自动映射开关
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    //方案一：    给字段起别名，让别名与实体类属性一致
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id deptId, create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp getById(Integer id);

//    方案二：通过@Results, @Result注解手动映射封装
//    @Results({
//            @Result(column = "dept_id", property = "deptId"),
//            @Result(column = "create_time", property = "createTime"),
//            @Result(column = "update_time", property = "updateTime"),
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getById(Integer id);

//    @Select("select * from emp where name like concat('%', #{name}, '%') " +
//            "and gender = #{gender} and entrydate between #{start} and #{end}")
    public List<Emp> getList(String name, Short gender, LocalDate start, LocalDate end);

}

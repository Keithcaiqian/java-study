package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmpMapper {

    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

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
}

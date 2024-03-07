package com.situ.mallsdau1.mapper;

import com.situ.mallsdau1.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user(username,password,name,age,sex,create_time,status) values(#{username},#{password},#{name},#{age},#{sex},#{createTime},#{status})")
    void insert(User user);

    //@Select("select * from user where  instr(username,#{keyword})>0 or instr(name,#{keyword})>0")//_一个任意字符，%任意个任意字符
    List<User> selectUsers(String keyword);

    @Delete("delete from user where id=#{userId}")
    void delete(Integer userId);

    @Select("select * from user where id =#{id}")
    User selectById(Integer id);

    @Update("update user set username=#{username},password=#{password},name=#{name},sex=#{sex},age=#{age},status=#{status} where id=#{id}")
    void update(User user);
    @Select("select * from user where username =#{username}")
    User selectByUsername(String username);
}
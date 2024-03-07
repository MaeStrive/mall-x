package com.situ.mallsdau.mapper;

import com.situ.mallsdau.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    //@Select("select * from user where instr(username,#{keyword})>0 or instr(name,#{keyword})>0")
    List<User> selectUsers(String keyword);

    @Delete("delete from user where id = #{userId}")
    void delete(Integer userId);

    @Insert("insert into user(username,password,name,age,sex,create_time,status) values(#{username},#{password},#{name},#{age},#{sex},#{createTime},#{status})")
    void insert(User user);

    @Select("select * from user where id = #{id}")
    User selectById(Integer id);

    @Update("update user set username = #{username},password=#{password},name=#{name},sex=#{sex},age=#{age},status=#{status} where id=#{id}")
    void update(User user);

    @Select("select * from user where username=#{username}")
    User selectByUsername(String username);
}

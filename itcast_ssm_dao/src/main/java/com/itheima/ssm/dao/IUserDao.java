package com.itheima.ssm.dao;

import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "phonenum",column = "phonenum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType=java.util.List.class,many=@Many(select =
                    "com.itheima.ssm.dao.IRoleDao.findRoleByUserId"))}
    )
    UserInfo findByUsername(String Username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(username,password,email,phoneNum,status) values(#{username}," +
            "#{password},#{email},#{phonenum},#{status})")
    void save(UserInfo userInfo);

    @Update("update users set password=#{password},email=#{email},phoneNum=#{phonenum},status=#{status} where username=#{username}")
    void update(UserInfo userInfo);
}

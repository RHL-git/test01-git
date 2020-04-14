package com.rhl.mybatis_1.Mapper;

import com.rhl.mybatis_1.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectAllUser();

    User selectByName(String userName);

    Integer addUser(User user);

    Integer delUser(Integer userId);

    Integer updateUser(User user);

}

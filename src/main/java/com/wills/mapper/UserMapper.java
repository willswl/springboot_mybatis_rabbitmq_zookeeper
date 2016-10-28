package com.wills.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wills.model.User;

/**
 * Created by zl on 2015/8/27.
 */
public interface UserMapper {
	
    public List<User> findUserInfo();
    
    public User selectUserForUpdate(@Param(value = "uname") String userName);
    
    public void update(@Param(value = "unameb") String unameb,@Param(value = "unamea") String unamea);
}

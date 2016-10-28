package com.wills.service;

import com.wills.mapper.UserMapper;
import com.wills.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserInfo(){
        List<User> users=userMapper.findUserInfo();
        //User user=null;
        return users;
    }
    
    @Transactional
    public User updateUserInfo(String uname){
        User user=userMapper.selectUserForUpdate(uname);
        user.setAge(99);
        user.setName(uname+"1");
        userMapper.update(uname, user.getName());

        //userMapper.update2("swl2", user.getName());
        return user;
    }

}

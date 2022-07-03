package com.cloud.service.impl;

import com.cloud.entity.User;
import com.cloud.mapper.UserMapper;
import com.cloud.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        log.info("调用接口。。。。。。。。。。");
        System.out.println("调用接口。。。。。。。。。。");
        return userMapper.queryList();
    }
}

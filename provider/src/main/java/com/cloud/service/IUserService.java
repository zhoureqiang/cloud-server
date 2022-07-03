package com.cloud.service;

import com.cloud.entity.User;

import java.util.List;

public interface IUserService {
    List<User> queryUserList();
}

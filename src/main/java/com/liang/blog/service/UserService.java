package com.liang.blog.service;

import com.liang.blog.po.User;

public interface UserService {
    
    User checkUser(String username, String password);
}

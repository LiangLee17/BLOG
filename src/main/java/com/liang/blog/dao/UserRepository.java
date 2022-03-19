package com.liang.blog.dao;

import com.liang.blog.po.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
    User findByUsernameAndPassword(String username, String password);
}

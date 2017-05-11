package com.mn.service;


import com.mn.model.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();
    User findById(int id);
    void findByUsername(String username);
    void deleteUserById(int id);
    void saveOrUpdate(User user);
}

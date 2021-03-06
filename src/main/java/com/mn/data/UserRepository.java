package com.mn.data;


import com.mn.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
{
    List<User> findAll();
    User findById(int id);
    User findByUsername(String username);
    void deleteUserById(int id);
    void saveOrUpdate(User user);
}

package com.mn.service;

import com.mn.data.UserRepository;
import com.mn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id)
    {
        return userRepository.findById(id);
    }

    @Override
    public void findByUsername(String username) {
        userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public void saveOrUpdate(User user) {
        userRepository.saveOrUpdate(user);
    }
}

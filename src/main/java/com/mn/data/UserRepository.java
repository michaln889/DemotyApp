package com.mn.data;


import com.mn.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository
{
    private List<User> users = Arrays.asList(
            new User(1, "ala", "alamakota", "alamakota@gmail.com"),
            new User(2, "basia", "bbb", "bbb@gmail.com"),
            new User(3, "czarek", "ccc", "ccc@gmail.com"),
            new User(4, "daniel", "ddd", "ddd@gmail.com"),
            new User(5, "edwin", "eee", "eee@gmail.com")
    );

    public List<User> findAll()
    {
        return users;
    }

    public User findById(int id)
    {
        for(User el : users)
        {
            if(el.getId() == id)
            {
                return el;
            }
        }
        return null;
    }
}

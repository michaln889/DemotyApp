package com.mn.data;

import com.mn.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository
{
    private static List<User> users = new ArrayList<User>() {
        {
            add(new User(1, "aaa", "aaa", "aaa", "aaa@gmail.com"));
            add(new User(2, "bbb", "bbb", "bbb", "bbb@gmail.com"));
            add(new User(3, "ccc", "ccc", "ccc", "ccc@gmail.com"));
            add(new User(4, "ddd", "ddd", "ddd", "ddd@gmail.com"));
            add(new User(5, "eee", "eee", "eee", "eee@gmail.com"));
        }};

    @Override
    public List<User> findAll()
    {
        return users;
    }

    @Override
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

    @Override
    public User findByUsername(String username)
    {
        for(User el : users)
        {
            if(el.getUsername().equals(username))
            {
                return el;
            }
        }
        return null;
    }

    @Override
    public void saveOrUpdate(User user)
    {
        boolean isUpdate = false;
        int getPos = 0;

        for(User el : users)
        {
            if(el.getId() == user.getId())
            {
                isUpdate = true;
                break;
            }
            getPos++;
        }

        if(isUpdate)
        {
            users.get(getPos).setFirstName(user.getFirstName());
            users.get(getPos).setLastName(user.getLastName());
            users.get(getPos).setUsername(user.getUsername());
            users.get(getPos).setEmail(user.getEmail());
        }
    }

    @Override
    public void deleteUserById(int id)
    {
        int pos = 0;
        for(User el : users)
        {
            if(el.getId() == id)
            {
                users.remove(id);
                break;
            }
            pos++;
        }
    }
}

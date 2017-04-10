package com.mn.controller;


import com.mn.data.UserRepository;
import com.mn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/user")
    public ModelAndView getUsers()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", userRepository.findAll());
        return modelAndView;
    }

//    @RequestMapping("/user")
//    public String getUsers(ModelMap modelMap)
//    {
//        modelMap.put("users", userRepository.findAll());
//        return "users";
//    }

    @RequestMapping("/user/{id}")
    public String findById(@PathVariable int id, ModelMap modelMap)
    {
        User user = userRepository.findById(id);
        modelMap.put("user", user);
        return "user";
    }
}

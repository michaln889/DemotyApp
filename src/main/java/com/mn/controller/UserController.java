package com.mn.controller;


import com.mn.model.User;
import com.mn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public ModelAndView getUsers()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

//    @RequestMapping("/user")
//    public String getUsers(ModelMap modelMap)
//    {
//        modelMap.put("users", userRepository.findAll());
//        return "users";
//    }

    //update
    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String formUser(Model model, @PathVariable int id)
    {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("formTitle", "Edit user");
        return "form";
    }
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String postCreate(@ModelAttribute User user)
    {
        userService.saveOrUpdate(user);
        return "redirect:/users";
    }

    //find by id
    @RequestMapping("/user/{id}")
    public String findById(@PathVariable int id, ModelMap modelMap)
    {
        User user = userService.findById(id);
        modelMap.put("user", user);
        return "users";
    }

    //delete
    @RequestMapping(value = "/user/delete/{id}")
    public String deleteUserById(@PathVariable int id, Model model)
    {
        userService.deleteUserById(id);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "redirect:/users";
    }
}

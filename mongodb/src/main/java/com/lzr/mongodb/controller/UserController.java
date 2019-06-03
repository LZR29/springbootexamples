package com.lzr.mongodb.controller;

import com.lzr.mongodb.bean.Role;
import com.lzr.mongodb.bean.User;
import com.lzr.mongodb.service.UserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linzerong
 * @create 2019-06-03 20:32
 */
@Controller
@RequestMapping("/mongodb")
public class UserController {
    @Autowired
    private UserService userService;

    private static int count = 0;

    @RequestMapping("/save")
    @ResponseBody
    public Map<String,Object> save(Integer num){
        Map<String, Object> map = new HashMap<>();
        //保存num个文档
        for (int i = 1; i <= num; i++) {
            User user = new User();
            user.setId((long) (i+count));
            user.setNote("note_" + (i+count));
            user.setUserName("lzr_" + (i+count));
            List<Role> list = new ArrayList<>();
            Role role = new Role();
            role.setId((long) (i+count));
            role.setRoleName("role_"+(i+count));
            role.setNote("role_note_"+(i+count));
            list.add(role);
            user.setRoles(list);
            userService.saveUser(user);
        }
        count += num;
        map.put("success",true);
        return map;
    }

    @ResponseBody
    @RequestMapping("/get")
    public User getUser(Long id){
        User user = userService.getUser(id);
        return user;
    }


    @RequestMapping("/find")
    @ResponseBody
    public List<User> find(String userName, String note, Integer skip, Integer limit){
        List<User> list = userService.findUser(userName,note,skip,limit);
        return list;
    }

    @ResponseBody
    @RequestMapping("/update")
    public UpdateResult update(Long id, String userName, String note){
        return userService.updateUser(id,userName,note);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public DeleteResult delete(Long id){
        return userService.deleteUser(id);
    }
}

package com.example.instagram.service;

import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.instagram.dao.IRepository;

import com.example.instagram.model.User;
@Service
public class Userservice {
    @Autowired
   private  IRepository repository;

    public Object saveuser(User user) {
        return repository.save(user);
    }

    public JSONArray getUser(String userid){
        JSONArray userArray = new JSONArray();

        if( null != userid && repository.findById(Integer.valueOf(userid)).isPresent()) {

            User user = repository.findById(Integer.valueOf(userid)).get();
            JSONObject userObj = setuser(user);
            userArray.put(userObj);
        } else {
            List<User> userList = repository.findAll();
            for (User user: userList) {
                JSONObject userObj = setuser(user);
                userArray.put(userObj);
            }
        }
        
       return userArray;

    }

    public JSONObject setuser(User u){
        JSONObject obj2 = new JSONObject(u);
        
        obj2.put("userid",u.getUserid());
        obj2.put("age",u.getAge());
        obj2.put("fname",u.getFname());
        obj2.put("lname",u.getLname());
        obj2.put("mail",u.getMail());
        obj2.put("phoneno",u.getPhoneno());
        return obj2;
    }

    public void updateuser(User user,String id) {
        if(repository.findById(Integer.valueOf(id)).isPresent()) {
            User u = repository.findById(Integer.valueOf(id)).get();

            repository.save(user);
        }
    }
    
}

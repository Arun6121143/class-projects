package com.example.instagram.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import com.example.instagram.dao.IRepository;
import com.example.instagram.model.User;
import com.example.instagram.service.Userservice;

import io.micrometer.common.lang.Nullable;

@RestController
public class UserController {
    @Autowired
    private Userservice service;

    // private IRepository repository;
    @PostMapping("/user")
    public ResponseEntity<String> savepost(@RequestBody String userrequest) {
        User user = setUser(userrequest);
        service.saveuser(user);
        return new ResponseEntity<>("usersaved", HttpStatus.OK);

    }

   

    @GetMapping("/getuser")
     public ResponseEntity<String> getuser(@Nullable @RequestParam String userid){
        JSONArray obj = service.getUser(userid);
        return new ResponseEntity(obj.toString(), HttpStatus.OK);

     }

     @GetMapping("/getuserbyid/userid/{id}")
     public ResponseEntity<String> getuserbyid(@PathVariable String id){
        JSONArray obj = service.getUser(id);
        return new ResponseEntity(obj.toString(), HttpStatus.OK);
     }

     @PutMapping("/update/userid/{id}")
     public ResponseEntity<String> updateuser(@PathVariable String id , @RequestBody String userrequest){
        User user = setUser(userrequest);
        service.updateuser(user,id);
        return new ResponseEntity<>("userupdated", HttpStatus.OK);
     }

     public User setUser(String userrequest) {
        JSONObject obj = new JSONObject(userrequest);
        User u = new User();
        u.setUserid(obj.getInt("userid"));
        u.setAge(obj.getInt("age"));
        u.setFname(obj.getString("fname"));
        u.setLname(obj.getString("lname"));
        u.setMail(obj.getString("mail"));
        u.setPhoneno(obj.getString("phoneno"));

        return u;

    }
}

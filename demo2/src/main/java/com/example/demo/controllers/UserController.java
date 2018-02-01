package com.example.demo.controllers;

import com.example.demo.Entity.Users;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dushman on 7/17/17.
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

   /* @RequestMapping(method = RequestMethod.GET, value = "/getuser/{username}")
    public Users getUser(@PathVariable String username){
        return userService.getUsers(username);
    }*/

   @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value = "/getuser")
    public Users getUser(@RequestBody String user){
       // System.out.println(user);

       // String aa = email;
        //return userService.getUsers(user.getEmail());
       return userService.getUsers(user);
       // return user;
    }

    //@RequestMapping(value = "/addUser/{user}")


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value = "/addUser")
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST, value = "/getRegisteredMembers")
    public List<Users> getRegisteredMembers(@RequestBody String type){
        return userService.getRegisteredMembers(type);
    }



}

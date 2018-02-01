package com.example.demo.services;

import com.example.demo.Entity.Users;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by dushman on 7/17/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users getUsers(String email) {

        String str = email.replaceAll("\n", "");
       // System.out.print("oooooooooooo");
        return this.userRepository.findUsersByEmail(str);
    }

    @Override
    public Users addUser(Users users){

        users.setId(0);
        users.setRegDate(new Date());
        return userRepository.save(users);
    }

    public List<Users> getRegisteredMembers(String type){

        return userRepository.getUsersByType(type);
    }


}

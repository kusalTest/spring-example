package com.example.demo.services;
import com.example.demo.Entity.Users;

import java.util.List;

/**
 * Created by dushman on 7/17/17.
 */

public interface UserService {

    Users getUsers(String email);

    public Users addUser(Users users);

    public List<Users> getRegisteredMembers(String type);
}

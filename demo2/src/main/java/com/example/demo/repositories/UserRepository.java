package com.example.demo.repositories;
import com.example.demo.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dushman on 7/17/17.
 */
@Transactional
public interface UserRepository  extends CrudRepository<Users, String> {

    //Users findByIdBetweenAndName(int startId, int endId, String name);


    Users findUsersByEmail(String email);

    public List<Users> getUsersByType(String type);


}

package com.phinacio.helpdesk.api.repository;

import com.phinacio.helpdesk.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    User findByEmail(String email);

}

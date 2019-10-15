package com.stackroute.springBootH2.repository;

import com.stackroute.springBootH2.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {


}

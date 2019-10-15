package com.stackroute.springBootH2.service;

import com.stackroute.springBootH2.domain.User;
import com.stackroute.springBootH2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository  //extra
public class UserServiceImpl implements UserService{

    UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepository) {
        this.userRepo = userRepository;
    }

    @Override
    public User saveUser(User user) {
        User saveUser = userRepo.save(user);
        return saveUser;
    }

    @Override
    public Iterable<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public void deleteId(int id) {

        userRepo.deleteById(id);
    }


    @Override
    public boolean ifExist(int id) {
        return userRepo.existsById(id);

    }

    @Override
    public ResponseEntity<?> updateUser(User user) {
        if(ifExist(user.getIdea())){
            userRepo.save(user);
        }
        else {
            return new ResponseEntity<String>("First create user then update", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Iterable<User> >(getAllUser(),HttpStatus.OK);
    }


}

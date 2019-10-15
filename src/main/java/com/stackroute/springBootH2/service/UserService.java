package com.stackroute.springBootH2.service;
import com.stackroute.springBootH2.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public Iterable<User> getAllUser();
    public void deleteId(int id);
    public boolean ifExist(int id);
    public ResponseEntity<?> updateUser(User user);

}

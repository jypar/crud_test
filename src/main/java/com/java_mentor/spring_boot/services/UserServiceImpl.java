package com.java_mentor.spring_boot.services;

import com.java_mentor.spring_boot.entities.User;
import com.java_mentor.spring_boot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    @Override
    public void addOrUpdate(User user){
        userRepository.save(user);
    }

    public void remove(Long id){

        userRepository.deleteById(id);
    }

    public List<User> getUsers(){

        return userRepository.findAll();
    }

}

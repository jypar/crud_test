package com.java_mentor.spring_boot.services;

import com.java_mentor.spring_boot.entities.Role;
import com.java_mentor.spring_boot.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface UserService extends UserDetailsService {

    void addOrUpdate(User user);
    void remove(Long id);
    List<User> getUsers();
}

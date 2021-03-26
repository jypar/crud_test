package com.java_mentor.spring_boot.services;

import com.java_mentor.spring_boot.entities.Role;
import com.java_mentor.spring_boot.entities.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    void addOrUpdate(User user);
    void remove(Long id);
    List<User> getUsers();
    User findById(Long id);
    User getUserByName(String name);
    Set<Role> getSetOfRoles(List<String> rolesId);
}

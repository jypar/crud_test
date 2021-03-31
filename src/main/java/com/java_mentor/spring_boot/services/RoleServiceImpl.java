package com.java_mentor.spring_boot.services;

import com.java_mentor.spring_boot.entities.Role;
import com.java_mentor.spring_boot.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRolesList() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id){
        Optional<Role> role = roleRepository.findById(id);
        return role.get();
    }
}

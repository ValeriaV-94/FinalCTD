package com.integrador.backend.services;

import com.integrador.backend.model.Role;
import com.integrador.backend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    final static Logger logger = Logger.getLogger(RoleServiceImpl.class.getName());

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> searchAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> searchRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}

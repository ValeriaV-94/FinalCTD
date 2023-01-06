package com.integrador.backend.services;

import com.integrador.backend.model.Role;
import com.integrador.backend.model.User;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role saveRole(Role role);
    List<Role> searchAllRoles();
    Optional<Role> searchRoleById(Long id);
    Role updateRole(Role role);
    void deleteRole(Long id);
}

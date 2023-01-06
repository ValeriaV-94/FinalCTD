package com.integrador.backend.controller;

import com.integrador.backend.exceptions.BadRequestException;
import com.integrador.backend.exceptions.ResourcesNotFoundException;
import com.integrador.backend.model.Role;
import com.integrador.backend.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //Crear nuevo rol.
    @PostMapping("/save")
    public ResponseEntity<Role> saveRol(@RequestBody Role role) throws BadRequestException {
        try {
            Role saveRole = roleService.saveRole(role);
            return ResponseEntity.ok(saveRole);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    //Buscar todos los roles.
    @GetMapping("/all")
    public ResponseEntity<List<Role>> searchAllRoles() {
        return ResponseEntity.ok(roleService.searchAllRoles());
    }

    //Buscar rol por id.
    @GetMapping("/search/{id}")
    public ResponseEntity<Role> searchRolById(@PathVariable("id") Long id) throws ResourcesNotFoundException {
        Optional<Role> searchRole = roleService.searchRoleById(id);
        if (searchRole.isPresent()) {
            return ResponseEntity.ok(searchRole.get());
        } else {
            throw new ResourcesNotFoundException("No se encontró el rol con id =" + id);
        }
    }

    //Actualizar rol
    @PutMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role role){
        Optional<Role> roleToUpdate = roleService.searchRoleById(role.getId());
        if(roleToUpdate.isPresent()){
            return ResponseEntity.ok(roleService.updateRole(role));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Borrar roles.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRolById(@PathVariable Long id) throws ResourcesNotFoundException{
        Optional<Role> roleToDelete = roleService.searchRoleById(id);
        if (roleToDelete.isPresent()){
            roleService.deleteRole(id);
            return ResponseEntity.ok("Se eliminó el rol con id = " + id);
        } else {
            throw new ResourcesNotFoundException("No se encontró el rol con id = " + id);
        }
    }
}

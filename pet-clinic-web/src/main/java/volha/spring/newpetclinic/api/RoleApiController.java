package volha.spring.newpetclinic.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import volha.spring.newpetclinic.model.Role;
import volha.spring.newpetclinic.services.RoleService;

import java.util.Set;

/*
 *Created by olga on 11.09.2020
 */
@Api("ApiController for Roles")
@RestController
@RequestMapping("/api")
public class RoleApiController {
    private final RoleService roleService;

    public RoleApiController(RoleService roleService) {
        this.roleService = roleService;
    }


    @ApiOperation(value = "This will get a list of roles")
    @GetMapping("/roles")
    public ResponseEntity<Set<Role>> getRoles(){
        return new ResponseEntity<Set<Role>>(roleService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get the role")
    @GetMapping("/roles/{role_id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long role_id){
        return new ResponseEntity<Role>(roleService.findById(role_id), HttpStatus.OK);
    }

    @ApiOperation(value = "This will create new role")
    @PostMapping("/roles")
    public ResponseEntity<Void> createRole(@RequestBody Role role){
        roleService.save(role);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "This will update role's details")
    @PatchMapping("/roles/{role_id}")
    public ResponseEntity<Void> updateRole(@RequestBody Role role){
        roleService.save(role);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ApiOperation(value = "This will delete the role")
    @DeleteMapping("/roles/{role_id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long role_id){
        roleService.deleteById(role_id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

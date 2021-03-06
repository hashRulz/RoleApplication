package com.haulmatic.roleapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haulmatic.roleapplication.domain.Role;
import com.haulmatic.roleapplication.service.RoleService;

@RestController
@RequestMapping(path="/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PostMapping(path="/save")
	public void save(@RequestBody Role role) {
		try {
			roleService.save(role);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(path="/getAll")
	public List<Role> getAll(){
		try {
			return roleService.getAllRoles();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(path="/getRoleByNic/{nic}")
	public Role getRoleById(@PathVariable("nic") String nic) {
		try {
			
			return roleService.getRoleById(nic);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@DeleteMapping(path="/deleteRoleById/{id}")
	public void deleteRole(@PathVariable("id") int id) {
		
		try {
			roleService.deleteRole(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@PutMapping(path="/updateRoleById/{id}")
	public void updateRole(@PathVariable("id") int id,@RequestBody Role role) {
		
		try {
			
			roleService.updateRoleById(id,role);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@GetMapping(path="getListByOrg-Rtype/{org}/{rtype}")
	public ResponseEntity<List<Role>>  getAllByOrg(@PathVariable("org") String org, @PathVariable("rtype") String rtype){
		try {
			
			List<Role> roleList = roleService.getListByOrg(org,rtype);
			
			return new ResponseEntity<>(roleList,HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	}
	
	
}

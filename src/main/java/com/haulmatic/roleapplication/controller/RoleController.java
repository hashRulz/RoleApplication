package com.haulmatic.roleapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		roleService.save(role);
	}
	
	@GetMapping(path="/getAll")
	public List<Role> getAll(){
		return roleService.getAllRoles();
	}
	
	@GetMapping(path="/getRoleByNic/{nic}")
	public Role getRoleById(@PathVariable("nic") String nic) {
		try {
			System.out.println(nic);
			return roleService.getRoleById(nic);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}

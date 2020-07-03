package com.haulmatic.roleapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haulmatic.roleapplication.domain.Role;
import com.haulmatic.roleapplication.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void save(Role role) {
		roleRepository.save(role);
		
	}
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
	@Override
	public Role getRoleById(String nic) {
		return roleRepository.findOneByNic(nic);
	}
	
	

}

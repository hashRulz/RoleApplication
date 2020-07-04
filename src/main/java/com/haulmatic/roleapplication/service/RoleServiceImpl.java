package com.haulmatic.roleapplication.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haulmatic.roleapplication.domain.Role;
import com.haulmatic.roleapplication.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
	LocalDateTime now = LocalDateTime.now();
	
	@Override
	public void save(Role role) {
		role.setCreateDate(now);
		role.setModifiedDate(now);
		roleRepository.save(role);	
	}
	
	@Override
	public List<Role> getAllRoles() {
		return (List<Role>) roleRepository.findAll();
	}
	
	@Override
	public Role getRoleById(String nic) {
		return roleRepository.findOneByNic(nic);
	}
	
	@Override
	public void deleteRole(int id) {
		roleRepository.deleteById(id);		
	}
	
	@Override
	public void updateRoleById(int id,Role role) {
		Role roleObj = roleRepository.findOneByid(id);
		roleObj.setFname(role.getFname());
		roleObj.setLname(role.getLname());
		roleObj.setOrg(role.getOrg());
		roleObj.setNic(role.getNic());
		roleObj.setRoleType(role.getRoleType());
		roleObj.setModifiedDate(now);
		roleRepository.save(roleObj);
	}
	@Override
	public List<Role> getListByOrg(String org, String rtype) {
		List<Role> roles =  roleRepository.findAllByOrgAndRoleType(org,rtype);
		return roles;
	}
}

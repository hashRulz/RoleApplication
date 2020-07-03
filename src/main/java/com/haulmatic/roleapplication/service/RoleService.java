package com.haulmatic.roleapplication.service;

import java.util.List;

import com.haulmatic.roleapplication.domain.Role;

public interface RoleService {
	
	void save(Role role);
	List<Role> getAllRoles();
	Role getRoleById(String nic);
	void deleteRole(int id);
	void updateRoleById(int id,Role role);
}

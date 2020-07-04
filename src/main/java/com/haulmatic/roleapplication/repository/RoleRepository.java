package com.haulmatic.roleapplication.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.haulmatic.roleapplication.domain.Role;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
	
	public Role findOneByNic(String nic);
	public Role findOneByid(int id);
	public List<Role> findAllByOrgAndRoleType(String org,String roleType);
}

package com.haulmatic.roleapplication.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.haulmatic.roleapplication.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
	
	public Role findOneByNic(String nic);

}

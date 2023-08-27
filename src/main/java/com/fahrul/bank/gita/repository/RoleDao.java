package com.fahrul.bank.gita.repository;

import com.fahrul.bank.gita.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Integer> {

	Role findByName(String name);
}
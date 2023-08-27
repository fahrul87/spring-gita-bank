package com.fahrul.bank.gita.service;

import com.fahrul.bank.gita.entity.User;
import com.fahrul.bank.gita.security.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public interface UserService {

	User findByUsername(String username);

	User findByEmail(String email);

	boolean checkUserExists(String username, String email);

	boolean checkUsernameExists(String username);

	boolean checkEmailExists(String email);

	void save(User user);

	User createUser(User user, Set<UserRole> userRoles);

	User saveUser(User user);

	List<User> findUserList();

	void enableUser(String username);

	void disableUser(String username);

}
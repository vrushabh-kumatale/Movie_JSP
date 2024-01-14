package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.pojos.Users;

public interface UserDao extends AutoCloseable {
	
	int insertUser(Users user);
	int updateUser(Users user);
	int findUser(Users user);
	List<Users> getSharedUsers(int id);

	
}

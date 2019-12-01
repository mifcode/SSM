package net.neuedu.sm.dao;

import java.util.List;

import net.neuedu.sm.domain.Users;

public interface UsersDao {

	public Users queryUserById(Integer id);
	
	public List<Users> queryAll();
	
	public void addUser(Users user);
	
	void updateUser(Users user);
	
	void deleteUser(Integer id);

}

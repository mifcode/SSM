package net.neuedu.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.neuedu.sm.dao.UsersDao;
import net.neuedu.sm.domain.Users;

@Service
public class UsersService {
	
	
	@Autowired
	private UsersDao usersDao;
	
	// 对这个方法进行事务控制
	@Transactional
	public void insertUsers(Users user1,Users user2)
	{
		//开启事务
		usersDao.addUser(user1);
		int a=10/0;
		//中间有异常，那么事务回滚
		usersDao.addUser(user2);
		//提交事务
	}

}

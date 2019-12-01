package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.neuedu.sm.dao.UsersDao;
import net.neuedu.sm.domain.Users;

public class Test {

	public static void main(String[] args) {
		ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
		
		UsersDao usersDao=(UsersDao) act.getBean("usersDao");
		Users user=usersDao.queryUserById(4);
		
		System.out.println(user.getUsername());
	}}


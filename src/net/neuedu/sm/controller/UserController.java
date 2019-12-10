package net.neuedu.sm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.neuedu.sm.dao.UsersDao;
import net.neuedu.sm.domain.Users;
import net.neuedu.sm.service.UsersService;

@Controller
public class UserController {
	
	//正常情况下，调用UserService处理客户端请求， 但是搭建环境节省时间我调用UserDao
	@Autowired
	private UsersService usersService;
	@Autowired
	private UsersDao usersDao;
	
	@RequestMapping("deleteUser.do")
	public String deleteUser(Integer id)
	{
		usersDao.deleteUser(id);
		return "redirect:queryAll.do";//不会拼接
	}
	
	//定义处理更新请求的方法
	@RequestMapping("edit.do")
	public String edit(Users user)
	{
		usersDao.updateUser(user);
		return "redirect:queryAll.do";//不会拼接
	}
	
	@RequestMapping("updateUser.do")
	public ModelAndView updateUser(Integer id)
	{
		Users user=usersDao.queryUserById(id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("update_user");
		mav.addObject("user", user);
		return mav;
	}
	
	//定义去往添加页面的方法
	@RequestMapping("toAddPage.do")
	public String toAddPage()
	{
		return "add_user";//参与拼接
	}
	
	@RequestMapping("addUser.do")
	public String addUser(Users user)
	{
		usersDao.addUser(user);
		return "redirect:queryAll.do";//不会拼接
	}
	//事务测试，要么都成功，要么都失败。
	@RequestMapping("addUser2.do")
	public String addUser2()
	{
//		/业务需求是要么全部保存成功，要么全部保存失败，
		Users user1=new Users();
		user1.setId(11123);
		user1.setUsername("11123的名字");
		
		
		//int a=10/0;//抛出除数不能为0的异常
		
		Users user2=new Users();
		user2.setId(11124);
		user2.setUsername("11124的名字");
		usersService.insertUsers(user1,user2);
		
		return "redirect:queryAll.do";//不会拼接
	}
	
	
	@RequestMapping("queryAll.do")
	public ModelAndView queryAll()
	{
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("list", usersDao.queryAll());
//		mav.setViewName("list");
		//那么怎么实现分页的效果呢？
		Page page=PageHelper.startPage(1, 3);
		List<Users> list=usersDao.queryAll();//select * from t_user     select * from t_user limit 0,2;
		System.out.println("size:"+list.size());
		for(Users u:list)
		{
			System.out.println(u);
		}
		ModelAndView mav=new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("list");
		//同时页面还需要什么？需要总页数，当前第几页 
		mav.addObject("pageCount", page.getPages());
		mav.addObject("pageNum", page.getPageNum());
		mav.addObject("pageSize", page.getPageSize());
		return mav;
	}

}

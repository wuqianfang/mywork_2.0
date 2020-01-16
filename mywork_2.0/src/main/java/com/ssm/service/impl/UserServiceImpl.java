package com.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.IUserDao;
import com.ssm.entity.User;
import com.ssm.service.IUserService;
@Service
public class UserServiceImpl  implements IUserService {
	  @Resource
	    private IUserDao userDao;
	 
	    public List<User> selectAll(Map<String, String> map) {
	        return userDao.selectAll(map);
	    }
	    
	    
	    public void addUser(User user) {
	    	userDao.addUser(user);
	    }
	    
	    public void deleteUser(int id) {
	    	userDao.deleteUser(id);
	    }
	    
	    public void updateUser(User user) {
	    	userDao.updateUser(user);
	    }
}


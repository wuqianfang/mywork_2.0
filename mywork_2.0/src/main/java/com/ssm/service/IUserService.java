package com.ssm.service;

import java.util.List;
import java.util.Map;

import com.ssm.entity.User;

public interface IUserService {
    
    public void addUser(User user);
    
    public void deleteUser(int id);
    
    public void updateUser(User user);
    
    public List<User> selectAll(Map<String, String> map);
}

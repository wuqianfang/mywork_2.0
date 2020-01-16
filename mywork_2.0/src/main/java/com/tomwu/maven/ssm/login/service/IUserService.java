package com.tomwu.maven.ssm.login.service;

import java.util.List;
import java.util.Map;

import com.tomwu.maven.ssm.login.entity.User;

public interface IUserService {
    
    public void addUser(User user);
    
    public void deleteUser(int id);
    
    public void updateUser(User user);
    
    public List<User> selectAll(Map<String, String> map);
}

package com.ssm.dao;

import java.util.List;
import java.util.Map;

import com.ssm.entity.User;

public interface IUserDao {
    /**
     * ��¼
     *
     * @param map
     * @return
     */
    public List<User> selectAll(Map<String, String> map);
    
    
    public void addUser(User user);
    
    public void deleteUser(int id);
    
    public void updateUser(User user);
    
}

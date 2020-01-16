package com.tomwu.maven.ssm.login.dao;

import java.util.List;
import java.util.Map;

import com.tomwu.maven.ssm.login.entity.User;

public interface IUserDao {
    /**
     * µÇÂ¼
     *
     * @param map
     * @return
     */
    public List<User> selectAll(Map<String, String> map);
    
    
    public void addUser(User user);
    
    public void deleteUser(int id);
    
    public void updateUser(User user);
    
}

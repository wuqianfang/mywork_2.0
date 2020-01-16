package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.User;
import com.ssm.service.IUserService;

/**
 * 
 * @author Tom
 *
 */
@Controller
@RequestMapping("/user")
public class UserController{
	
	@Resource
    private IUserService userService;
	
	
    /**
     * 登陆页面
     * @param req
     * @param mv
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest req, ModelAndView mv) {
            mv.setViewName("user/login");
        return mv;
    }
	
	
   /**
     * 用户登录
     * 
     * @param req
     * @param mv
     * @return
     * @throws Exception 
     */
    @RequestMapping("/sign-in")
    public ModelAndView logins(HttpServletRequest req, ModelAndView mv)  throws Exception {
       Map<String, String> map = new HashMap<String, String>();
        map.put("username", req.getParameter("username"));
        map.put("password", req.getParameter("password"));
       List<User> user = userService.selectAll(map);
      if (user != null && user.size()>0) {//登录成功进入首页
          HttpSession session = req.getSession();
          //把用户对象数据保存在session域对象中
          session.setMaxInactiveInterval(30*60);//(秒)
          session.setAttribute("LOGIN_USER", user.get(0));
            mv.setViewName("user/index");
            mv.addObject("name",user.get(0));
        } else {//登录失败回到登录页面
            mv.addObject("message","用户名或密码输入错误,请重新输入");
            mv.setViewName("user/login");//"redirect:/login.htm"
        }
        return mv;
    }

    /**
     * 跳转创建账号页面
     * @param req
     * @param mv
     * @return
     */
    @RequestMapping("/adduser")
    public ModelAndView adduser(HttpServletRequest req, ModelAndView mv) {
            mv.setViewName("user/adduser");
        return mv;
    }
    
    /**
     * 创建账号
     * @param req
     * @param mv
     * @return
     */
    @RequestMapping("/insert")
    public ModelAndView insert(HttpServletRequest req, ModelAndView mv) {    
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", req.getParameter("username"));
        List<User> selectAll = userService.selectAll(map);
        if(selectAll != null && selectAll.size()>0) {
        	 mv.addObject("message","登录名重复");	
        	 mv.setViewName("user/adduser");
        	 return mv;
        }
        
        User user = new User();
    		 user.setUsername(req.getParameter("username"));
    		 user.setPassword(req.getParameter("password"));
    		 user.setEmail(req.getParameter("email"));
    		 user.setPhone(req.getParameter("phone"));
       try {
    	   userService.addUser(user);
    	   mv.addObject("message","创建成功");
    	   mv.addObject("user",user);
       		} catch (Exception e) {
       		 mv.addObject("message","创建失败");	
       		}finally {
       		 mv.setViewName("user/adduser");
			}
       return mv;
    }
    

    
    
}


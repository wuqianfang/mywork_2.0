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
     * ��½ҳ��
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
     * �û���¼
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
      if (user != null && user.size()>0) {//��¼�ɹ�������ҳ
          HttpSession session = req.getSession();
          //���û��������ݱ�����session�������
          session.setMaxInactiveInterval(30*60);//(��)
          session.setAttribute("LOGIN_USER", user.get(0));
            mv.setViewName("user/index");
            mv.addObject("name",user.get(0));
        } else {//��¼ʧ�ܻص���¼ҳ��
            mv.addObject("message","�û����������������,����������");
            mv.setViewName("user/login");//"redirect:/login.htm"
        }
        return mv;
    }

    /**
     * ��ת�����˺�ҳ��
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
     * �����˺�
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
        	 mv.addObject("message","��¼���ظ�");	
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
    	   mv.addObject("message","�����ɹ�");
    	   mv.addObject("user",user);
       		} catch (Exception e) {
       		 mv.addObject("message","����ʧ��");	
       		}finally {
       		 mv.setViewName("user/adduser");
			}
       return mv;
    }
    

    
    
}


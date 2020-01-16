package com.tomwu.maven.ssm.function.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tomwu.maven.ssm.login.service.IUserService;

/**
 * 
 * @author Tom
 *
 */
@Controller
@RequestMapping("/function")
public class FunctionController{
	
	@Resource
    private IUserService userService;
	
	
   
}


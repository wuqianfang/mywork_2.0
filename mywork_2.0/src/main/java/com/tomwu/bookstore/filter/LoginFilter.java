package com.tomwu.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @url: https://blog.csdn.net/qq_40180411/article/details/82379794
 * @ClassName: LoginFilter
 * @Description: TODO
 * @author Mr.Wu
 * @date 2020��1��14������4:32:29
 *
 */
public class LoginFilter  implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();
		
//		&& request.getRequestURI().indexOf("/user/login") == -1
		if(session.getAttribute("LOGIN_USER")==null){
			// û�е�¼
			response.sendRedirect(request.getContextPath()+"/user/login");
		}else{
			// �Ѿ���¼������������һ����Դ���������ʣ�
			arg2.doFilter(arg0, arg1);
		}
		
	}
 
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}

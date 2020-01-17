package com.tomwu.maven.ssm.bookstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// ִ����ϣ�����ǰ����		
	}
 
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// �ڴ�������У�ִ������		
	}
 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// �����ص�ִ��ǰ���أ��������true��ִ�����ص��Ĳ��������سɹ���
		// ����false��ִ������
		HttpSession session = request.getSession(); 
		//String uri = request.getRequestURI(); // ��ȡ��¼��uri������ǲ��������ص�
		//if(session.getAttribute("LOGIN_USER")!=null || uri.indexOf("system/login")!=-1) {// ˵����¼�ɹ� ���� ִ�е�¼����			
		if(session.getAttribute("LOGIN_USER")!=null) {
			// ��¼�ɹ�������
			return true;
		}else {
			// ���غ�����¼ҳ��
			response.sendRedirect(request.getContextPath()+"/login/Login");
			return false;
		}
	}

}

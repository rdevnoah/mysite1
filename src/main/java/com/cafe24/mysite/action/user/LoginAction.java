package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;
import com.cafe24.web.WebUtil;
import com.cafe24.web.mvc.Action;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserVo authUser = new UserDao().get(email, password);
		if (authUser == null) {
			request.setAttribute("result", "fail");
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
			return; // 보내고 나면 무조건 코드를 끝을 내줘야 한다. 아니면 밑으로 내려가서 밑의 코드가 수행된다.
			
		}
		
		//로그인 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", authUser);
		
		WebUtil.redirect(request, response, request.getContextPath());
	}

}

package com.bit2016.mysite.action.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;
import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao();
		UserVo vo = dao.get(email, password);
		
		// 로그인 실패(password 또는 email이 틀림)
		if(vo == null) {
			// 실패 처리는 리다이렉트
			// 또는 포워딩 처리도 가능
			WebUtil.redirect(request, response, "/mysite3/user?a=loginform&result=fail");
			
			return;		// 주의 : redirect를 한 후 다음 코드가 실행되지 않도록 함수 종료
		}
		
		// 로그인 성공 -> 인증처리
		System.out.println("로그인 성공 -> 인증처리");
		// false or 빈파라미터 -> JSESSIONID와 연결된 session 객체가 없으면 null 리턴
		// true -> JSESSIONID와 연결된 session 객체가 없으면 만들어서 리턴
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", vo);
		
		WebUtil.redirect(request, response, "/mysite3/main");
	}

}

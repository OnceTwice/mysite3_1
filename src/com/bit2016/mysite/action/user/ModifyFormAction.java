package com.bit2016.mysite.action.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;
import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		UserVo userVo = new UserDao().get(authUser.getNo());
		
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		String gender = request.getParameter("gender");
//		
//		userVo.setName(name);
//		userVo.setEmail(email);
//		userVo.setPassword(password);
//		userVo.setGender(gender);
		
//		UserDao dao = new UserDao();
//		dao.update(userVo);
		
		// 연습코드
//		UserVo userVo = new UserVo();
//		userVo.setNo(10L);
//		userVo.setName("안대혁");
//		userVo.setGender("male");
//		userVo.setEmail("kiscar@gmail.com");
		
		request.setAttribute("userVo", userVo);
		WebUtil.forward(request, response, "/WEB-INF/views/user/modifyform.jsp");
	}

}

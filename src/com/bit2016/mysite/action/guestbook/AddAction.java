package com.bit2016.mysite.action.guestbook;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;
import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// add에 대한 요청 처리
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String content = request.getParameter("content");

		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContent(content);

		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);

		//response.sendRedirect("/guestbook3/gb");
		WebUtil.redirect(request, response, "/mysite3/guestbook");
	}

}

package com.bit2016.mysite.action.guestbook;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;
import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = request.getParameter("no");
		String password = request.getParameter("password");
		
		GuestBookVo vo = new GuestBookVo();
		
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);

		GuestBookDao dao = new GuestBookDao();
		dao.delete(vo);
		
		//redirect
		//response.sendRedirect("/guestbook3/gb");
		
		WebUtil.redirect(request, response, "/mysite3/guestbook");
	}

}

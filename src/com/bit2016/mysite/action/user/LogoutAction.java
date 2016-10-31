package com.bit2016.mysite.action.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.mysite.vo.*;
import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session == null) {
			WebUtil.redirect(request, response, "/mysite3/main");
			return;
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser != null) {
			// logout 처리
			session.removeAttribute("authUser");
			session.invalidate();
		}
		
		WebUtil.redirect(request, response, "/mysite3/main");
	}

}

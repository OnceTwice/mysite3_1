package com.bit2016.mysite.action.guestbook;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WebUtil.forward(request, response, "/WEB-INF/views/guestbook/deleteform.jsp");
		
		// form 요청에 대한 처리
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
		//rd.forward(request, response);
	}

}

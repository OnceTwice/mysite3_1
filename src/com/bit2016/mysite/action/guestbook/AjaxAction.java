package com.bit2016.mysite.action.guestbook;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class AjaxAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list-ajax.jsp");
	}
}

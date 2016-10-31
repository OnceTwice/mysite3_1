package com.bit2016.mysite.action.guestbook;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;
import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// default action 처리(리스트 처리)
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList();

		// request 범위에 모델 데이터 저장
		request.setAttribute("list", list);

		WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");
		
		// forwarding(request 연장, request dispatch)
		//RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		//rd.forward(request, response);
	}

}

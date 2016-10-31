package com.bit2016.mysite.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.bit2016.mysite.action.guestbook.*;
import com.bit2016.web.*;

@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// action name 가져오기
		String actionName = request.getParameter("a");
		
		ActionFactory af = new GuestBookActionFactory();
		Action action = af.getAction(actionName);
		action.execute(request, response);
		
		
		/*
		if("add".equals(actionName)) {
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
			
			response.sendRedirect("/guestbook2/gb");
			
		} else if("deleteform".equals(actionName)) {
			// form 요청에 대한 처리
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		} else if("delete".equals(actionName)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			
			GuestBookVo vo = new GuestBookVo();
			
			vo.setNo(Long.parseLong(no));
			vo.setPassword(password);

			GuestBookDao dao = new GuestBookDao();
			dao.delete(vo);
			
			//redirect
			response.sendRedirect("/guestbook2/gb");
		} else {
			// default action 처리(리스트 처리)
			GuestBookDao dao = new GuestBookDao();
			List<GuestBookVo> list = dao.getList();

			// request 범위에 모델 데이터 저장
			request.setAttribute("list", list);

			// forwarding(request 연장, request dispatch)
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

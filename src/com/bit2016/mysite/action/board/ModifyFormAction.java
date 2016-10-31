package com.bit2016.mysite.action.board;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.web.*;
import com.bit2016.web.util.*;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();			// request에 대한 새로운 session을 생성

		
//		BoardVo boardUser = (BoardVo)session.getAttribute("boardUser");
		
//		BoardVo boardVo = new BoardDao().get(boardUser.getNo());
		
//		request.setAttribute("boardVo", boardVo);
		
		WebUtil.forward(request, response, "/WEB-INF/views/board/modify.jsp");
	}
}

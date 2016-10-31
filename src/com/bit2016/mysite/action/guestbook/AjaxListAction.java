package com.bit2016.mysite.action.guestbook;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;
import com.bit2016.web.*;

import net.sf.json.*;

public class AjaxListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sPage = request.getParameter("p");
		if("".equals(sPage)) {
			sPage = "1";
		}
		int page = Integer.parseInt(sPage);
		
		GuestBookDao dao = new GuestBookDao();
		List<GuestBookVo> list = dao.getList(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", list);
		
		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}

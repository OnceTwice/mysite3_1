package com.bit2016.mysite.action.user;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.bit2016.mysite.dao.*;
import com.bit2016.mysite.vo.*;
import com.bit2016.web.*;

import net.sf.json.*;

public class APICheckEmailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		UserDao dao = new UserDao();
		UserVo vo = dao.get(email);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		if(vo == null) {
			map.put("data", "not exist");
		} else {
			map.put("data", "exists");
		}
		
		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}

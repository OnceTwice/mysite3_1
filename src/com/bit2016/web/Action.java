package com.bit2016.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

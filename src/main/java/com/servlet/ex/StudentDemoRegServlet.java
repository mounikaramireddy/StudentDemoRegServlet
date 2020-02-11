package com.servlet.ex;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/reg")
public class StudentDemoRegServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) {
		try {
			String s = req.getParameter("fname");
			String s1 = req.getParameter("lname");
			String s2 = req.getParameter("gender");
			String s3 = req.getParameter("address");
			String s4 = req.getParameter("lang1");
			String s5 = req.getParameter("lang2");
			String s6 = req.getParameter("land3");
			String[] s7 = req.getParameterValues("hobbies");
			String s8 = req.getParameter("country");
			String s9 = req.getParameter("uname");
			String s10 = req.getParameter("pword");
			PrintWriter pw = res.getWriter();
			pw.println("Firstname:" + s);
			pw.println("lastname:" + s1);
			pw.println("address:" + s2);
			pw.println("gender:" + s3);
			pw.println("languages:");
			if (s4 != null)
				pw.println(s4);
			if (s5 != null)
				pw.println(s5);
			if (s6 != null)
				pw.println(s6);
			pw.print("hobbies:  ");
			for (String si : s7) {
				pw.print(si+ "   ");
			}
			pw.println("\ncountry:" + s8);
			pw.println("username:" + s9);
			pw.println("password:" + s10);
		} catch (Exception e) {

			System.err.println(e);
		}
	}
}
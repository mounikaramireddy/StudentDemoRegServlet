package com.servlet.ex;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.servlet.domain.StudentDemo;
import com.servlet.jdbc.StudentDemoDaoImpl;

@WebServlet("/student-details")
public class StudentDemoDetailsServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) {
		try {
			StudentDemoDaoImpl ob = new StudentDemoDaoImpl();
			String input = req.getParameter("studentName");
			PrintWriter pw = res.getWriter();

			if (null == input) {
				pw.println("No input found");

			} else {
				List<StudentDemo> s = ob.retrieveStudentByName(input);
				pw.println("<html><body><h1><center>Students Details</center></h1><br>");
				if ((null == s) || s.isEmpty()) {
					pw.println("no data found");
					pw.println("</body></html>");
				} else {
					pw.println(
							"<table border=10><tr style=\"font-weight:bold\"><td>name</td><td>id</td><td>branch</td><td>college</td>"
									+ "<td>email</td><td>marks</td><td>Addressid</td></tr>");

					for (StudentDemo student : s) {
						StringBuilder sb = new StringBuilder("<tr>");
						sb.append("<td>").append(student.getName()).append("</td>");
						sb.append("<td>").append(student.getId()).append("</td>");
						sb.append("<td>").append(student.getBranch()).append("</td>");
						sb.append("<td>").append(student.getClg()).append("</td>");
						sb.append("<td>").append(student.getEmail()).append("</td>");
						sb.append("<td>").append(student.getMarks()).append("</td>");
						sb.append("<td>").append(student.getAddressId()).append("</td>");
						sb.append("</tr>");
						pw.println(sb);
					}
					pw.println("</table></body></html>");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

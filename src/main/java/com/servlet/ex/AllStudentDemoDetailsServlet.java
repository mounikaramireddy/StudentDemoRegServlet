package com.servlet.ex;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.servlet.domain.StudentDemo;
import com.servlet.jdbc.StudentDemoDaoImpl;

@WebServlet("/all-students-details")
public class AllStudentDemoDetailsServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) {
		try {
			StudentDemoDaoImpl ob = new StudentDemoDaoImpl();
			List<StudentDemo> s = ob.retrieveStudentDemoList();
			PrintWriter pw = res.getWriter();
			pw.println("<html><body><h1><center>Students Details</center></h1><br>");
			if ((null == s) || s.isEmpty()) {
				pw.println("no data found");
				pw.println("</body></html>");
			} else {
				pw.println(
						"<table border=10><tr style=\"font-weight:bold\"><td>name</td><td>id</td><td>branch</td><td>college</td>"
						+ "<td>email</td><td>marks</td><td>Addressid</td></tr>");

				for (StudentDemo s1 : s) {
					StringBuilder sb = new StringBuilder("<tr>");
					sb.append("<td>").append(s1.getName()).append("</td>");
					sb.append("<td>").append(s1.getId()).append("</td>");
					sb.append("<td>").append(s1.getBranch()).append("</td>");
					sb.append("<td>").append(s1.getClg()).append("</td>");
					sb.append("<td>").append(s1.getEmail()).append("</td>");
					sb.append("<td>").append(s1.getMarks()).append("</td>");
					sb.append("<td>").append(s1.getAddressId()).append("</td>");
					sb.append("</tr>");
					pw.println(sb);
				}
				pw.println("</table></body></html>");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

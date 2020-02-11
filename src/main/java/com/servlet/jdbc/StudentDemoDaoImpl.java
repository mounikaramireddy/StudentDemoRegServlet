package com.servlet.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servlet.domain.StudentDemo;

public class StudentDemoDaoImpl {

	public Connection createConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SCOTT", "Scott123");
		return con;
	}


	public List<StudentDemo> retrieveStudentByName(String sName) {
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		List<StudentDemo> studentList = new ArrayList<>();
		try {
			con = createConnection();
			smt = con.createStatement();
			rs = smt.executeQuery("select sname,sid,sbranch,scollege,semail,smarks,addressid from studentdemo WHERE sname LIKE '%"+sName+"%'");
			while (rs.next()) {
				StudentDemo obj = new StudentDemo();
				obj.setName(rs.getString(1));
				obj.setId(rs.getInt(2));
				obj.setBranch(rs.getString(3));
				obj.setClg(rs.getString(4));
				obj.setEmail(rs.getString(5));
				obj.setMarks(rs.getInt(6));
				obj.setAddressId(rs.getInt(7));
				studentList.add(obj);

			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != smt) {
					smt.close();
				}
				if (null != con) {
					con.close();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return studentList;
	}


	public List<StudentDemo> retrieveStudentDemoList() {
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		List<StudentDemo> studentList = new ArrayList<>();
		try {
			con = createConnection();
			smt = con.createStatement();
			rs = smt.executeQuery("select sname,sid,sbranch,scollege,semail,smarks,addressid from studentdemo");
			while (rs.next()) {
				StudentDemo obj = new StudentDemo();
				obj.setName(rs.getString(1));
				obj.setId(rs.getInt(2));
				obj.setBranch(rs.getString(3));
				obj.setClg(rs.getString(4));
				obj.setEmail(rs.getString(5));
				obj.setMarks(rs.getInt(6));
				obj.setAddressId(rs.getInt(7));
				studentList.add(obj);

			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != smt) {
					smt.close();
				}
				if (null != con) {
					con.close();
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		return studentList;
	}

	public static void main(String[] args) {
		StudentDemoDaoImpl ob = new StudentDemoDaoImpl();
		List<StudentDemo> s = ob.retrieveStudentDemoList();
		for (StudentDemo s1 : s) {
			System.out.println(s1);
		}

	}

}

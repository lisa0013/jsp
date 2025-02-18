package com.yedam.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.dao.StudentDAO;
import com.yedam.vo.Student;

// service()기능구현.
@WebServlet("/addStudentServ")
public class AddStudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // 요청 정보의 한글 처리.
		resp.setContentType("text/html;charset=utf-8");

		String sno = req.getParameter("std_no"); // std_no의 param에 담겨있는 값 반환.
		String sname = req.getParameter("std_name");
		String tel = req.getParameter("tel_no");
		String addr = req.getParameter("std_addr");
		
		// 매개값으로 Student.
		Student std = new Student();
		std.setStudentNo(sno);
		std.setStudentName(sname);
		std.setPhone(tel);
		std.setAddress(addr);
		
		StudentDAO sdao = new StudentDAO();
		if (sdao.addStudent(std)) {
			resp.getWriter().print("처리성공");
		} else {
			resp.getWriter().print("처리실패");
		}
	}
	
	
} // end of class.

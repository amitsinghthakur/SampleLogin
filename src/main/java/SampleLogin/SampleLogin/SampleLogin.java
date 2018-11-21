package SampleLogin.SampleLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SampleLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql:3306/sampledb", "userKAW", "7fh85bxgOwPxww5T");
			PreparedStatement ps=con.prepareStatement("select userName,pass from student where userName=? and pass=?");
			ps.setString(1, uname);
			ps.setString(1, pass);
			
			ResultSet rs =ps.executeQuery();
			
			while (rs.next()) {
				response.sendRedirect("success.html");
				return;
			}
			response.sendRedirect("error.html");
			return;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	}



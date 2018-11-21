package SampleLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logincontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "root@123");
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

//Krishna Sindhuri Vemuri- G01024066

package SWE642_Vemuri;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;




import SWE642_Vemuri.StudentBean;

@WebServlet(name = "SWE642_Vemuri", urlPatterns = {"/SWE642_Vemuri"})

public class StudentDAO {
	public void saveForm(HttpServletRequest request) throws ServletException,
    IOException {
		    String studentId = request.getParameter("studentId");
	        String username = request.getParameter("username");
	        String address = request.getParameter("address");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        String zip = request.getParameter("zip");
	        String phone = request.getParameter("phone");
	        String email = request.getParameter("email");
	        String url = request.getParameter("url");
	        String dos = request.getParameter("dos");
	        String month = request.getParameter("month");
	        String year = request.getParameter("year");
	        String comments = request.getParameter("comments");
	       	String data = request.getParameter("data");
	        String likelihood = request.getParameter("likelihood");
	      
	        
	        StudentBean Bean = new StudentBean();
	        
	       
	        Bean.setStudentId(studentId);
	        Bean.setName(username);
	        Bean.setAddress(address);
	        Bean.setCity(city);
	        Bean.setState(state);
	        Bean.setZip(zip);
	        Bean.setPN(phone);
	        Bean.setEmail(email);
	        Bean.setUrl(url);
	        Bean.setDos(dos);
	        Bean.setMonth(month);
	        Bean.setYear(year);
	        Bean.setComments(comments);
	        Bean.setData(data);
	        Bean.setLikelihood(likelihood);
	   
	        
	        
	      
	        try
		       {
		    	   Class.forName("oracle.jdbc.driver.OracleDriver");
	    } catch (ClassNotFoundException ex) {
	        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
		
	       
	        	        
	        try {
	        	 
	        	 Connection con;
	            con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "kvemuri2", "ogroaz");
	            
	            


	            String sql = "insert into Student values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	         
	           
	            PreparedStatement persist_db = con.prepareStatement(sql);
	            persist_db.setString(1, Bean.getStudentId());
	            persist_db.setString(2, Bean.getName());
	            persist_db.setString(3, Bean.getAddress());
	            persist_db.setString(4, Bean.getCity());
	            persist_db.setString(5, Bean.getState());
	            persist_db.setString(6, Bean.getZip());
	            persist_db.setString(7, Bean.getPN());
	            persist_db.setString(8, Bean.getEmail());
	            persist_db.setString(9, Bean.getUrl());
	            persist_db.setString(10, Bean.getDos());
	            persist_db.setString(11, Bean.getMonth());
	            persist_db.setString(12, Bean.getYear());
	            persist_db.setString(13, Bean.getComments());
	            persist_db.setString(14, Bean.getData());
	            persist_db.setString(15, Bean.getLikelihood());
	           
	         
	            
	           
	              persist_db.executeUpdate();
	              persist_db.close();
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }


	        
	}
	    public StudentBean retrieveForm(String id) {
	        StudentBean Bean = new StudentBean();

	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "kvemuri2", "ogroaz");
	            Statement stmt = con.createStatement();
	            id="'"+id+"'";
	            ResultSet result = stmt.executeQuery("select * from Student where studentId =" + id);
	            
	            while (result.next()) {
	                Bean.setStudentId(result.getString(1));
	                Bean.setName(result.getString(2));
	                Bean.setAddress(result.getString(3));
	                Bean.setCity(result.getString(4));
	                Bean.setState(result.getString(5));
	                Bean.setZip(result.getString(6));
	                Bean.setPN(result.getString(7));
	                Bean.setEmail(result.getString(8));
	                Bean.setUrl(result.getString(9));
	                Bean.setDos(result.getString(10));
	                Bean.setMonth(result.getString(11));
	                Bean.setYear(result.getString(12));
	                Bean.setComments(result.getString(13));
	                Bean.setData(result.getString(14));
	                Bean.setLikelihood(result.getString(15));	                
	                
	          
	            }
	            con.close();
	           
	        } catch (Exception e) {
	        }
	        
       return Bean; 
	    }


}

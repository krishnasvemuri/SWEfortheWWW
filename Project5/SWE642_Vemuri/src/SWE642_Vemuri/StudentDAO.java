//Krishna Sindhuri Vemuri- G01024066

package SWE642_Vemuri;


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
import SWE642_Vemuri.StudentDAO;

public class StudentDAO{
	
	public StudentBean getDO(String id){
		StudentBean BeanData = new StudentBean();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "kvemuri2", "ogroaz");
        	Statement stmt = con.createStatement();
        	id="'"+id+"'";
        	ResultSet result = stmt.executeQuery("select * from student where studentId =" + id);
 
            
            while (result.next()) 
            {
    	        BeanData.setStudentId(result.getString(1));
    	        BeanData.setUserName(result.getString(2));
    	        BeanData.setAddress(result.getString(3));
    	        BeanData.setCity(result.getString(4));
    	        BeanData.setState(result.getString(5));
    	        BeanData.setZip(result.getString(6));
    	        BeanData.setPhone(result.getString(7));
    	        BeanData.setEmail(result.getString(8));
    	        BeanData.setUrl(result.getString(9));
    	        BeanData.setDos(result.getString(10));
    	        BeanData.setMonth(result.getString(11));
    	        BeanData.setYear(result.getString(12));
    	        BeanData.setComments(result.getString(13));
    	        BeanData.setData(result.getString(14));
    	        BeanData.setLikelihood(result.getString(15));
            }
            con.close();
		}
		catch (Exception e){
			
		}
		return BeanData;
	}
	public void saveForm(StudentBean SB) throws IOException
    {
		try {
		
		    	   Class.forName("oracle.jdbc.driver.OracleDriver");
	    } catch (ClassNotFoundException ex) {
	        Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
	    }
		
	       
	        	        
	        try {
	        	 
	        	 Connection con;
	            con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "kvemuri2", "ogroaz");
	            
	            


	            String sql = "insert into Student values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	         
	           
	            PreparedStatement persist_db = con.prepareStatement(sql);
	            persist_db.setString(1, SB.getStudentId());
	            persist_db.setString(2, SB.getUserName());
	            persist_db.setString(3, SB.getAddress());
	            persist_db.setString(4, SB.getCity());
	            persist_db.setString(5, SB.getState());
	            persist_db.setString(6, SB.getZip());
	            persist_db.setString(7, SB.getPhone());
	            persist_db.setString(8, SB.getEmail());
	            persist_db.setString(9, SB.getUrl());
	            persist_db.setString(10, SB.getDos());
	            persist_db.setString(11, SB.getMonth());
	            persist_db.setString(12, SB.getYear());
	            persist_db.setString(13, SB.getComments());
	            persist_db.setString(14, SB.getData());
	            persist_db.setString(15, SB.getLikelihood());
	           
	         
	            
	           
	              persist_db.executeUpdate();
	              persist_db.close();
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }


	        
	}
	public String Ids() 
	{
		
		 String id="";
		 try 
		 {
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "kvemuri2", "ogroaz");
	            Statement stmt = con.createStatement();   
	            ResultSet res1 = stmt.executeQuery("Select studentID from student");
	            while (res1.next()) 
	            {
	                id=id+res1.getString(1)+",";
	            }
	            
	            con.close();
	           
	      } 
		  catch (Exception e) 
		  {
	      }
		return id;
	}


}

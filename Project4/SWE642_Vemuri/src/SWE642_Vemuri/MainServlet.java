//Krishna Sindhuri Vemuri- G01024066

package SWE642_Vemuri;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MainServlet() {
        super();
    }




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO StuDAO= new StudentDAO();
		StuDAO.saveForm(request);
		float mean;
		double stdDev;
		String dataValues=request.getParameter("data");
		DataProcessor dataProc=new DataProcessor();
		mean=dataProc.Mean_Method(dataValues);
		stdDev=dataProc.Standard_Deviation_Method(dataValues,mean);
		DataBean dataBean=new DataBean();
		dataBean.setMean(mean);
		dataBean.setStandardDeviation(stdDev);

		String idString="";
		 try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@apollo.vse.gmu.edu:1521:ite10g", "kvemuri2", "ogroaz");
	            Statement stmt = con.createStatement();
	            ResultSet result = stmt.executeQuery("select studentId from Student");
	            while (result.next()) {
	                idString=idString+result.getString(1)+",";
	            }
	            
	            con.close();
	           
	        } catch (Exception e) {
	        }
		 String[] id_list = idString.split(",");
	
		request.setAttribute("id_jsp", id_list);
			HttpSession session = request.getSession();
			session.setAttribute("dataBean1", dataBean);			
			
			RequestDispatcher dispatcher;
		String address;
			if (dataBean.getMean() >= 90) {
				address = "WinnerAcknowledgement.jsp";
			} else {
				address = "SimpleAcknowledgement.jsp";
			}

			dispatcher = request.getRequestDispatcher(address);
			dispatcher.forward(request, response);
		
		
		
		
	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO StuDAO1 = new StudentDAO();
		String ID=request.getParameter("id");
		StudentBean stuBean1=StuDAO1.retrieveForm(ID);
		HttpSession session = request.getSession();
		session.setAttribute("studentdetails", stuBean1);
		request.setAttribute("pid" , ID);
		String add;
		if (stuBean1 != null)
		{  add = "StudentDetails.jsp";}
		else
		{
			add= "NoSuchStudent.jsp";
		}
		 
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher(add);
		dispatcher.forward(request, response);
		
		
	}

}

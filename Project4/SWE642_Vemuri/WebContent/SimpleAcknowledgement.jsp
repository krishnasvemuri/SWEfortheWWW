<!-- Krishna Sindhuri Vemuri- G01024066 -->
<!-- It is a JSP page that is displayed when mean of the entered data is less than 90 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="SWE642_Vemuri.*"%>
    <%@page import=" java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Survey Completed</title>
<style>
h1 {
    color: blue;
	text-shadow: 2px 2px;
}
body {
     background-color: lightgray;	 
}
</style>
</head>
<body> 
<div>
<a href="https://www2.gmu.edu" target="_blank"><img id="logo" src="logo.jpg" style ="position:fixed;bottom:0;right:10%" title = "Please visit https://www.gmu.edu for more informatio"> </a>
<h4 style="position:fixed;bottom:0;right:0%"><br>Vemuri</h4>
</div>
<h3>Thank you for taking the survey!!</h3>
		Mean: ${dataBean1.getMean() }<br/>
		Standard Deviation:${dataBean1.getStandardDeviation() }<br/>
		Data entered by you is successfully saved<br/>
<h4>Select Id's from the following list:</h4>
	
<ul>
		<%
		String[] idstring = (String[])request.getAttribute("id_jsp");
		
		
			for (int i=0;i<idstring.length;i++) {
			String stuid = idstring[i];
		%>		
		<li><a href="/SWE642_Vemuri/MainServlet?id=<%=stuid%>"><%=stuid%></a></li>		
		<%
			}
		%>
</ul>
	
</body>
</html>
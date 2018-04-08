<!-- Krishna Sindhuri Vemuri- G01024066 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="SWE642_Vemuri.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
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
<div>
<h4>Student Id:</h4> <h3>${ studentdetails.getStudentId()}</h3><br/></div>
<table  width="80%" align="center">


<tr><td><b>Name</b>: ${ studentdetails.getName()}</td> </tr>
<tr><td><b>Address</b>: ${ studentdetails.getAddress()} , ${ studentdetails.getCity() }, ${ studentdetails.getState()} ${ studentdetails.getZip() }</td></tr>


<tr><td><b>Phone number</b>: ${ studentdetails.getPN()}</td></tr>
<tr><td><b>Email</b>: ${ studentdetails.getEmail()}</td></tr>
<tr><td><b>URL</b>: ${ studentdetails.getUrl()}</td></tr>

<tr><td><b>Date of Survey</b>: ${ studentdetails.getDos()}</td></tr>

<tr><td><b>Additional Comments</b>: ${studentdetails.getComments()}</td></tr>
<tr><td><b><i>${ studentdetails.getName()} </i>will be Graduating by </b>: ${studentdetails.getMonth()} ${studentdetails.getYear()}</td></tr>

<tr><td><b> <i>${ studentdetails.getName()}</i> is ${studentdetails.getLikelihood()}  to recommend this university </b></td></tr>
<tr><td><b>Data <i>${ studentdetails.getName()}</i> entered for standard deviation</b>: ${studentdetails.getData()}</td></tr>
</table>
</body>
</html>
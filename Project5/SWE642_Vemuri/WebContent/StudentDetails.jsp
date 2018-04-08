<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
     <%@ page import="java.util.*"%>
<%@ page import="SWE642_Vemuri.*"%>
 <%@page import="java.util.HashMap"%>
    <%@page import=" java.util.Iterator"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>

</head>
 <body bgcolor="#d3d3d3">
 
<div>

<h1>Details of student ID <s:property value="getStudentDataRetrieve().getStudentId()" /></h1><br/>

<h4>Name:<s:property value="getStudentDataRetrieve().getUserName()" /></h4>

<h4>Street Address: <s:property value="getStudentDataRetrieve().getAddress()" /></h4>

<h4>City:<s:property value="getStudentDataRetrieve().getCity()" /></h4>
<h4>State:<s:property value="getStudentDataRetrieve().getState()" /></h4>
<h4>Zip Code:<s:property value="getStudentDataRetrieve().getZip()" /></h4>
<h4>Telephone: <s:property value="getStudentDataRetrieve().getPhone()" /></h4>
<h4>E-mail: <s:property value="getStudentDataRetrieve().getEmail()" /></h4>
<h4>URL: <s:property value="getStudentDataRetrieve().getUrl()" /></h4>
<h4>Date Of Survey: <s:property value="getStudentDataRetrieve().getDos()" /></h4>
<h4>What did you like the most about the Campus? : <s:property value="getStudentDataRetrieve().getLikelihood()" /></h4>
<h4>Comments:<s:property value="getStudentDataRetrieve().getComments()" /></h4> 
 <h4><s:property value="getStudentDataRetrieve().getUserName()" /> will be graduating by<s:property value="getStudentDataRetrieve().getMonth()" />
<s:property value="getStudentDataRetrieve().getYear()" /></h4>
</div>

</body>
</html>
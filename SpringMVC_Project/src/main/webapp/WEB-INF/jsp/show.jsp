
<%@page import="com.bean.standard"%>
<%@page import="com.dao.studentdao"%>
<%@page import="com.bean.student"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="5" cellpadding="10px" cellspacing="10px" width="100%">
<tr>

<th>ID</th>
<th>Name</th>
<th>status</th>
<th>First_Name</th>
<th>Last_Name</th>
<th>Date_Birth</th>
<th>Created Date</th>

<th>EDIT</th>
<th>DELETE</th>
</tr>

<%

ApplicationContext a= new ClassPathXmlApplicationContext("beans.xml");
studentdao sdao=(studentdao)a.getBean("studentdao");
List<student> list=sdao.getallstudent();


   for(student s:list)
   
   {
	  // standard std=sdao.getstandard(s.getStandard().getSid());
	 %>
	  <tr>
	  <td><%=s.getStandard().getSid()%> </td>
	  <td><%=s.getStandard().getName() %> </td>
	  <td><%=s.getStandard().getStatus() %> </td>
	  <td><%=s.getFisrt_name() %> </td>
	  <td><%=s.getLast_name()%> </td>
	   <td><%=s.getDob()%> </td>
	   <td><%=s.getCreated_date()%> </td>
	  
	  
	  <td>
	  <form action="MyController" name="edit" method="post">
	  <input type="hidden" name="id" value="<%=s.getId()%>">
	  
	  <input type="submit" name="action" value="EDIT">
	  
	  </form>
	  </td>
	  <td>
	  <form action="MyController" name="delete" method="post">
	   <input type="hidden" name="id" value="<%=s.getId()%>">
	  <input type="submit" name="action" value="DELETE">
	  
	  </form>
	  </td>
	  
	  
	  </tr>
	  
	<%   
   }

%>




</table>
</body>
</html>
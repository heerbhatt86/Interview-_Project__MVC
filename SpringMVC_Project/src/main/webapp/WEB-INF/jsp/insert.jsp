<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.apache.catalina.valves.StuckThreadDetectionValve"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.studentdao"%>
<%@page import="com.bean.standard"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<style type="text/css">
tr,td{
padding: 10px;
}

</style>
</head>
<body>
<%
 if(request.getAttribute("msg")!=null){
	 out.println("<b style= color:blue;>"+request.getAttribute("msg")+"</style></b>");
 }
%>
<%
ApplicationContext a= new ClassPathXmlApplicationContext("beans.xml");
studentdao sdao=(studentdao)a.getBean("studentdao");
List<standard> list=sdao.getallstandard();
%>
<form name = "insert"  method = "post" action="insert">
<table>
<tr>
			<td>Select Standard</td>
			<td>
				<select name="standard">
					<option>---Select Standard---</option>
					<%
						for(standard s:list)
						{
					%>
						<option value="<%=s.getSid()%>"><%=s.getName() %></option>
					<%	
						}
					%>
				</select>
			</td>
		</tr>

<tr>
<td> First name</td>
<td><input type = "text" name = "first_name"></td>
</tr>
<tr>
<td> Last name</td>
<td><input type = "text" name = "last_name"></td>
</tr>

<tr>
<td>Name </td>
<td><input type = "text" name = "name"></td>
</tr>

<tr>
<td>Date of Birth </td>
<td><input type = "date" name = "dob"></td>
</tr>


<tr>
<td colspan ="2" align ="center">
<input type = "submit" name="action" value ="INSERT" class="btn btn-primary"> 

</td>
</tr>


</table>

</form>
<a href="standard">Insert Standard</a><br><br>

</body>
</html>
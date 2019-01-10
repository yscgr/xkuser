<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.xk.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>xkUser</title>
	</head>
	<body>
		<%  ArrayList<User> allUsers = (ArrayList<User>)request.getAttribute("allUsers"); %>
		<center>
					<h4>欢迎<%=request.getAttribute("user")%>登录</h4>
			<table border="1px" cellspacing="0" cellpadding="5">
				<%
					for(int i = 0;i < allUsers.size();i++){
						User user = allUsers.get(i);
				%>
						<tr>
							<td><%=user.getId()%></td>
							<td><%=user.getUsername()%></td>
							<td><%=user.getPassword()%></td>
							<td><%=user.getEmail()%></td>
							<td><%=user.getIdentity()%></td>
						</tr>		
				<%	
				}
				%>
			</table>
		</center>
	</body>
</html>
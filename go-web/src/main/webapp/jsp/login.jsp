<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   ${pageContext.request.contextPath }  
 	<br/> <br/>
	<form action="<%=basePath %>index/login" method="post">
		username: <input type="text" name="username"> <br/> <br/>
		password: <input type="text" name="password"> <br/> <br/>
		<input type="submit" value="登录">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addUser.do" method="post">
id:<input type="text" name="id"/><br>
username:<input type="text" name="username"/><br>
<input type="submit" value="add"/><br>
</form>
</body>
</html>
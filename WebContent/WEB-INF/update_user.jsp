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
<form action="${pageContext.request.contextPath}/edit.do" method="post">
<input type="hidden" name="id" value="${user.id}"/>
id:<input type="text"  value="${user.id}" disabled="disabled"/><br>
username:<input type="text" name="username" value="${user.username}"/><br>
<input type="submit" value="edit"/><br>
</form>
</body>
</html>
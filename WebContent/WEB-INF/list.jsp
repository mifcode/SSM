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
<table>

<tr><th>id</th><th>username</th><th>操作</th></tr>
<c:forEach items="${list}" var="u">
<tr><td>${u.id}</td><td>${u.username}</td>
<td><a href="${pageContext.request.contextPath}/updateUser.do?id=${u.id}">更新</a>||
		<a href="${pageContext.request.contextPath}/deleteUser.do?id=${u.id}">删除</a></td></tr>

</c:forEach>
</table>

		总页数：${pageCount},当前第${pageNum}页，每页显示${pageSize}条数据
</body>
</html>
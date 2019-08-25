<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="dao.VoteDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] teacherno = request.getParameterValues("teacherno");
		VoteDao vdao = new VoteDao();
		vdao.updateVotes(teacherno);
	%>
	<jsp:forward page="display.jsp"></jsp:forward>
</body>
</html>
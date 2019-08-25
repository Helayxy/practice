<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="dao.VoteDao"%>
<%@page import="vo.Vote"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>投票系统</title>
</head>
<body>
	<form action="vote.jsp" method="post">
		<table align="center">
			<caption>
				欢迎给喜欢的老师投票<input type="submit" value="提交投票">
			</caption>
			<tr bgcolor="yellow">
				<td>编号</td>
				<td>姓名</td>
				<td>得票数</td>
				<td>投票</td>
			</tr>
			<%
				VoteDao vdao = new VoteDao();
				ArrayList votes = vdao.getAllVotes();
				for (int i = 0; i < votes.size(); i++) {
					Vote vote = (Vote) votes.get(i);
			%>
			<tr bgcolor="pink">
				<td><%=vote.getTeacherno()%></td>
				<td><%=vote.getTeachername()%></td>
				<td><img src="img/bar.png" width="<%=vote.getVotenumber()%>"
					height="10"><%=vote.getVotenumber()%></td>
				<td><input name="teacherno" type="checkbox"
					value="<%=vote.getTeacherno()%>"></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</body>
</html>
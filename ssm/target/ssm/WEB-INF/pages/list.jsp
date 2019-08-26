<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/25
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--引入jstl标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>查询所有的用户</h3>
<c:forEach items="${list}" var="account">
    ${account.username}
</c:forEach>

</body>
</html>

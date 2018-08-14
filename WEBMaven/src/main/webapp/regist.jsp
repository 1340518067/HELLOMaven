<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/13
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h2>用户注册</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="username" placeholder="请输入用户名" />
        <br>
        <input type="password" name="password" placeholder="请输入密码" />
        <br>
        <input type="submit" value="注册" />
    </form>
</div>
<div align="center">
    <div style="color:red" align="center">${msg}</div>
</div>
</body>
</html>

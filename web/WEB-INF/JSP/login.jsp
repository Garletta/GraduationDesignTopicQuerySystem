<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-16
  Time: 上午10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <h2>欢迎使用毕业设计题目系统!</h2><hr>
    <form action="login.action" method="post">
        <s:textfield name="account" theme="simple">请输入账号：</s:textfield>
        <s:fielderror fieldName="account" cssStyle="color:red" theme="simple"/><br>
        <s:password name="password" theme="simple">请输入密码：</s:password>
        <s:fielderror fieldName="password" cssStyle="color:red" theme="simple"/><br>
        <s:submit value="登陆"/>
        <s:actionerror cssStyle="color:red"/>
    </form><hr>
    <a href="register.jsp">注册</a>
</body>
</html>

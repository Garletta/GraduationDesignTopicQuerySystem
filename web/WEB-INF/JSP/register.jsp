<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-16
  Time: 下午3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    <h2>欢迎注册毕业设计题目系统!</h2><hr>
    <form action="register.action" method="post">
        <s:textfield name="account" theme="simple" value="">请输入账号：</s:textfield>
        <s:fielderror fieldName="account" cssStyle="color:red" theme="simple"/><br>
        <s:password name="password" theme="simple" value="">请输入密码：</s:password>
        <s:fielderror fieldName="password" cssStyle="color:red" theme="simple"/><br>
        <s:textfield name="student" theme="simple" value="">请输入姓名：</s:textfield>
        <s:fielderror fieldName="student" cssStyle="color:red" theme="simple"/><br>
        <s:submit value="注册"/>
        <s:actionerror cssStyle="color:red"/>
        <s:actionmessage cssStyle="font-size: 50px"/>
    </form><hr>
    <a href="login.jsp">登陆</a>
</body>
</html>

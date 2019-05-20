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
    <table>
    <form action="register.action" method="post">
        <tr>
            <td>请输入账号：</td>
            <td><input type="text" name="account"></td>
            <td><s:fielderror fieldName="account" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>请输入密码：</td>
            <td><input type="password" name="password"></td>
            <td><s:fielderror fieldName="password" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>请输入姓名：</td>
            <td><input type="text" name="student"></td>
            <td><s:fielderror fieldName="student" cssStyle="color:red"  /></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册" style="font-size: 15px"/></td>
            <td><a href="login.jsp" style="font-size: 15px">登陆</a></td>
        </tr>
        <tr><s:actionerror cssStyle="color:red"/>
        <s:actionmessage cssStyle="font-size: 20px"/></tr>
    </form>
    </table><hr>
</body>
</html>

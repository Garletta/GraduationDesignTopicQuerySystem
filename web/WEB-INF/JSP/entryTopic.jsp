<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-16
  Time: 下午6:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>entryTopic</title>
</head>
<body>
    <h2>欢迎 ${sessionScope.user.student } 使用毕业设计题目系统!</h2><hr>
    <h2>请录入新的毕业设计题目:</h2>
    <form action="entry.action" method="post">
        <s:textfield name="student" theme="simple" value="">请输入负责人：</s:textfield>
        <s:fielderror fieldName="student" cssStyle="color:red" theme="simple"/><br>
        <s:textfield name="topic" theme="simple" value="">请输入题目名：</s:textfield>
        <s:fielderror fieldName="topic" cssStyle="color:red" theme="simple"/><br>
        <s:textfield name="college" theme="simple" value="">请输入学院名：</s:textfield>
        <s:submit value="录入"/>
        <s:actionerror cssStyle="color:red"/>
        <s:actionmessage/>
    </form><hr>
    <form action="graduation.jsp" method="post">
        <input type="submit" value="返回菜单">
    </form>
</body>
</html>

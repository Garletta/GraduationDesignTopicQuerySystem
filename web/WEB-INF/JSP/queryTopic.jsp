<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-16
  Time: 下午4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>queryTopic</title>
</head>
<body>
    <h2>欢迎 ${sessionScope.user.student } 使用毕业设计题目系统!</h2><hr>
    <h2>查询毕业设计题目:</h2>
    <form action="query.action" method="post">
        <s:textfield name="keyword" theme="simple" value="">请输入查询关键字：</s:textfield>
        <s:fielderror fieldName="keyword" cssStyle="color:red" theme="simple"/><br>
        <s:submit value="查询"/>
        <s:actionerror cssStyle="color:red"/>
    </form><hr>
    <form action="graduation.jsp" method="post">
        <input type="submit" value="返回菜单">
    </form>
</body>
</html>

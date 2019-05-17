<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-16
  Time: 上午11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>graduationSystem</title>
</head>
<body>
    <h2>欢迎 ${sessionScope.user.student } 登陆毕业设计题目系统!</h2><hr>
    <table border="2">
        <tr>
            <th></th>
            <th>项目</th>
            <th>选择</th>
        </tr>
        <tr>
            <td> ● </td>
            <td>毕业设计题目所属学院录入</td>
            <td><a href="filterTopic.action">选择</a> </td>
        </tr>
        <tr>
            <td> ● </td>
            <td>毕业设计题目信息录入</td>
            <td><a href="entryTopic.jsp">选择</a> </td>
        </tr>
        <tr>
            <td> ● </td>
            <td>毕业设计题目信息查询</td>
            <td><a href="queryTopic.jsp">选择</a> </td>
        </tr>
    </table>
</body>
</html>

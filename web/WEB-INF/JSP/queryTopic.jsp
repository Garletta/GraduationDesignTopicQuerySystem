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
    <h3>查询毕业设计题目:</h3>
    <form action="query.action" method="post">
        <s:textfield name="keyword" theme="simple" value="">请输入查询关键字：</s:textfield>
        <s:fielderror fieldName="keyword" cssStyle="color:red" theme="simple"/>
        <s:submit value="查询" theme="simple"/>
        <s:actionerror cssStyle="color:red"/>
    </form><hr>
    <table cellspacing="20px">
        <tr>
        <td>
            <form action="graduation.jsp" method="post">
                <input type="submit" value="返回菜单" style="font-size: 20px">
            </form>
        </td>
        <td>
            <form action="quit.action" method="post">
                <input type="submit" value="退出" style="font-size: 20px">
            </form>
        </td>
        </tr>
    </table>
</body>
</html>

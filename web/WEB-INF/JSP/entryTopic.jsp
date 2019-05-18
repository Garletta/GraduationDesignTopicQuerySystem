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
    <h3>请录入新的毕业设计题目:</h3>
    <table>
    <form action="entry.action" method="post">
        <tr>
            <td>请输入负责人：</td>
            <td><input type="text" name="student"></td>
            <td><s:fielderror fieldName="student" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>请输入题目名：</td>
            <td><input type="text" name="topic"></td>
            <td><s:fielderror fieldName="topic" cssStyle="color:red"/></td>
        </tr>
        <tr>
            <td>请输入学院名：</td>
            <td><input type="text" name="college"></td>
        </tr>
        <tr>
            <td><input type="submit" value="录入"></td>
            <s:actionerror cssStyle="color:red"/>
            <s:actionmessage/>
        </tr>
    </form>
    </table><hr>
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

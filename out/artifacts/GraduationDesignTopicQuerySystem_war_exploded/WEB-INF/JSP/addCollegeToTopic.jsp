<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-16
  Time: 下午8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="Table.Design" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>addCollegeToTopic</title>
</head>
<body>
    <h2>欢迎 ${sessionScope.user.student } 使用毕业设计题目系统!</h2><hr>
    <h3>筛选毕业设计题目:</h3>
    <form action="filterTopic.action" method="post">
        筛选关键字：<input type="text" name="keyword">
        <input type="submit" value="筛选">
    </form><hr>
    <table border="2" style="text-align: center">
        <tr>
            <th>编号</th>
            <th>负责人</th>
            <th>毕业设计题目</th>
            <th>所属学院</th>
            <th>操作</th>
        </tr>
        <%
            Map se = ActionContext.getContext().getSession();
            ArrayList<Design> topics = (ArrayList<Design>) se.get("topics");
            for(int i = 0;i < topics.size();i++) {
        %>
        <tr>
            <form action="addCollege.action" method="post">
            <td><%=i+1%></td>
            <td><input type="hidden" name="student" value=<%=topics.get(i).getStudent()%>><%=topics.get(i).getStudent()%></td>
            <td><%=topics.get(i).getTopic()%></td>
            <td><input type="text" name="college" value=<%=topics.get(i).getCollege()%>></td>
            <td><input type="submit" value="录入"></td>
            </form>
        </tr>
        <%
            }
        %>
        <s:actionerror cssStyle="color:red"/>
        <s:actionmessage/>
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

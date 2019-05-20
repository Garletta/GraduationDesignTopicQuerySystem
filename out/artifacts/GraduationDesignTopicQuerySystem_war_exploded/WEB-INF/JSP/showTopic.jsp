<%--
  Created by IntelliJ IDEA.
  User: arletta
  Date: 19-5-16
  Time: 下午5:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Table.Design" %>
<html>
<head>
    <title>showTopic</title>
</head>
<body>
    <h2>欢迎 ${sessionScope.user.student } 使用毕业设计题目系统!</h2><hr>
    <h3>查询到的毕业设计题目如下:</h3>
    <table border="2">
        <tr>
            <th>编号</th>
            <th>负责人</th>
            <th>毕业设计题目</th>
            <th>所属学院</th>
        </tr>
        <%
            Map se = ActionContext.getContext().getSession();
            ArrayList<Design> topics = (ArrayList<Design>) se.get("topics");
            for(int i = 0;i < topics.size();i++) {
        %>
        <tr>
            <td><%=i+1%></td>
            <td><%=topics.get(i).getStudent()%></td>
            <td><%=topics.get(i).getTopic()%></td>
            <td><%=topics.get(i).getCollege()%></td>
        </tr>
        <%
            }
        %>
    </table><hr>
    <table cellspacing="20px">
        <tr>
        <td>
            <form action="queryTopic.jsp" method="post">
                <input type="submit" value="返回查询">
            </form>
        </td>
        <td>
            <form action="graduation.jsp" method="post">
                <input type="submit" value="返回菜单">
            </form>
        </td>
        <td>
            <form action="quit.action" method="post">
                <input type="submit" value="退出">
            </form>
        </td>
        </tr>
    </table>
</body>
</html>

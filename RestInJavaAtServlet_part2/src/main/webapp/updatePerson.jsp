<%--
  Created by IntelliJ IDEA.
  User: kosav
  Date: 11.08.2022
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="updatePersonById" method="POST">
    <%
        String id = request.getParameter("id");
        response.addCookie(new Cookie("id", id));
    %>
    First name: <input type="text" name="firstName" value="${firstName}"/>
    <br><br>
    First name: <input type="text" name="secondName" value="${secondName}"/>
    <br><br>
    Age: <input type="text" name="age" value="${age}"/>
    <br><br>
    City: <input type="text" name="city" value="${city}"/>
    <br><br>
    Company: <input type="text" name="company" value="${company}"/>
    <br><br>
    Language: <input type="text" name="language" value="${language}"/>
    <br><br>
    Salary: <input type="text" name="salary"  value="${salary}"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>

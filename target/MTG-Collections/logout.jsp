<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 4/21/17
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>You are logged out.</title>
</head>
<body>
    <h1><% session.invalidate(); %></h1>
    <a href="index.jsp">Log Back In</a>
</body>
</html>
--%>

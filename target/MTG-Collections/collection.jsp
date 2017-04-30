<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2/8/17
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>MTG-Collection</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.jsp">MTG-Collections</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="logout.jsp">Logout</a></li>
                <li><a href="addCards.jsp">Add Cards</a></li>
                <li><a href="delete.jsp">Delete Cards</a></li>
            </ul>
        </div>
    </nav>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <div class="container-fluid">
        <div class="page-header">
            <h3>${user}'s collection</h3>
        </div>
        <div class="table-responsive">
            <table class="table table-striped">
                <tr>
                    <th>Quantity</th>
                    <th>Card Name</th>
                </tr>
                <c:forEach var="card" items="${cards}">
                    <tr>
                        <td>${card.quantity}</td>
                        <td>${card.card_name}<span data-id="${cards.id}"></span></td>
                        <td><button type="button" class="btn btn-danger">Delete</button></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
<script></script>
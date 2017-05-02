<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2/8/17
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>

    <div class="page-header">
        <h3 class="text-center">Add New Card</h3>
    </div>
    <div class="col-md-4 col-md-offset-4">
        <form class="form-horizontal" action="addCards" method="POST">
            <div class="form-group">
                <label class="control-label col-sm-2" for="cardName">Card Name:</label>
                <div class="col-sm-5">
                    <input type="card" name="card" class="form-control" id="cardName" placeholder="Enter Card Name">
                </div>
            </div>

            <div class="success">${success}</div>

            <div class="error">${error}</div>

            <ul>
                <c:forEach var="cardFound" items="${cardsFound}">
                    <li>${cardFound}</li>
                </c:forEach>
            </ul>

            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-5">
                    <button type="reset" class="btn btn-info">Clear</button>
                    <button type="submit" class="btn btn-info">Submit</button>
                </div>
            </div>
        </form>
    </div>
</html>

<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2/8/17
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>

    <h1>Add Card</h1>
    <form class="form-horizontal" action="addCard" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" for="cardName">Card Name:</label>
            <div class="col-sm-5">
                <input type="email" name="email" class="form-control" id="cardName" placeholder="Enter Card Name">
            </div>
        </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="setName">Set Name:</label>
            <div class="col-sm-5">
                <input type="setName" name="setName" class="form-control" id="setName" placeholder="Enter Set">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-5">
                <button type="reset" class="btn btn-info">Clear</button>
                <button type="submit" class="btn btn-info">Submit</button>
            </div>
        </div>
    </form>
</html>

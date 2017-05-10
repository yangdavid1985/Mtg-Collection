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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/css/dataTables.bootstrap.min.css" rel="stylesheet" />

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
                <li><a href="logout">Logout</a></li>
                <li><a href="addCards.jsp">Add New Card</a></li>
            </ul>
        </div>
    </nav>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
    <div class="container-fluid">
        <div class="page-header">
            <h3>${user}'s collection</h3>
        </div>
        <div class="table-responsive container">
            <table id="sort" class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Quantity</th>
                        <th>Card Name</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Quantity</th>
                    <th>Card Name</th>
                    <th>Edit</th>
                </tr>
                </tfoot>
                <tbody>
                    <c:forEach var="card" items="${cards}" varStatus="loop">
                        <tr name="cardRow">
                            <td class="col-md-4">
                                <input type="text" class="col-xs-2"  value="${card.quantity}" />
                            </td>
                            <td class="col-md-4" id="card${loop.index}">${card.card_name}</td>
                            <td class="col-md-4">
                                <button type="button" class="glyphicon glyphicon-plus" onclick="incrementCard('${loop.index}')"></button>
                                <button type="button" class="glyphicon glyphicon-minus" onclick="deleteCard('${loop.index}')"></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button type="button" class="btn" onclick="updateCollection()">Save Changes</button>
        </div>
    </div>
</body>
</html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.12/js/dataTables.bootstrap.min.js"></script>
<script>

    /**
     * Delete 1 card with delete button
     *
     *@param cardName
     */
    deleteCard = function(index) {
        var cardName = $('#card' + index).text();
        $.ajax({
            type: "post",
            url: "deleteCards",
            data: {"cardName":cardName},
            success: function(data){
                location.reload();
            }
        });
    };


    /**
     * Allow user to update by entering quantity in input box
     */
    updateCollection = function(){
        var cards = [];
        var cardQuantity;
        var cardName;

        var cardQuantities = [];
        var cardNames = [];

        $("tr[name='cardRow']").each(function () {
            cardQuantity = $(this).children("td").eq(0).children().eq(0).val();
            cardName = $(this).children("td").eq(1).html();
            cardQuantities.push(cardQuantity);
            cardNames.push(cardName);
        });

        $.ajax({
            type: "post",
            url: "updateCollection",
            data: {"cardNames" : cardNames, "cardQuantities" : cardQuantities},
            success: function(data) {
                location.reload();
            }
        });
    };

    /**
     * Increment 1 card with add button
     *
     * @param cardName
     */
    incrementCard = function (index) {
        var cardName = $('#card' + index).text();
        $.ajax({
            type: "post",
            url: "incrementCard",
            data: {"cardName" : cardName},
            success: function (data) {
                location.reload();
            }
        });
    };

    /**
     * Table sorting plugin
     */
    $(document).ready(function() {
        $('#sort').DataTable(
            {
                "aoColumns": [
                    { "bSortable": false},
                    null,
                    {"bSortable": false}
                ]
            }
        );
    } );
</script>
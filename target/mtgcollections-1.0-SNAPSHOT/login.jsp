<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2/8/17
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
    <body>
        <div class="container">
            <h2>Log In</h2>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="email">Email:</label>
                    <div class="col-sm-5">
                        <input type="email" class="form-control" id="email" placeholder="Enter email">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd">Password:</label>
                    <div class="col-sm-5">
                        <input type="password" class="form-control" id="pwd" placeholder="Enter password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-5">
                        <button type="reset" class="btn btn-info">Clear</button>
                        <button type="submit" class="btn btn-info">Login</button>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-5">
                        <div>
                            Don't have an account!
                            <a href="signup.jsp">
                                Sign Up Here!
                            </a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>

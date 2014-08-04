<%--
  Created by IntelliJ IDEA.
  User: edwin
  Date: 7/21/14
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6 well well-large">
            <h1>Edit User (ID: ${researcher.id})</h1>
            <form method="POST" action="/researcher/update">
                <fieldset>
                    <legend>Authentication</legend>

                    <input type="hidden" name="id" value="${researcher.id}">

                    <label>Username</label>
                    <input type="text" name="username" value="${researcher.username}">

                    <label>Password</label>
                    <input type="password" name="password" value="${researcher.password}">

                    <legend>Basic Information</legend>

                    <label>First Name</label>
                    <input type="text" name="firstname" value="${researcher.firstname}">

                    <label>Last Name</label>
                    <input type="text" name="lastname" value="${researcher.lastname}">

                    <label>Address</label>
                    <input type="text" name="address" value="${researcher.address}">

                    <label>Country</label>
                    <input type="text" name="country" value="${researcher.country}">

                    <label>Phone</label>
                    <input type="text" name="phone" value="${researcher.phone}">

                    <label>State</label>
                    <input type="text" name="state" value="${researcher.state}">

                    <label>Zip Code</label>
                    <input type="text" name="zip" value="${researcher.zip}">

                    <div class="alert">
                        <strong>Warning!</strong> After clicking the update button, the information of this user will be overwritten immediately.
                    </div>

                    <button class="btn btn-primary btn-large" type="submit">Update Changes</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>

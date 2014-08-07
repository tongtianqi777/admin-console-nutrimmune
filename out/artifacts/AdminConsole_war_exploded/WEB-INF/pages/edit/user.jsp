<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Edit Protocol (ID: ${protocol.id})</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6.center text-center">
            <div class="border-form-div">

                <h3>Edit User (ID: ${researcher.id})</h3>

                <form class="form-horizontal" method="POST" action="/researcher/update">

                    <legend>Authentication</legend>

                    <input type="hidden" name="id" value="${researcher.id}">

                    <div class="control-group">
                        <label>Username</label>
                        <input type="text" name="login" value="${researcher.login}">
                    </div>
                    <div class="control-group">
                        <label>Password</label>
                        <input type="password" name="password" value="${researcher.password}">
                    </div>

                    <div class="control-group">

                        <label>Token</label>
                        <input type="text" name="token" value="${researcher.token}">

                    </div>
                    <legend>Basic Information</legend>

                    <div class="control-group">
                        <label>First Name</label>
                        <input type="text" name="firstname" value="${researcher.firstname}">
                    </div>
                    <div class="control-group">
                        <label>Last Name</label>
                        <input type="text" name="lastname" value="${researcher.lastname}">
                    </div>
                    <div class="control-group">
                        <label>Address</label>
                        <input type="text" name="address" value="${researcher.address}">
                    </div>
                    <div class="control-group">
                        <label>Country</label>
                        <input type="text" name="country" value="${researcher.country}">
                    </div>
                    <div class="control-group">
                        <label>Phone</label>
                        <input type="text" name="phone" value="${researcher.phone}">
                    </div>
                    <div class="control-group">
                        <label>State</label>
                        <input type="text" name="state" value="${researcher.state}">
                    </div>
                    <div class="control-group">
                        <label>Zip Code</label>
                        <input type="text" name="zip" value="${researcher.zip}">
                    </div>

                    <legend>Operations</legend>

                    <div class="control-group">
                        <label>Status</label>
                        <input type="text" name="status" value="${researcher.status}">
                    </div>

                    <legend>Others</legend>

                    <div class="control-group">
                        <label>Affiliation</label>
                        <input type="text" name="affiliation" value="${researcher.affiliation}">
                    </div>
                    <div class="control-group">
                        <label>Time Zone</label>
                        <input type="text" name="timezone" value="${researcher.timezone}">
                    </div>

                    <div class="control-group">
                        <div class="span3.center">
                            <div class="alert">
                                <strong>Warning!</strong> After clicking the update button, the information of this
                                protocol will be overwritten immediately.
                            </div>
                        </div>
                    </div>

                    <div class="control-group">
                        <button class="btn btn-primary btn-large" type="submit">Update Changes</button>
                    </div>

                </form>

                <a href="/researcher">Back to Researchers</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
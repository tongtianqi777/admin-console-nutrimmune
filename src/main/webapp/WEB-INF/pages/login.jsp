<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Authorization</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap_and_overrides.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/login/css/login.css" rel="stylesheet" >
</head>
<body>
<div class="container-fluid">
    <div id="center-area" class="span9" data-original-title="" title="">
        <div class="hero-unit">
            <h1>Nutrimmune</h1>
            <h2>Admin Console</h2>
            <div class="row">
                <div class="span4">
                    <form class="form-horizontal" action="${security_check_url}" method="POST">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Email</label>
                            <div class="controls">
                                <input type="text" id="inputEmail" name="username" placeholder="someone@example.com">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Password</label>
                            <div class="controls">
                                <input type="password" id="inputPassword" name="password" placeholder="Password">
                            </div>
                        </div>
                        <div class="control-group">
                            <a id="forgot-pass" href="#">Forgot your password?</a>
                        </div>
                        <div class="control-group">
                            <button type="submit" id="signin" class="btn btn-primary span4">Sign in</button>
                        </div>
                    </form>
                </div>
                <div class="span4">
                    <p class="description">The admin console is somewhere you can view, modify or add new users, devices, protocols. You can also view logs, active users, popular protocols, etc.</p>
                </div>
            </div>
            <c:if test="${not empty login_msg}">
                <div class="well well-small login-msg">
                        ${login_msg}
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
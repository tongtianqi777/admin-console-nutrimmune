<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<link rel="icon"
      type="image/x-icon"
      href="/resources/favicon.ico">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Authorization</title>
    <link rel="stylesheet" href="//bootswatch.com/darkly/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/resources/login/css/login.css" rel="stylesheet" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.2.6.min.js"></script>

    <script src="${pageContext.request.contextPath}/resources/login/js/login.js"></script>

    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>


<div class="container">
    <div class="login-container">
        <c:if test="${not empty login_msg}">
            <div id="output" class="alert-danger">
                ${login_msg}
            </div>
        </c:if>
        <div class="avatar"></div>
        <div class="form-box">
            <form action="${security_check_url}" method="POST">
                <input name="username" id="inputEmail" type="text" placeholder="someone@example.com">
                <input name="password" id="inputPassword" type="password" placeholder="password">
                <button id="signin" class="btn btn-primary btn-block login" type="submit">Login</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
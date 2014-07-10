<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>All Users</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap_and_overrides.css" rel="stylesheet" >

</head>
<body>
    <%@ include file="/WEB-INF/layouts/header.jsp" %>

    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span12">
                <h1>All Users</h1>
                <table class="table table-striped">
                    <tr>
                        <td>User</td>
                        <td>Played</td>
                        <td>Created</td>
                        <td>Published</td>
                        <td>Reviews</td>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>${user.firstname} ${user.lastname}</td>
                            <td>0</td>
                            <td>0</td>
                            <td>0</td>
                            <td>0</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</body>
</html>

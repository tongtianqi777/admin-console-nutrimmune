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
            <h1>All Protocols</h1>
            <table class="table table-striped">
                <tr>
                    <td>Protocol</td>
                    <td>Author</td>
                    <td>Version</td>
                    <td>Community</td>
                    <td>Played</td>
                    <td>Downloaded</td>
                    <td>Reviews</td>
                    <td>Status</td>
                    <td>Operations</td>

                </tr>
                <c:forEach var="protocol" items="${protocols}">
                    <tr>
                        <td>${protocol.name}</td>
                        <td>${protocol.authorName}</td>
                        <td>0</td>
                        <td>0</td>
                        <td>${protocol.timePlayed}</td>
                        <td>0</td>
                        <td>0</td>
                        <td>${protocol.status}</td>
                        <td>TBD</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
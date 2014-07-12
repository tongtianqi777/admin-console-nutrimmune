<%--
  Created by IntelliJ IDEA.
  User: Rix
  Date: 7/12/14
  Time: 2:11 PM
--%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>All Devices</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap_and_overrides.css" rel="stylesheet" >

</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h1>All Devices</h1>
            <table class="table table-striped">
                <tr>
                    <td>ID</td>
                    <td>Mac Address</td>
                    <td>Owner</td>
                    <td>Manufacture Date</td>
                    <td>Shipping Date</td>
                    <td>Status</td>
                </tr>
                <c:forEach var="device" items="${devices}">
                    <tr>
                        <td>${device.id}</td>
                        <td>${device.mac}</td>
                        <td>${device.owner}</td>
                        <td>${device.manufactureddate}</td>
                        <td>${device.shipdate}</td>
                        <td>${device.status}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>

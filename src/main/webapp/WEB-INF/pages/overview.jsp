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
    <title>Overview</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/overview.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h1>Users</h1>
            <%@ include file="/WEB-INF/templates/users_data.jsp" %>

            <h1>Devices</h1>
            <%@ include file="/WEB-INF/templates/devices_data.jsp" %>

            <h1>Protocols</h1>
            <%@ include file="/WEB-INF/templates/protocols_data.jsp" %>
        </div>
    </div>
</div>
</body>
</html>

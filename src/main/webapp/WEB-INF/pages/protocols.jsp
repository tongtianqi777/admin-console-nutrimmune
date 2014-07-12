<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>All Users</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap_and_overrides.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/tablesorter_theme_blue/style.css" rel="stylesheet" >

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-latest.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.tablesorter.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/protocols.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h1>All Protocols</h1>
            <%@ include file="/WEB-INF/templates/protocols_data.jsp" %>
        </div>
    </div>
</div>
</body>
</html>

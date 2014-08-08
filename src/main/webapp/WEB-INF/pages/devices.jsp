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
    <%@ include file="/WEB-INF/templates/resources.jsp" %>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/devices.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12 text-center">
            <h3>All Devices</h3>

            <c:if test="${not empty success_message}">
                <div id="output" class="center alert-success">
                        ${success_message}
                </div>
            </c:if>

            <div class="super-right">
                <a href="/devices/add" class="btn btn-success"><i
                        class="icon-plus-sign icon-white"></i> Add New Device</a>
            </div>
            <%@ include file="/WEB-INF/templates/devices_data.jsp" %>
        </div>
    </div>
</div>
</body>
</html>

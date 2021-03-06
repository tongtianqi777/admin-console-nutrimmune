<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>All Protocols</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
    <link href="${pageContext.request.contextPath}/resources/css/protocols.css" rel="stylesheet" >

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/protocols.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12 text-center">
            <h3>All Protocols</h3>

            <c:if test="${not empty success_message}">
                <div id="output" class="center alert-success">
                        ${success_message}
                </div>
            </c:if>

            <%@ include file="/WEB-INF/templates/protocols_data.jsp" %>
        </div>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: edwin
  Date: 7/21/14
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Community</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/community.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12 text-center">
            <h3>All Communities</h3>
            <a href="/community/add">Add a Community</a>
            <%@ include file="/WEB-INF/templates/community_data.jsp" %>
        </div>
    </div>
</div>

</body>
</html>

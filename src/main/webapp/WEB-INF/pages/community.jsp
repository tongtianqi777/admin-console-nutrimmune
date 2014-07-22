<%--
  Created by IntelliJ IDEA.
  User: edwin
  Date: 7/21/14
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Community</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h1>All Communities</h1>
            <%@ include file="/WEB-INF/templates/community_data.jsp" %>
        </div>
    </div>
</div>

</body>
</html>

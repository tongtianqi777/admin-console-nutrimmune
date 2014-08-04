<%--
  Created by IntelliJ IDEA.
  User: edwin
  Date: 8/4/14
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Device</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6 well well-large">
            <h1>Edit Device (ID: ${device.id})</h1>
            <form method="POST" action="/devices/update">
                <fieldset>
                    <legend>Basic</legend>

                    <input type="hidden" name="id" value="${device.id}">

                    <label>Mac Address</label>
                    <input type="text" name="mac" value="${device.mac}">

                    <label>OS Build Rev</label>
                    <input type="text" name="osbuildrev" value="${device.osbuildrev}">

                    <label>Owner ID</label>
                    <input type="text" name="ownerId" value="${device.ownerId}">

                    <label>Status</label>
                    <input type="text" name="status" value="${device.status}">

                    <div class="alert">
                        <strong>Warning!</strong> After clicking the update button, the information of this protocol will be overwritten immediately.
                    </div>

                    <button class="btn btn-primary btn-large" type="submit">Update Changes</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: edwin
  Date: 8/4/14
  Time: 7:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Device</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6 well well-large">
            <h1>Add Device</h1>
            <form method="POST" action="/devices/add/submit">
                <fieldset>
                    <legend>Basic</legend>

                    <input type="hidden" name="id" value="0 ">

                    <label>Mac Address</label>
                    <input type="text" name="mac" value="">

                    <label>Manufacture Date</label>
                    <input type="text" name="manufactureDate" value="">

                    <label>OS Build Rev</label>
                    <input type="text" name="osbuildrev" value="">

                    <label>Owner ID</label>
                    <input type="text" name="ownerId" value="">

                    <label>Ship Date</label>
                    <input type="text" name="shipdate" value="">

                    <label>Status (Can either be "ACTIVATED" or "NOT_ACTIVATED")</label>
                    <input type="text" name="status" value="">

                    <button class="btn btn-primary btn-large" type="submit">Add Device</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>

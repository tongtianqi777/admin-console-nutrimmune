<%--
  Created by IntelliJ IDEA.
  User: edwin
  Date: 8/4/14
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Protocol</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6 well well-large">
            <h1>Edit Protocol (ID: ${protocol.id})</h1>
            <form method="POST" action="/protocol/update">
                <fieldset>
                    <legend>Basic</legend>

                    <input type="hidden" name="id" value="${protocol.id}">

                    <label>Name</label>
                    <input type="text" name="name" value="${protocol.name}">

                    <label>Description</label>
                    <input type="text" name="description" value="${protocol.description}">

                    <label>Author</label>
                    <input type="text" name="author" value="${protocol.author}">

                    <label>Author Name</label>
                    <input type="text" name="authorName" value="${protocol.authorName}">

                    <label>Author ID</label>
                    <input type="text" name="clientID" value="${protocol.clientID}">

                    <label>Status</label>
                    <input type="text" name="status" value="${protocol.status}">

                    <label>Location</label>
                    <input type="text" name="location" value="${protocol.location}">

                    <label>Type</label>
                    <input type="text" name="type" value="${protocol.type}">

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

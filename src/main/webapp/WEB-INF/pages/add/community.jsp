<%--
  Created by IntelliJ IDEA.
  User: edwin
  Date: 8/4/14
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Community</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6 well well-large">
            <h1>Add New Community</h1>
            <form method="POST" action="/community/add/submit">
                <fieldset>
                    <legend>Basic</legend>

                    <input type="hidden" name="id" value="0">

                    <label>Name</label>
                    <input type="text" name="name" value="">

                    <label>Description</label>
                    <input type="text" name="description" value="">

                    <button class="btn btn-primary btn-large" type="submit">Add Community</button>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>

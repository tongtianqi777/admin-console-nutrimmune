<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Edit Community (ID: ${community.id})</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>

</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6.center text-center">
            <div class="border-form-div">
                <h1>Edit Community (ID: ${community.id})</h1>

                <form class="form-horizontal" method="POST" action="/community/update">
                    <fieldset>
                        <legend>Basic</legend>


                        <input type="hidden" name="id" value="${community.id}">

                        <div class="control-group">

                            <label>Name</label>
                            <input type="text" name="name" value="${community.name}">
                        </div>

                        <div class="control-group">

                            <label>Description</label>
                            <input type="text" name="description" value="${community.description}">
                        </div>

                        <div class="alert">
                            <strong>Warning!</strong> After clicking the update button, the information of this
                            community will be overwritten immediately.
                        </div>

                        <div class="control-group">

                            <button class="btn btn-primary btn-large" type="submit">Update Changes</button>
                        </div>
                    </fieldset>
                </form>

                <a href="/community">Back to Communities</a>

            </div>
        </div>
    </div>
</div>
</body>
</html>

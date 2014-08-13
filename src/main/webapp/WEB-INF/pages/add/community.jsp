<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Add New Community</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
    <link href="${pageContext.request.contextPath}/resources/css/item-detail.css" rel="stylesheet" >

</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6.center text-center">
            <div class="border-form-div">

                <h1>Add New Community</h1>

                <form class="form-horizontal" method="POST" action="/community/add/submit">
                    <fieldset>
                        <legend>Basic</legend>

                        <input type="hidden" name="id" value="0">

                        <div class="control-group">

                            <label>Name</label>
                            <input type="text" name="name" value="">
                        </div>
                        <div class="control-group">

                            <label>Description</label>
                            <input type="text" name="description" value="">
                        </div>
                        <div class="control-group">

                            <button class="btn btn-primary btn-large" type="submit">Add Community</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

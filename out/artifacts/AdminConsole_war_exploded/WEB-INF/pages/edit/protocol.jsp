<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Edit Protocol (ID: ${protocol.id})</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/protocols.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6.center text-center">
            <div class="border-form-div">

                <h3>Edit Protocol (ID: ${protocol.id})</h3>

                <form class="form-horizontal" method="POST" action="/protocols/update">

                    <div class="control-group">
                        <input type="hidden" name="id" value="${protocol.id}">

                        <label>Name</label>
                        <textarea cols="300" rows="3" type="text" name="name">"${protocol.name}</textarea>
                    </div>

                    <div class="control-group">
                        <label>Description</label>
                        <textarea cols="300" rows="3" type="text" name="description">${protocol.description}</textarea>
                    </div>

                    <div class="control-group">
                        <label>Steps</label>
                        <textarea rows="10" cols="300" type="JSON" name="steps">${protocol.getJsonSteps()}</textarea>
                    </div>

                    <div class="control-group">
                        <label>Author</label>
                        <input type="text" name="author" value="${protocol.author}">
                    </div>

                    <div class="control-group">
                        <label>Author Name</label>
                        <input type="text" name="authorName" value="${protocol.authorName}">
                    </div>

                    <div class="control-group">
                        <label>Author ID</label>
                        <input type="text" name="clientID" value="${protocol.clientID}">
                    </div>

                    <div class="control-group">
                        <label>Status</label>
                        <input type="text" name="status" value="${protocol.status}">
                    </div>

                    <div class="control-group">
                        <label>Location</label>
                        <input type="text" name="location" value="${protocol.location}">
                    </div>

                    <div class="control-group">
                        <label>Type</label>
                        <input type="text" name="type" value="${protocol.type}">
                    </div>

                    <div class="control-group">
                        <div class="span3.center">
                            <div class="alert">
                                <strong>Warning!</strong> After clicking the update button, the information of this
                                protocol will be overwritten immediately.
                            </div>
                        </div>
                    </div>

                    <div class="control-group">
                        <button class="btn btn-primary btn-large" type="submit">Update Changes</button>
                    </div>

                </form>

                <a href="/protocols">Back to Protocols</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
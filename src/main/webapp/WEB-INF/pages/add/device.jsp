<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Add Device</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6.center text-center">
            <div class="border-form-div">
                <h1>Add Device</h1>

                <form class="form-horizontal" method="POST" action="/devices/add/submit">
                    <fieldset>
                        <legend>Basic</legend>

                        <input type="hidden" name="id" value="0 ">

                        <div class="control-group">

                            <label>Mac Address (Format: 12:34:56:78:90:xy)</label>
                            <input type="text" name="mac" value="">
                        </div>
                        <div class="control-group">

                            <label>Manufacture Date (yyyy-mm-dd)</label>
                            <input type="text" name="manufactureDate" value="">
                        </div>
                        <div class="control-group">

                            <label>OS Build Rev (Integer Number)</label>
                            <input type="text" name="osbuildrev" value="">
                        </div>

                        <div class="control-group">

                            <label>Ship Date (yyyy-mm-dd)</label>
                            <input type="text" name="shipdate" value="">
                        </div>
                        <div class="control-group">

                            <label>Status (Can either be "ACTIVATED" or "NOT_ACTIVATED")</label>
                            <input type="text" name="status" value="">
                        </div>
                        <div class="control-group">

                            <button class="btn btn-primary btn-success btn-large" type="submit">Add Device</button>

                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

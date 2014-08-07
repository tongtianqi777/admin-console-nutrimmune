<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>View Device (ID: ${device.id})</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>

</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6.center text-center">
            <div class="border-form-div">
                <h1>View Device (ID: ${device.id})</h1>

                    <fieldset>
                        <legend>Basic</legend>

                        <input type="hidden" name="id" value="${device.id}">

                        <label>Mac Address</label>
                        <input type="text" name="mac" value="${device.mac}">

                        <label>Manufacture Date</label>
                        <input type="text" name="manufactureDate" value="${device.manufactureDate}">

                        <label>OS Build Rev</label>
                        <input type="text" name="osbuildrev" value="${device.osbuildrev}">

                        <label>Owner ID</label>
                        <input type="text" name="ownerId" value="${device.ownerId}">

                        <label>Ship Date</label>
                        <input type="text" name="shipdate" value="${device.shipdate}">

                        <label>Status (Can either be "ACTIVATED" or "NOT_ACTIVATED")</label>
                        <input type="text" name="status" value="${device.status}">

                        <div class="alert">
                            <strong>Warning!</strong> After clicking the update button, the information of this protocol
                            will be overwritten immediately.
                        </div>

                    </fieldset>

                <a href="/devices">Back to Devices</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

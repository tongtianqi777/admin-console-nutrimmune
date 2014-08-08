<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Edit Device (ID: ${device.id})</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/devices.js"></script>

</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span6.center text-center">
            <div class="border-form-div">
                <h1>Edit Device (ID: ${device.id})</h1>

                <form class="form-horizontal" method="POST" action="/devices/update">
                    <legend>Basic</legend>

                    <div class="control-group">

                        <input type="hidden" name="id" value="${device.id}">
                    </div>
                    <div class="control-group">

                        <label>Mac Address</label>
                        <input type="text" name="mac" value="${device.mac}">
                    </div>
                    <div class="control-group">

                        <label>Manufacture Date</label>
                        <input type="text" name="manufactureDate" value="${device.manufactureDate}">
                    </div>
                    <div class="control-group">

                        <label>OS Build Rev</label>
                        <input type="text" name="osbuildrev" value="${device.osbuildrev}">
                    </div>
                    <div class="control-group">

                        <label>Owner ID</label>
                        <input type="text" name="ownerId" value="${device.ownerId}">
                    </div>
                    <div class="control-group">

                        <label>Ship Date</label>
                        <input type="text" name="shipdate" value="${device.shipdate}">
                    </div>
                    <div class="control-group">

                        <label>Status (Can either be "ACTIVATED" or "NOT_ACTIVATED")</label>
                        <input type="text" name="status" value="${device.status}">
                    </div>
                    <div class="control-group">
                        <label>Community</label>

                        <select class="community_changer" data-id="${device.id}" data-style="btn-info">
                            <c:forEach var="community" items="${communities}">
                                <c:choose>
                                    <c:when test="${device.communityId == community.id}">
                                        <option value="${community.id}" selected>${community.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${community.id}">${community.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="alert">
                        <strong>Warning!</strong> After clicking the update button, the information of this protocol
                        will be overwritten immediately.
                    </div>
                    <div class="control-group">

                        <button class="btn btn-primary btn-large" type="submit">Update Changes</button>
                    </div>

                </form>

                <a href="/devices">Back to Devices</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>

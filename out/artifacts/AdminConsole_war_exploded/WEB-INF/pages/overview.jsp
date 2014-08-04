<%--
  Created by IntelliJ IDEA.
  User: Rix
  Date: 7/12/14
  Time: 2:11 PM
--%>
<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>Overview</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>

    <link href="${pageContext.request.contextPath}/resources/css/ionicons.css" rel="stylesheet" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/amcharts.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/serial.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/overview.js"></script>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <!-- Main content -->
            <section class="content">

                <!-- Small boxes (Stat box) -->
                <div class="row">
                    <div class="span3">
                        <!-- small box -->
                        <div class="small-box bg-aqua">
                            <div class="inner">
                                <h3>
                                    ${protocols.size()}
                                </h3>
                                <p>
                                    Protocols
                                </p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-document-text"></i>
                            </div>
                            <a href="/protocols" class="small-box-footer">
                                More info <i class="fa fa-arrow-circle-right"></i>
                            </a>
                        </div>
                    </div><!-- ./col -->

                    <div class="span3">
                        <!-- small box -->
                        <div class="small-box bg-yellow">
                            <div class="inner">
                                <h3>
                                    ${users.size()}
                                </h3>
                                <p>
                                    Researchers
                                </p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person"></i>
                            </div>
                            <a href="/researcher" class="small-box-footer">
                                More info <i class="fa fa-arrow-circle-right"></i>
                            </a>
                        </div>
                    </div><!-- ./col -->

                    <div class="span3">
                        <!-- small box -->
                        <div class="small-box bg-green">
                            <div class="inner">
                                <h3>
                                    ${devices.size()}
                                </h3>
                                <p>
                                    Devices
                                </p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-calculator"></i>
                            </div>
                            <a href="/devices" class="small-box-footer">
                                More info <i class="fa fa-arrow-circle-right"></i>
                            </a>
                        </div>
                    </div><!-- ./col -->

                    <div class="span3">
                        <!-- small box -->
                        <div class="small-box bg-red">
                            <div class="inner">
                                <h3>
                                    ${communities.size()}
                                </h3>
                                <p>
                                    Communities
                                </p>
                            </div>
                            <div class="icon">
                                <i class="ion ion-person-stalker"></i>
                            </div>
                            <a href="/community" class="small-box-footer">
                                More info <i class="fa fa-arrow-circle-right"></i>
                            </a>
                        </div>
                    </div><!-- ./col -->
                </div><!-- /.row -->
            </section>

            <div id="chartdiv" style="width:100%; height:400px;"></div>
            <div id="statistics" style="display: none;">${statistics}</div>
        </div>
    </div>
</div>
</body>
</html>

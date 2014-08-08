<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>System</title>
    <%@ include file="/WEB-INF/templates/resources.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="row-fluid">

        <div class="span6.center text-center">
            <div class="border-form-div2">
                <div class="page-header">
                    <h2>Server Status

                    </h2>
                </div>
                <table class="table table-bordered">
                    <tr>
                        <th>CPU Load</th>
                        <th>Disk Space</th>
                        <th>Disk Space</th>
                        <th>Swap Space</th>
                    </tr>
                    <tr>
                        <td>17%</td>
                        <td>32.54%</td>
                        <td>90.92%</td>
                        <td>90%</td>
                    </tr>
                </table>
                <div class="page-header">
                    <h2>Data Import & Export

                    </h2>
                </div>
                <div class="well well-small caution">Caution: The import operation will supplement the existing data and
                    overwrite those entities with same id
                </div>
                <div class="well">
                    <h3>Users</h3>
                    <a class="btn btn-large btn-primary" href="${user_csv_path}">Export to file</a>
                    <a class="btn btn-large btn-primary" href="/system/import?cate=user" target="_blank">Import from
                        file..</a>
                    <br>
                    <a href="${user_sample_path}">Import File Example</a>
                </div>
                <div class="well">
                    <h3>Devices</h3>
                    <a class="btn btn-large btn-primary" href="${device_csv_path}">Export to file</a>
                    <a class="btn btn-large btn-primary" href="/system/import?cate=device" target="_blank">Import from
                        file..</a>
                    <br>
                    <a href="${device_sample_path}">Import File Example</a>
                </div>
                <div class="well">
                    <h3>Protocols</h3>
                    <a class="btn btn-large btn-primary" href="${protocol_csv_path}">Export to file</a>
                    <a class="btn btn-large btn-primary" href="/system/import?cate=protocol" target="_blank">Import from
                        file..</a>
                    <br>
                    <a href="${protocol_sample_path}">Import File Example</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
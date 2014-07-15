<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>System</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap_and_overrides.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/system/css/system.css" rel="stylesheet" >

</head>
<body>
<%@ include file="/WEB-INF/layouts/header.jsp" %>

<div class="container-fluid">
    <div class="span12">
        <div class="page-header">
            <h2>Server Status <small>Status of the environment of deployment</small></h2>
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
            <h2>Data Import & Export <small>Import and export all the data on the system</small></h2>
        </div>
        <div class="well well-small caution">Caution: The import operation will supplement the existing data and overwrite those entities with same id</div>
        <div class="well">
            <h3>Users</h3>
            <a class="btn btn-large btn-primary" href="${user_csv_path}">Export to file</a>
            <a class="btn btn-large btn-primary" href="/system/import?cate=user" target="_blank">Import from file..</a>
        </div>
        <div class="well">
            <h3>Devices</h3>
            <a class="btn btn-large btn-primary" href="${device_csv_path}">Export to file</a>
            <a class="btn btn-large btn-primary" href="/system/import?cate=device" target="_blank">Import from file..</a>
        </div>
        <div class="well">
            <h3>Protocols</h3>
            <a class="btn btn-large btn-primary" href="${protocol_csv_path}">Export to file</a>
            <a class="btn btn-large btn-primary" href="/system/import?cate=protocol" target="_blank">Import from file..</a>
        </div>
    </div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html">
    <title>${title} Data Import</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap_and_overrides.css" rel="stylesheet" >
    <link href="${pageContext.request.contextPath}/resources/csvimport/css/main.css" rel="stylesheet" >

</head>
<body>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h1>Nutrimmune <small>${title} Data Import with CSV File</small></h1>
                <div class="hero-unit">
                    <form method="POST" enctype="multipart/form-data" action="${upload_url}">
                        <h2>CSV File Upload</h2>
                        <div class="alert">
                            <strong>Warning!</strong> After the data is imported, all the ${title} with the same id will be overwritten by the values specified in the uploaded file. All the ${title} that do not exist on the system yet will be created using the id specified in the CSV file.
                        </div>
                        <div class="control-group">
                            <input type="file" name="file">
                        </div>
                        <div class="control-group">
                            <input type="submit" class="btn btn-large btn-primary" value="Upload the File and Update ${title}">
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>

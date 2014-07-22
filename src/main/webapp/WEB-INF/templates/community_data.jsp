<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table id="devices" class="tablesorter">
    <thead>
    <tr>
        <th>ID</th>
        <th>Community Name</th>
        <th>Description</th>
        <th>Number of Devices</th>
        <th>Number of Users</th>
        <th>Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="community" items="${communities}">
        <tr>
            <td>${community.id}</td>
            <td>${community.name}</td>
            <td>${community.description}</td>
            <td>${community.numOfDevices}</td>
            <td>${community.numOfUsers}</td>
            <td><button value="Delete"></button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
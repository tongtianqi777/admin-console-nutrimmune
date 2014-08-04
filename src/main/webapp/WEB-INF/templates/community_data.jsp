<table id="communities" class="tablesorter tablesorter-blue">
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
        <tr class="data" data-id="${community.id}">
            <td><a href="/community/edit/${community.id}" target="_blank">${community.id}</a></td>
            <td>${community.name}</td>
            <td>${community.description}</td>
            <td>3</td>
            <td>10</td>
            <td><button value="Delete" class="delete-button" data-id="${community.id}">Delete</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/templates/pager.jsp" %>

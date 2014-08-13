<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="communities" class="tablesorter tablesorter-blue">
    <thead>
    <tr>
        <th data-placeholder="Try >=33">ID</th>
        <th data-placeholder="Try *">Community Name</th>
        <th data-placeholder="Try *">Description</th>
        <th data-placeholder="" class="filter-false">Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="community" items="${communities}">
        <tr class="data" data-id="${community.id}">
            <td><a href="/community/edit/${community.id}" target="_blank">${community.id}</a></td>
            <td>${community.name}</td>
            <td>${community.description}</td>
            <td>
                <a href="/community/edit/${community.id}" class="btn btn-warning btn-small">Edit</a>
                <button value="Delete" class="delete-button btn btn-danger btn-small" data-id="${community.id}">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
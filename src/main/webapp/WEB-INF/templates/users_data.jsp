<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="users" class="tablesorter">
    <thead>
    <tr>
        <th data-placeholder="Try *" class="filter-match">User</th>
        <th data-placeholder="Try *">Address</th>
        <th data-placeholder="Try *">Country</th>
        <th data-placeholder="Try *">Phone</th>
        <th data-placeholder="Try *">Community</th>
        <th data-placeholder="Try *">Status</th>

        <th data-placeholder="" class="filter-false">Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr class="data" data-id="${user.id}">
            <td><a href="/researcher/view/${user.id}">${user.firstname} ${user.lastname}</a></td>
            <td>${user.address}</td>
            <td>${user.country}</td>
            <td>${user.phone}</td>
            <td>${user.affiliation}</td>
            <td>${user.status}</td>

            <td>
                <a href="/researcher/edit/${user.id}" class="btn btn-warning btn-small"> Edit</a>
                <button value="Delete" class="delete-button btn btn-danger btn-small" data-id="${user.id}">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
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
                <a href="/community/view/${community.id}" class="btn btn-success btn-small"><i
                        class="icon-ok icon-white"></i> View</a><br><br>
                <a href="/community/edit/${community.id}" class="btn btn-warning btn-small"><i
                        class="icon-edit icon-white"></i> Edit</a><br><br>
                <button value="Delete" class="delete-button btn btn-danger btn-small" data-id="${community.id}">
                    <i class="icon-remove icon-white"></i> Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
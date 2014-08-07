<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="protocols" class="tablesorter">
    <thead>
    <tr>
        <th data-placeholder="Try >=28">Protocol ID</th>
        <th data-placeholder="Try *">Protocol</th>
        <th data-placeholder="Try *">Author</th>
        <%--<th data-placeholder="Try *">Community</th>--%>
        <th data-placeholder="Try >=28">Times Played</th>
        <%--<th data-placeholder="Try <=28">Downloaded</th>--%>
        <%--<th data-placeholder="Try =28">Reviews</th>--%>
        <th data-placeholder="Try *">Status</th>
        <th data-placeholder="" class="filter-false">Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="protocol" items="${protocols}">
        <tr class="data" data-id="${protocol.id}">
            <td>${protocol.id}</td>
            <td><a href="/protocols/view/${protocol.id}">${protocol.name}</a></td>
            <td>${protocol.author}</td>
            <td>${protocol.timePlayed}</td>
            <td>${protocol.status}</td>
            <td>
                <a href="/protocols/view/${protocol.id}" class="btn btn-success btn-small"><i
                        class="icon-ok icon-white"></i> View</a><br><br>
                <a href="/protocols/edit/${protocol.id}" class="btn btn-warning btn-small"><i
                        class="icon-edit icon-white"></i> Edit</a><br><br>
                <button value="Delete" class="delete-button btn btn-danger btn-small" data-id="${protocol.id}">
                    <i class="icon-remove icon-white"></i> Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
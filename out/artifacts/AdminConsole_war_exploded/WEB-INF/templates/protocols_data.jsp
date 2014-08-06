<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="protocols" class="tablesorter">
    <thead>
        <tr>
            <th data-placeholder="Try *">Protocol</th>
            <th data-placeholder="Try *">Author</th>
            <th data-placeholder="Try *">Version</th>
            <%--<th data-placeholder="Try *">Community</th>--%>
            <th data-placeholder="Try >=28">Played</th>
            <%--<th data-placeholder="Try <=28">Downloaded</th>--%>
            <%--<th data-placeholder="Try =28">Reviews</th>--%>
            <th data-placeholder="Try *">Status</th>
            <th data-placeholder="" class="filter-false">Operations</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="protocol" items="${protocols}">
            <tr>
                <td>${protocol.name}</td>
                <td>${protocol.author}</td>
                <td>1.0</td>
                <td>${protocol.timePlayed}</td>
                <td>${protocol.status}</td>
                <td class="text-center">
                    <a href="/protocols/view/${protocol.id}" class="btn btn-success btn-small"><i class="icon-ok icon-white"></i> View</a>
                    <a href="/protocols/edit/${protocol.id}" class="btn btn-warning btn-small"><i class="icon-edit icon-white"></i> Edit</a>
                    <a href="#" class="btn btn-danger btn-small"><i class="icon-remove icon-white"></i> Remove</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
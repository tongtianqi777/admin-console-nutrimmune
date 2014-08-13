<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="protocols" class="tablesorter">
    <thead>
    <tr>
        <th data-placeholder="Try >=28">Protocol ID</th>
        <th data-placeholder="Try *">Protocol</th>
        <th data-placeholder="Try *" class="author-name">Author Name</th>
        <th data-placeholder="Try *">Email</th>
        <%--<th data-placeholder="Try *">Community</th>--%>
        <th data-placeholder="Try >=28">Times Played</th>
        <%--<th data-placeholder="Try <=28">Downloaded</th>--%>
        <%--<th data-placeholder="Try =28">Reviews</th>--%>
        <th data-placeholder="Try *">Status</th>
        <th data-placeholder="" class="filter-false operations">Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="protocol" items="${protocols}">
        <tr class="data" data-id="${protocol.id}">
            <td>${protocol.id}</td>
            <td><a href="/protocols/view/${protocol.id}">${protocol.name}</a></td>
            <td>${protocol.authorName}</td>
            <td>${protocol.author}</td>
            <td>${protocol.timePlayed}</td>
            <td class="status.${protocol.id}">
                ${protocol.status}

                <c:if test="${protocol.status eq unpublished}">
                    <br>
                    <br>

                    <button value="Approve" class="approve-button btn btn-success btn-small" data-id="${protocol.id}">
                        <i class="icon-ok-sign icon-white"></i> Approve
                    </button>

                    <button value="Delete" class="deny-button btn btn-danger btn-small" data-id="${protocol.id}">
                        <i class="icon-remove-sign icon-white"></i> Deny
                    </button>
                </c:if>
            </td>
            <td>
                <a href="/protocols/edit/${protocol.id}" class="btn btn-warning btn-small">Edit</a>
                <button value="Delete" class="delete-button btn btn-danger btn-small" data-id="${protocol.id}">Delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
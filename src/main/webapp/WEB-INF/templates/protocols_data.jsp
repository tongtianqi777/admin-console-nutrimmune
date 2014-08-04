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
                <td><a href="/protocols/edit/${protocol.id}">${protocol.name}</a></td>
                <td>${protocol.author}</td>
                <td>1.0</td>
                <td>${protocol.timePlayed}</td>
                <td>${protocol.status}</td>
                <td>${protocol.description}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/templates/pager.jsp" %>
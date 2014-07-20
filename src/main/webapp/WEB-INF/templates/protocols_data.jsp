<table id="protocols" class="tablesorter">
    <thead>
        <tr>
            <th data-placeholder="Try *">Protocol</th>
            <th data-placeholder="Try *">Author</th>
            <th data-placeholder="Try *">Version</th>
            <th data-placeholder="Try *">Community</th>
            <th data-placeholder="Try >=28">Played</th>
            <th data-placeholder="Try <=28">Downloaded</th>
            <th data-placeholder="Try =28">Reviews</th>
            <th data-placeholder="Try *">Status</th>
            <th data-placeholder="" class="filter-false">Operations</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="protocol" items="${protocols}">
            <tr>
                <td>${protocol.name}</td>
                <td>${protocol.author.firstname}</td>
                <td>${test}</td>
                <td>0</td>
                <td>${protocol.timePlayed}</td>
                <td>0</td>
                <td>0</td>
                <td>${protocol.status}</td>
                <td>TBD</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<table class="table table-striped">
    <tr>
        <td>Protocol</td>
        <td>Author</td>
        <td>Version</td>
        <td>Community</td>
        <td>Played</td>
        <td>Downloaded</td>
        <td>Reviews</td>
        <td>Status</td>
        <td>Operations</td>

    </tr>
    <c:forEach var="protocol" items="${protocols}">
        <tr>
            <td>${protocol.name}</td>
            <td>${protocol.authorName}</td>
            <td>0</td>
            <td>0</td>
            <td>${protocol.timePlayed}</td>
            <td>0</td>
            <td>0</td>
            <td>${protocol.status}</td>
            <td>TBD</td>
        </tr>
    </c:forEach>
</table>
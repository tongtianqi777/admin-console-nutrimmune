<table class="table table-striped">
    <tr>
        <td>User</td>
        <td>Played</td>
        <td>Created</td>
        <td>Published</td>
        <td>Reviews</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstname} ${user.lastname}</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
    </c:forEach>
</table>
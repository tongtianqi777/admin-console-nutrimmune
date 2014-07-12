<table id="users" class="tablesorter">
    <thead>
    <tr>
        <th>User</th>
        <th>Played</th>
        <th>Created</th>
        <th>Published</th>
        <th>Reviews</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
      <tr>
          <td>${user.firstname} ${user.lastname}</td>
          <td>0</td>
          <td>0</td>
          <td>0</td>
          <td>0</td>
      </tr>
    </c:forEach>
    </tbody>
</table>
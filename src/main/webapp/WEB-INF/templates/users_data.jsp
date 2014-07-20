<table id="users" class="tablesorter">
    <thead>
    <tr>
        <th data-placeholder="Try *" class="filter-match">User</th>
        <th data-placeholder="Try >=33">Played</th>
        <th data-placeholder="Try 1/1/2014">Created</th>
        <th data-placeholder="Try 1/1/2014">Published</th>
        <th data-placeholder="Try >=28">Reviews</th>
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
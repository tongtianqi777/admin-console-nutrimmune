<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="devices" class="tablesorter">
    <thead>
    <tr>
        <th data-placeholder="Try >=33">ID</th>
        <th data-placeholder="Try *">Mac Address</th>
        <th data-placeholder="Try 1/1/2014">Manufacture Date</th>
        <th data-placeholder="Try 1/1/2014">Shipping Date</th>
        <th data-placeholder="Try *">Status</th>
        <th data-placeholder="" class="filter-false">Community</th>
        <th data-placeholder="" class="filter-false">Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="device" items="${devices}">
        <tr class="data" data-id="${device.id}">
            <td>${device.id}</td>
            <td><a href="/devices/edit/${device.id}">${device.mac}</a></td>
            <td>${device.manufactureDate}</td>
            <td>${device.shipdate}</td>
            <td>${device.status}</td>
            <td>
                <select>
                    <c:forEach var="community" items="${communities}">
                        <c:choose>
                            <c:when test="${device.communityId == community.id}">
                                {community.name}
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
            <td>
                <a href="/devices/view/${device.id}" class="btn btn-success btn-small"><i
                        class="icon-ok icon-white"></i> View</a><br><br>
                <a href="/devices/edit/${device.id}" class="btn btn-warning btn-small"><i
                        class="icon-edit icon-white"></i> Edit</a><br><br>
                <button value="Delete" class="delete-button btn btn-danger btn-small" data-id="${device.id}">
                    <i class="icon-remove icon-white"></i> Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
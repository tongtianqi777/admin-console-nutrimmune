<table id="devices" class="tablesorter">
    <thead>
        <tr>
            <th data-placeholder="Try >=33">ID</th>
            <th data-placeholder="Try *">Mac Address</th>
            <th data-placeholder="Try *">Owner</th>
            <th data-placeholder="Try 1/1/2014">Manufacture Date</th>
            <th data-placeholder="Try 1/1/2014">Shipping Date</th>
            <th data-placeholder="Try *">Status</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="device" items="${devices}">
            <tr>
                <td><a href="/devices/edit/${device.id}">${device.id}</a></td>
                <td>${device.mac}</td>
                <td>${device.manufactureDate}</td>
                <td>${device.osbuildrev}</td>
                <td>${device.shipdate}</td>
                <td>${device.status}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@ include file="/WEB-INF/templates/pager.jsp" %>

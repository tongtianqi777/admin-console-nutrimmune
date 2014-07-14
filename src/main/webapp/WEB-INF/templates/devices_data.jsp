<table id="devices_table" class="tablesorter">
    <thead>
        <tr>
            <th>ID</th>
            <th>Mac Address</th>
            <th>Owner</th>
            <th>Manufacture Date</th>
            <th>Shipping Date</th>
            <th>Status</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="device" items="${devices}">
            <tr>
                <td>${device.id}</td>
                <td>${device.mac}</td>
                <td>${device.ownerName}</td>
                <td>${device.manuDate}</td>
                <td>${device.shipDate}</td>
                <td>${device.status}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
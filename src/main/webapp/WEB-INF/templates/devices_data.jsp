<table class="table table-striped">
    <tr>
        <td>ID</td>
        <td>Mac Address</td>
        <td>Owner</td>
        <td>Manufacture Date</td>
        <td>Shipping Date</td>
        <td>Status</td>
    </tr>
    <c:forEach var="device" items="${devices}">
        <tr>
            <td>${device.id}</td>
            <td>${device.mac}</td>
            <td>${device.owner}</td>
            <td>${device.manufactureddate}</td>
            <td>${device.shipdate}</td>
            <td>${device.status}</td>
        </tr>
    </c:forEach>
</table>
<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="devices" class="tablesorter">
    <thead>
    <tr>
        <th data-placeholder="Try >=33">ID</th>
        <th data-placeholder="Try *">Mac Address</th>
        <th data-placeholder="Try *">Owner</th>
        <th data-placeholder="Try 1/1/2014">Manufacture Date</th>
        <th data-placeholder="Try 1/1/2014">Shipping Date</th>
        <th data-placeholder="Try *">Status</th>
        <th data-placeholder="" class="filter-false">Community</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="device" items="${devices}">
        <tr>
            <td><a href="/devices/edit/${device.id}" target="_blank">${device.id}</a></td>
            <td>${device.mac}</td>
            <td>${device.manufactureDate}</td>
            <td>${device.osbuildrev}</td>
            <td>${device.shipdate}</td>
            <td>${device.status}</td>
            <td>
                <select>
                    <c:forEach var="community" items="${communities}">
                        <c:choose>
                            <c:when test="${device.communityId == community.id}">
                                <option value="${community.id}" selected>${community.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${community.id}">${community.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
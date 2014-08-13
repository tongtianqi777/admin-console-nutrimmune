<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="devices" class="tablesorter">
    <thead>
    <tr>
        <th data-placeholder="" class="filter-false">ID</th>
        <th data-placeholder="Try *">Mac Address</th>
        <th data-placeholder="Try 2014-1-1">Manufacture Date</th>
        <th data-placeholder="Try 2014-1-1">Shipping Date</th>
        <th data-placeholder="Try *" class="status">Status</th>
        <th data-placeholder="" class="filter-false community">View / Change Community</th>
        <th data-placeholder="" class="filter-false operations">Operations</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="device" items="${devices}">
        <tr class="data" data-id="${device.id}">
            <td>${device.id}</td>
            <td><a href="/devices/view/${device.id}">${device.mac}</a></td>
            <td>${device.manufactureDate}</td>
            <td>${device.shipdate}</td>
            <td>${device.status}

                <c:if test="${device.status eq 'NOT_ACTIVATED'}">
                    <button value="Activate" class="activate-button btn btn-success btn-small" data-id="${device.id}">
                        <i class="icon-ok-sign icon-white"></i> Activate
                    </button>
                </c:if>

                <c:if test="${device.status eq 'ACTIVATED'}">
                    <button value="Deactivate" class="deactivate-button btn btn-danger btn-small"
                            data-id="${device.id}">
                        <i class="icon-remove-sign icon-white"></i> Deactivate
                    </button>

                </c:if>

            </td>
            <td>
                <select class="community_changer" data-id="${device.id}" data-style="btn-info">
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
            <td>
                <a href="/devices/edit/${device.id}" class="btn btn-warning btn-small">Edit</a>
                <button value="Delete" class="delete-button btn btn-danger btn-small" data-id="${device.id}">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
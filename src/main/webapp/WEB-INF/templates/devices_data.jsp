<%@ include file="/WEB-INF/templates/pager.jsp" %>

<table id="devices" class="tablesorter">
    <thead>
    <tr>
        <th data-placeholder="" class="filter-false">ID</th>
        <th data-placeholder="Try *">Mac Address</th>
        <th data-placeholder="Try 1/1/2014">Manufacture Date</th>
        <th data-placeholder="Try 1/1/2014">Shipping Date</th>
        <th data-placeholder="Try *">Status</th>
        <th data-placeholder="Try *">View / Change Community</th>
        <th data-placeholder="" class="filter-false">Operations</th>
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
                    <br>
                    <br>

                    <button value="Activate" class="activate-button btn btn-success btn-small" data-id="${device.id}">
                        <i class="icon-ok-sign icon-white"></i> Activate
                    </button>
                </c:if>

                <c:if test="${device.status eq 'ACTIVATED'}">
                    <br>
                    <br>

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
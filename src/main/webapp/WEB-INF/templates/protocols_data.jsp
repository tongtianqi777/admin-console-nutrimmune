<table id="protocols" class="tablesorter">
    <thead>
        <tr>
            <th data-placeholder="Try *">Protocol</th>
            <th data-placeholder="Try *">Author</th>
            <th data-placeholder="Try *">Version</th>
            <%--<th data-placeholder="Try *">Community</th>--%>
            <th data-placeholder="Try >=28">Played</th>
            <%--<th data-placeholder="Try <=28">Downloaded</th>--%>
            <%--<th data-placeholder="Try =28">Reviews</th>--%>
            <th data-placeholder="Try *">Status</th>
            <th data-placeholder="" class="filter-false">Operations</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="protocol" items="${protocols}">
            <tr>
                <td>${protocol.name}</td>
                <td>${protocol.author}</td>
                <td>1.0</td>
                <td>${protocol.timePlayed}</td>
                <td>${protocol.status}</td>
                <td>${protocol.description}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div class="pager" id="pager">
    <img src="http://mottie.github.com/tablesorter/addons/pager/icons/first.png" class="first"/>
    <img src="http://mottie.github.com/tablesorter/addons/pager/icons/prev.png" class="prev"/>
    <span class="pagedisplay"></span> <!-- this can be any element, including an input -->
    <img src="http://mottie.github.com/tablesorter/addons/pager/icons/next.png" class="next"/>
    <img src="http://mottie.github.com/tablesorter/addons/pager/icons/last.png" class="last"/>
    <select class="pagesize" title="Select page size">
        <option selected="selected" value="10">10</option>
        <option value="20">20</option>
        <option value="30">30</option>
        <option value="40">40</option>
    </select>
    <select class="gotoPage" title="Select page number"></select>
</div>
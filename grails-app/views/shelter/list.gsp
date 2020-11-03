<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="authenticated"/>
    <title>Shelters</title>
</head>
<body>
<style>
.update-entry-btn{
    display:block;
}
.shelter-data{
    margin:10px auto 20px auto;
}
table{
    width:100%;
}
table th{
    color:#90A4AE;
    padding-bottom: 20px;
}

table td{
    line-height:1.6em;
    font-size:21px !important;
    padding:5px 0px 10px 0px;
}
a{
    text-decoration: none !important;
    border-bottom:dotted 2px #428bca !important;
}
.daily-count{
    font-size:31px;
    font-family: roboto-black !important;
}
</style>

    <h1>Today's Counts</h1>

    <g:if test="${flash.message}">
        <div class="notify" role="status">${flash.message}</div>
    </g:if>

    <g:if test="${shelters}">

        <table class="table">
            <thead>
            <tr>
                <g:sortableColumn property="id" title="Id" />

                <g:sortableColumn property="name" title="Name"/>

                <th>Count</th>

                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${shelters}" status="i" var="shelter">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td>
                        <g:link action="edit" id="${shelter.id}">${shelter.id}</g:link>
                    </td>

                    <td><g:link action="edit" elementId="edit-${shelter.id}">${shelter.name}</g:link></td>

                    <td style="text-align: center">
                        <g:if test="${!shelter.entered}">
                            <g:link uri="/dailyCount/entry/${shelter.id}" class="daily-count">0</g:link>
                            <br/>
                            <g:link uri="/dailyCount/entry/${shelter.id}">Enter Today</g:link>
                        </g:if>
                        <g:else>
                            <g:link uri="/dailyCount/edit/${shelter?.dailyCount?.id}" class="daily-count">${shelter.dailyCount.total}</g:link> &check;
                        </g:else>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>

        <div class="button-group">
            <g:paginate total="${total}"/>
        </div>
    </g:if>
    <g:else>
        <br/>
        <p>No Shelters added to your account yet.</p>
    </g:else>

</body>
</html>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="authenticated"/>
    <title>Shelters</title>
</head>
<body>

<div id="list-account" class="content scaffold-list" role="main">

    <h1>Today's Counts</h1>

    <g:if test="${flash.message}">
        <div class="notify" role="status">${flash.message}</div>
    </g:if>

    <g:if test="${shelters}">

        <table class="table">
            <thead>
            <tr>
                <!-- TODO: make sortable, may require refactoring Account hasMany to include hasMany roles/authorities -->
                <g:sortableColumn property="id" title="Id" params="${[admin:admin]}"/>

                <g:sortableColumn property="name" title="Name" params="${[admin:admin]}"/>

                <g:sortableColumn property="email" title="Username" params="${[admin:admin]}"/>

                <th></th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${shelters}" status="i" var="shelter">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                    <td>
                        <g:link action="edit" id="${shelter.id}">${shelter.id}</g:link>
                    </td>

                    <td>${shelter.name}</td>

                    <td>${shelter.location}</td>

                    <td>
                        <g:link action="edit" params="[id: shelter.id]" class="edit-${shelter.id}" elementId="edit-${shelter.id}">Edit</g:link>
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
</div>
</body>
</html>

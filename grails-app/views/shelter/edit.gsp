<%@ page import="io.vanilla.Account" %>
<%@ page import="io.vanilla.State" %>
<% def applicationService = grailsApplication.classLoader.loadClass('io.vanilla.ApplicationService').newInstance()%>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="authenticated">
    <title>Update Shelter</title>
</head>

<body>
<div class="form-outer-container">

    <div class="form-container">

        <h2>Update Shelter</h2>

        <div class="messages">

            <g:if test="${flash.message}">
                <div class="alert alert-info" role="status">${raw(flash.message)}</div>
            </g:if>

        </div>



        <g:form controller="shelter" action="update" id="${shelter.id}" class="form-horizontal" role="form" method="post">

            <div class="form-row">
                <span class="form-label full">Name</span>

                <span class="input-container">
                    <g:textField type="text" name="name" required="" value="${shelter?.name}" class="form-control twofifty"/>
                </span>
                <br class="clear"/>
            </div>



            <div class="form-row">
                <span class="form-label full">Location</span>
                <span class="input-container">
                    <g:textField type="text" name="location" required="" value="${shelter?.location}" class="form-control twofifty"/>
                </span>
                <br class="clear"/>
            </div>

            <g:submitButton name="update" class="button modern" value="Update Shelter" />


        </g:form>

    </div>

</div>


</body>
</html>

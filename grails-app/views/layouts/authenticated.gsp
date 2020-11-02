<%@ page import="grails.util.Environment" %>
<% def commonUtilities = grailsApplication.classLoader.loadClass('io.vanilla.common.CommonUtilities').newInstance()%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Dynamics +Gain</title>

    <link rel="stylesheet" href="${resource(dir:'css', file:'bootstrap-grid.css')}" />
    <link rel="stylesheet" href="${resource(dir:'css', file:'application.css')}" />

    <g:layoutHead/>

</head>
<body>

<div class="container">

    <div class="row">

        <div class="col-sm-3"></div>
        <div class="col-sm-6">

            <div id="navigation">
                <p style="font-size:14px;margin:0px auto 20px auto;">Welcome back <strong>
                    <%
                        def account = commonUtilities.getAuthenticatedAccount()
                        if(account.name){%>
                    <%=account.name%>
                    <%}else{%>
                    <%=account.username%>
                    <%}%>
                </strong>
                </p>

                <sec:ifAllGranted roles='ROLE_ADMIN'>
                    <g:link uri="/account">Accounts</g:link>
                    <g:link uri="/shelter/list">Shelters</g:link>
                    <g:link uri="/shelter/add">New Shelter</g:link>
                </sec:ifAllGranted>

                <g:link uri="/shelter/list">Today</g:link>
                <g:link uri="/logout">Logout</g:link>

            </div>

            <g:layoutBody/>

        </div>
        <div class="col-sm-3"></div>
    </div>

</div>


</body>
</html>

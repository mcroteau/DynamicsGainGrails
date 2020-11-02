<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="guest">
</head>
<body>
<style>
</style>

    <h1>Donate</h1>
    <h2>Select Location: </h2>
    <g:each in="${locations}" var="location">
        <g:link uri="/resource/make?location=${location}">${location}</g:link>
        <br/>
    </g:each>

</body>
</html>
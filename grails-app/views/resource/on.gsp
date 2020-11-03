<html>
<head>
    <meta name="layout" content="guest">
</head>
<body>
    <h1>Select Shelter</h1>

    <g:each in="${shelters}" var="shelter">
        <g:link uri="/resource/on">${shelter.name}</g:link>
        <br/>
    </g:each>
</body>
</html>
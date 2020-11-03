<html>
<head>
    <meta name="layout" content="guest">
</head>
<body>
    <h1>Select Shelter</h1>

    <h2>Donation Amount : $${params.a}</h2>

    <g:each in="${shelters}" var="shelter">
        <g:link uri="/resource/onn?a=${params.a}">${shelter.name}</g:link>
        <br/>
    </g:each>
</body>
</html>
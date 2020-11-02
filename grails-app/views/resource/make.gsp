<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="guest">
</head>

<body>
<div id="uno-content">

    <h1 id="uno-total" style="font-size:120px; font-family:roboto-black !important; margin-top:70px; float:left;background:#fff">${total}</h1>
    <br class="clear"/>
    <p style="font-family: Georgia !important">People without homes in <strong>${location}</strong></p>

    <h3 style="margin-top:20px;">Donate</h3>
    <br/>
    <g:link uri="/make_donation?a=5" class="button modern">$5</g:link>
    <g:link uri="/make_donation?a=10" class="button orange">$10</g:link>
    <g:link uri="/make_donation?a=25" class="button light">$25</g:link>
    <g:link uri="/make_donation" class="button">Other</g:link>

    <br/>
    <br/>
    <g:link uri="/">Home</g:link>

</div>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="authenticated">
    <title>Edit Count</title>
</head>
<body>
<p style="text-align: center;">${dailyCount.shelter.name}</p>
<h1 style="text-align: center">Today's Count</h1>

<g:form action="update" id="count-form" method="post" id="${dailyCount.id}">

    <input type="hidden" name="id" value="${dailyCount.id}">

    <div class="form-group" style="text-align: center">
        <input type="text" name="total" id="daily-count" value="${dailyCount.total}" style="width:50%;font-size:27px;text-align: center">
    </div>

    <div class="form-group">
        <label for="notes">Notes:</label>
        <textarea name="notes" placeholder="Today we need..." style="width:100%;">${dailyCount.notes}</textarea>
    </div>

    <div id="edit-actions-container" style="width:100%;">
        <input type="submit" class="button modern" id="save-button" value="Save Todays!" style="width:100% !important;"/>
    </div>
</g:form>


</body>
</html>
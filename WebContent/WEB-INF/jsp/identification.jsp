<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Identification RH</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form:form method="post">
<fieldset>
<legend>Identification RH</legend>
    <div class="ligne">
        <span class="label">Login :</span>
        <form:input path="login" />
        <form:errors path="login" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Password :</span>
        <form:password path="pass" />
        <form:errors path="pass" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="accueil_rh.htm">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

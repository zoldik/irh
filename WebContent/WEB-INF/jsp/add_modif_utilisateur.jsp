<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Ajout ou modification d'un utilisateur</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form:form method="post">
<fieldset>
<legend>Utilisateur</legend>
    <div class="ligne">
        <span class="label">Login :</span>
        <form:input path="login" />
        <form:errors path="login" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Nom :</span>
        <form:input path="nom" />
        <form:errors path="nom" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Droit :</span>
        <form:select path="droit">
        	<form:options items="${droits}" itemLabel="libelle" itemValue="id" />
        </form:select>
    </div>
    <div class="ligne">
        <span class="label">Password :</span>
        <form:password path="pass" />
        <form:errors path="pass" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Confirmation :</span>
        <form:password path="confirmation" />
        <form:errors path="confirmation" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="liste_utilisateurs.htm">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

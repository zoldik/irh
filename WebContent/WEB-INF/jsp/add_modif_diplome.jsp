<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Ajout ou modification d'un diplome</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form:form method="post">
<fieldset>
<legend>Diplome</legend>
	<input id="employeid" name="employeid" type="hidden" value="${employeId}"/>
	<form:errors path="employe" cssClass="error"/>
    <div class="ligne">
        <span class="label">D&eacute;nomination :</span>
        <form:input path="denomination" />
        <form:errors path="denomination" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Etablissement :</span>
        <form:input path="etablissement" />
        <form:errors path="etablissement" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Ann&eacute;e :</span>
        <form:input path="annee" maxlength="4" size="3" />
        <form:errors path="annee" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Niveau d'&eacute;tude :</span>
        <form:select path="niveauEtude">
        	<form:options items="${niveauxEtude}" itemValue="id" />
        </form:select>
    </div>
    
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="./modif_employe.htm">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

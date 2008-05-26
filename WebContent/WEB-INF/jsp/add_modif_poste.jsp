<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/jsp/includes/role_carrieres.jsp" %>

<html>
<head>
    <title>Ajout ou modification d'un poste</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<form:form method="post">
<fieldset>
<legend>Poste</legend>
    <div class="ligne">
        <span class="label">Libell&eacute; :</span>
        <form:input path="libelle" maxlength="128" />
        <form:errors path="libelle" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">M&eacute;tier :</span>
        <form:select path="metier">
        	<form:options items="${metiers}" itemValue="id" />
        </form:select>
        <a href="add_metier.htm">Ajouter</a>
        <a href="liste_metiers.htm" target="_blank">Gestion des m&eacute;tiers</a>
    </div>
    <div class="ligne">
        <span class="label">Est occup&eacute; :</span>
    	<form:checkbox path="estOccupe" />
    </div>
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="liste_postes.htm">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

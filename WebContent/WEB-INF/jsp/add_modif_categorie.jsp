<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/jsp/includes/role_carrieres.jsp" %>

<html>
<head>
    <title>Ajout ou modification d'une cat&eacute;gorie</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<form:form method="post">
<fieldset>
<legend>Cat&eacute;gorie</legend>
    <div class="ligne">
        <span class="label">Libell&eacute; :</span>
        <form:input path="libelle" />
        <form:errors path="libelle" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Th&egrave;me :</span>
        <form:select path="theme">
        	<form:options items="${themes}" itemLabel="libelle" itemValue="id" />
        </form:select>
        <a href="add_theme.htm" target="_blank">Ajouter</a>
        <a href="liste_themes.htm" target="_blank">Gestion des th&egrave;mes</a>
    </div>
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="liste_categories.htm">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

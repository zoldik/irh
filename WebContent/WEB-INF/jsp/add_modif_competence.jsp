<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/jsp/includes/role_carrieres.jsp" %>

<html>
<head>
    <title>Ajout ou modification d'une comp&eacute;tence</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<form:form method="post">
<fieldset>
<legend>Comp&eacute;tence</legend>
    <div class="ligne">
        <span class="label">Libell&eacute; :</span>
        <form:input path="libelle" maxlength="128" />
        <form:errors path="libelle" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="liste_competences.htm">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

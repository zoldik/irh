<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/jsp/includes/role_administration.jsp" %>

<html>
<head>
    <title>Ajout ou modification d'un utilisateur</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<form:form method="post">
<fieldset>
<legend>Utilisateur</legend>
    <div class="ligne">
        <span class="label">Login :</span>
        <form:input path="login" maxlength="128" />
        <form:errors path="login" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Nom :</span>
        <form:input path="nom" maxlength="128" />
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
        <form:password path="pass" showPassword="true" maxlength="32" />
        <form:errors path="pass" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Confirmation :</span>
        <form:password path="confirmation" showPassword="true" maxlength="32" />
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

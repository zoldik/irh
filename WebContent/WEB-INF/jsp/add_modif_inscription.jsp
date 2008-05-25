<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Inscription employ&eacute;</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<form:form method="post">
<fieldset>
<legend>Inscription employ&eacute;</legend>
	<div class="ligne">
        <span class="label">Session :</span>
        <form:select path="sessionFormation">
        	<form:options items="${session_formations}" itemValue="id" />
        </form:select>
    </div>
    <div class="ligne">
        <span class="label">Employ&eacute; :</span>
        <form:select path="employe">
        	<form:options items="${employes}" itemValue="id" />
        </form:select>
        <form:errors path="employe" cssClass="error"/>
    </div>
    <div class="ligne">
        <span class="label">Etat :</span>
        <form:select path="etat">
        	<form:options items="${etats}" />
        </form:select>
    </div>
    <div class="ligne">
        <span class="label">Etait Pr&eacute;sent :</span>
        <form:checkbox path="presence" value="a"/>
    </div>
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="liste_inscriptions.htm?id_session_formation=${id_session_formation}&id_plan_formation=${id_plan_formation}">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

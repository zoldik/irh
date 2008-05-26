<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="/WEB-INF/jsp/includes/role_formations.jsp" %>

<html>
<head>
    <title>Ajout ou modification d'une session de formation</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
    
    <script type="text/javascript" src="./datepicker/js/datepicker.js"></script>
    <link href="./datepicker/css/datepicker.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<form:form method="post">
<fieldset>
<legend>Session de formation</legend>
    <div class="ligne">
        <span class="label">Plan de formation :</span>
        <form:select path="planFormation">
        	<form:options items="${plan_de_formations}" itemLabel="annee" itemValue="id" />
        </form:select>
    </div> 
    <div class="ligne">
        <span class="label">D&eacute;but :</span>
    	<form:input path="dateDebut" cssClass="format-d-m-y" maxlength="10" size="10" />
		<form:errors path="dateDebut" cssClass="error"/>
	</div>
	<div class="ligne">
        <span class="label">Fin :</span>
    	<form:input path="dateFin" cssClass="format-d-m-y" maxlength="10" size="10" />
		<form:errors path="dateFin" cssClass="error"/>
	</div>
	<div class="ligne">
        <span class="label">Formation :</span>
        <form:select path="formation">
        	<form:options items="${formations}" itemValue="id" />
        </form:select>
    </div>
    
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="liste_session_formations.htm?id_plan_formation=${id_plan_formation}">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

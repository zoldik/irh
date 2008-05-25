<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <title>Liste des plans de formation</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<fieldset>
	<legend>Liste des plans de formation</legend>
	<a class="ajout" href="./add_plan_formation.htm">
        Ajouter un plan de formation
    </a>
	<display:table name="plan_formations" sort="list" pagesize="10" class="adminlist" decorator="web.formations.ListePlanFormationsDecorator" requestURI="liste_plan_formations.htm">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="annee" title="Ann&eacute;e" sortable="true" />
		<display:column property="budgetTotal" title="Buget total (En &euro)" sortable="true" />
		<display:column property="volumeHoraire" title="Volume horaire (En heure)" sortable="true" />
		<display:column property="planningLink" title="Planning" style="text-align:center" />
		<display:column property="editLink" title="&nbsp;" style="text-align:center" />
		<display:column property="supprLink" title="&nbsp;" style="text-align:center" />
	</display:table>
</fieldset>

</body>
</html>
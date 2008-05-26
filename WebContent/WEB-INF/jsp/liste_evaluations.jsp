<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <title>Liste des &eacute;valuations</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<fieldset>
	<legend>Liste des &eacute;valuations</legend>
	<a class="ajout" href="./add_evaluation.htm">
        Ajouter une &eacute;valuation
    </a>
	<display:table name="evaluations" sort="list" pagesize="10" class="adminlist" decorator="web.carrieres.ListeEvaluationsDecorator" requestURI="liste_evaluations.htm">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="dateEvaluationShortFormat" title="Date" sortable="true" />
		<display:column property="employe" title="Employ&eacute;" sortable="true" />
		<display:column property="editLink" title="&nbsp;" style="text-align:center" />
		<display:column property="supprLink" title="&nbsp;" style="text-align:center" />
	</display:table>
</fieldset>

</body>
</html>
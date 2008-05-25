<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <title>Liste des inscriptions</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<fieldset>
	<legend>Liste des inscriptions</legend>
	<a class="ajout" href="./add_inscription.htm?id_session_formation=${id_session_formation}&id_plan_formation=${id_plan_formation}">
        Inscrire un employ&eacute;
    </a>
	<display:table name="inscriptions" sort="list" pagesize="10" class="adminlist" decorator="web.formations.ListeInscriptionsDecorator" requestURI="liste_inscriptions.htm">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="nomEmploye" title="Nom" sortable="true" />
		<display:column property="prenomEmploye" title="Pr&eacute;nom" sortable="true" />
		<display:column property="etat" title="Etat" sortable="true" />
		<display:column property="presence" title="Pr&eacute;sence" sortable="true" />
		<display:column property="editLink" title="&nbsp;" style="text-align:center" />
		<display:column property="supprLink" title="&nbsp;" style="text-align:center" />
	</display:table>
</fieldset>
<br />
<a href="liste_session_formations.htm?id_plan_formation=${id_plan_formation}">Retour</a>

</body>
</html>
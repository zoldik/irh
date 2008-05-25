<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <title>Liste des formations</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<fieldset>
	<legend>Liste des formations</legend>
	<a class="ajout" href="./add_sync_formations.htm">
        Ajouter/Synchroniser des formations
    </a>
	<display:table name="formations" sort="list" pagesize="10" class="adminlist" decorator="web.formations.ListeFormationsDecorator" requestURI="liste_formations.htm">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="libelle" title="Libellé" sortable="true" />
		<display:column property="organisme" title="Organisme" sortable="true" />
		<display:column property="prixParPersonne" title="Prix par pers. (En &euro;)" sortable="true" />
		<display:column property="duree" title="Durée (En H)" sortable="true" />
		<display:column property="detailsLink" title="Détails" style="text-align:center" />
	</display:table>
</fieldset>

</body>
</html>
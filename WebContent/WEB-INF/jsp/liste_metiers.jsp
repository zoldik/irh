<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ include file="/WEB-INF/jsp/includes/role_carrieres.jsp" %>

<html>
<head>
    <title>Liste des m&eacute;tiers</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<fieldset>
	<legend>Liste des m&eacute;tiers</legend>
	<a class="ajout" href="./add_metier.htm">
        Ajouter un m&eacute;tier
    </a>
	<display:table name="metiers" sort="list" pagesize="10" class="adminlist" decorator="web.formations.ListeMetiersDecorator" requestURI="liste_metiers.htm">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="libelle" title="Libellé" sortable="true" />
		<display:column property="categorie" title="Catégorie" sortable="true" />
		<display:column property="editLink" title="&nbsp;" style="text-align:center" />
		<display:column property="supprLink" title="&nbsp;" style="text-align:center" />
	</display:table>
</fieldset>

</body>
</html>
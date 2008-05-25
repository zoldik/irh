<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <title>Liste des cat&eacute;gories</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<fieldset>
	<legend>Liste des cat&eacute;gories</legend>
	<a class="ajout" href="./add_categorie.htm">
        Ajouter une cat&eacute;gorie
    </a>
	<display:table name="categories" sort="list" pagesize="10" class="adminlist" decorator="web.formations.ListeCategoriesDecorator" requestURI="liste_categories.htm">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="libelle" title="Libellé" sortable="true" />
		<display:column property="theme" title="Thème" sortable="true" />
		<display:column property="editLink" title="&nbsp;" style="text-align:center" />
		<display:column property="supprLink" title="&nbsp;" style="text-align:center" />
	</display:table>
</fieldset>

</body>
</html>
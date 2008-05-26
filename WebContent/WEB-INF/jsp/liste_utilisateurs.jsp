<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ include file="/WEB-INF/jsp/includes/role_administration.jsp" %>

<html>
<head>
    <title>Liste des utilisateurs</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<fieldset>
	<legend>Liste des utilisateurs</legend>
	<a class="ajout" href="./add_utilisateur.htm">
        Ajouter un utilisateur
    </a>
	<display:table name="users" sort="list" pagesize="10" class="adminlist" decorator="web.administration.ListeUtilisateursDecorator" requestURI="liste_utilisateurs.htm">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="login" title="Login" sortable="true" />
		<display:column property="nom" title="Nom" sortable="true" />
		<display:column property="editLink" title="&nbsp;" style="text-align:center" />
		<display:column property="supprLink" title="&nbsp;" style="text-align:center" />
	</display:table>
</fieldset>

</body>
</html>
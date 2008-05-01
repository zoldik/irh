<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <title>Liste des utilisateurs</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<fieldset>
	<legend>Liste des utilisateurs</legend>
	<a class="ajout" href="./add_utilisateur.htm">
        Ajouter un utilisateur
    </a>
	<display:table name="users" class="adminlist" decorator="web.administration.ListeUtilisateursDecorator">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="login" title="Login" />
		<display:column property="nom" title="Nom" />
		<display:column property="editLink" title="&nbsp;" style="text-align:center" />
		<display:column property="supprLink" title="&nbsp;" style="text-align:center" />
	</display:table>
</fieldset>

</body>
</html>
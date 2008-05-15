<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <title>Liste des employes</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<fieldset>
	<legend>Liste des employés</legend>
	<a class="ajout" href="./add_employe.htm">
        Ajouter un employé
    </a>
	<display:table name="employes" sort="list" pagesize="10" class="adminlist" decorator="web.administration.ListeEmployesDecorator" requestURI="liste_employes.htm">
		<display:setProperty name="css.tr.odd" value="row0" />
		<display:setProperty name="css.tr.even" value="row1" />
		<display:column property="nom" title="Nom" sortable="true" />
		<display:column property="prenom" title="Prénom" sortable="true" />
		<display:column property="editLink" title="&nbsp;" style="text-align:center" />
		<display:column property="supprLink" title="&nbsp;" style="text-align:center" />
	</display:table>
</fieldset>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<head>
    <title>D&eacute;tails de la formation</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<fieldset>
	<legend>D&eacute;tails de la formation</legend>
	<fieldset>
		<legend>Formation</legend>
		<table border="0">
			<tr>
				<td>Libell&eacute; :</td>
			 	<td><c:out value="${formation.libelle}" /></td>
			</tr>
			<tr>
				<td>Prix par personnes (En &euro;) :</td>
				<td><c:out value="${formation.prixParPersonne}" /></td>
			</tr>
			<tr>
				<td>Dur&eacute;e :</td>
				<td><c:out value="${formation.duree}" /></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Comp&eacute;tence(s)</legend>
		<table border="0">
			<c:forEach var="c" varStatus="i" items="${competences}">
				<tr>
					<td><c:out value="${c.libelle}" /> :</td>
					<td>
						<c:forEach begin="1" end="${niveaux[i.index]}" >
							<img src="./images/star.png" />
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	<fieldset>
		<legend>Organisme</legend>
		Nom : ${organisme.nom}<br /><br />
		Description :<br /><br />
		${organisme.description}
	</fieldset>
	<br />
	<a href="liste_formations.htm">Retour</a>
</fieldset>

</body>
</html>
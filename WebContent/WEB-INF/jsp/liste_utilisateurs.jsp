<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <table class="adminlist" cellspacing="1">
    <thead>
        <tr>
            <th>Login</th>
            <th>Nom</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
    </thead>
    <tbody>
    <c:set var="row" value="0"/>
    <c:forEach items="${users}" var="user">
    	<c:choose>
        	<c:when test='${row == 0}'>
	            <tr class="row0">
		             <td><c:out value="${user.login}"/></td>
		             <td><c:out value="${user.nom}"/></td>
		             <td align="center"><a href="<c:url value="modif_utilisateur.htm"><c:param name="id" value="${user.id}"/></c:url>"><img src="./images/edit.png" alt="Modifier l'utilisateur"/></a></td>
		             <td align="center"><a onclick="javascript: return confirm('Voulez-vous supprimer cet utilisateur?');" href="<c:url value="suppr_utilisateur.htm"><c:param name="id" value="${user.id}"/></c:url>"><img src="./images/delete.png" alt="Supprimer l'utilisateur"/></a></td>
	          	</tr>
	          	<c:set var="row" value="1"/>
        	</c:when>
	        <c:otherwise>
	        	<tr class="row1">
		             <td><c:out value="${user.login}"/></td>
		             <td><c:out value="${user.nom}"/></td>
		             <td align="center"><a href="<c:url value="modif_utilisateur.htm"><c:param name="id" value="${user.id}"/></c:url>"><img src="./images/edit.png" alt="Modifier l'utilisateur"/></a></td>
		             <td align="center"><a onclick="javascript: return confirm('Voulez-vous supprimer cet utilisateur?');" href="<c:url value="suppr_utilisateur.htm"><c:param name="id" value="${user.id}"/></c:url>"><img src="./images/delete.png" alt="Supprimer l'utilisateur"/></a></td>
	          	</tr>
	          	<c:set var="row" value="0"/>
	        </c:otherwise>
    	</c:choose>
    </c:forEach>
    </tbody>
    </table>
</fieldset>

</body>
</html>
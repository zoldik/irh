<%@ taglib uri="http://jakarta.apache.org/taglibs/session-1.0" prefix="sess" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Accueil</title>
    <link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>
<center>
<span><b>Accueil<br/><br/></b></span>
<table cellspacing="5px">
<tr>
	<td>
		<div class="icon">
			<a href="consult_formations.htm">
				<img border="0" align="top" alt="Consultation des formations" src="./images/icon-48-contenu.png"/>
				<span>Consultation des formations</span>
			</a>
		</div>
	</td>
	<td>
		<div class="icon">
			<a href="identification.htm">
				<img border="0" align="top" alt="Connexion IRH" src="./images/icon-48-user.png"/>
				<span>Connexion IRH</span>
			</a>
		</div>
	</td>
</tr>
</table>
</center>
</body>
</html>
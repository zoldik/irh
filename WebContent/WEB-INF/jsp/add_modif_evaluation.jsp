<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Ajout ou modification d'une &eacute;valuation</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
    
    <script type="text/javascript">
		var nlignes = 1;
		var debutDiv = '<div class=\"ligne\">';
		var finDiv = '<\/div>';
		var label = '<span class=\"label\">Comp&eacute;tence : <\/span>';
		var debutSelect = '<select>';
		var finSelect = '<\/select>';
		var selectOptionCompetence = '<option>plop<\/option>';
		function Ajouter()
		{
			nlignes++;
			document.getElementById('saisie_competences').innerHTML += debutDiv;
			document.getElementById('saisie_competences').innerHTML += label;
			document.getElementById('saisie_competences').innerHTML += debutSelect;			
			document.getElementById('saisie_competences').innerHTML += selectOptionCompetence;
			document.getElementById('saisie_competences').innerHTML += finSelect;
			document.getElementById('saisie_competences').innerHTML += '&nbsp';
			document.getElementById('saisie_competences').innerHTML += finDiv;
		};
	</script>
</head>
<body>

<%@ include file="/WEB-INF/jsp/includes/header_menu.jsp" %>

<form:form method="post">
<fieldset>
<legend>Evaluation</legend> 
    <div class="ligne">
        <span class="label">Date :</span>
    	<form:input path="dateEvaluation" />
		<form:errors path="dateEvaluation" cssClass="error"/>
	</div>
	<div class="ligne">
        <span class="label">Employ&eacute; :</span>
        <form:select path="employe">
        	<form:options items="${employes}" itemValue="id" />
        </form:select>
    </div>
    <input type=button value="Ajouter une ligne" onclick="javascript:Ajouter()" />
    <div id="saisie_competences">
		<div class="ligne">
	        <span class="label">Comp&eacute;tence : </span>
	    	<form:select path="competence">
	        	<form:options items="${competences}" itemLabel="libelle" itemValue="id" />
	        </form:select>
	        &nbsp;
	        <form:select path="niveauCompetence">
	        	<form:options items="${niveau_competences}" />
	        </form:select>
		</div>
	</div>
	<div class="ligne">
        <span class="label">Commentaire :</span>
        <form:textarea path="commentaire" />
    </div>
    
    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="liste_evaluations.htm">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

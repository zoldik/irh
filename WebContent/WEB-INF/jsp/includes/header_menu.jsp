<%@ taglib uri="http://jakarta.apache.org/taglibs/session-1.0" prefix="sess" %>

<div class="gbh" style="right: 0pt;"></div>
<div id="titre" align="left" style="float: left; font-size: 84%; font-family: arial,sans-serif !important;">
	<nobr><b>Intranet Ressources Humaines</b></nobr>
</div>
<div id="bar" align="right" style="padding: 0pt 0pt 15px; font-size: 84%;">
	<nobr>
		<sess:existsAttribute name="nom">
		<b>Bienvenue <sess:attribute name="nom" /></b>
		|
		</sess:existsAttribute>
		<a href="accueil.htm">Accueil</a>
		|
		<sess:existsAttribute name="nom" value="false">
		<a href="identification.htm">Connexion</a>
		</sess:existsAttribute>
		<sess:existsAttribute name="nom">
		<a href="logout.htm">Déconnexion</a>
		</sess:existsAttribute>
	</nobr>
</div>

<div id="leftsidebar">
	<ul class="menu">
		<li class="subhead"><a href="accueil.htm" style="background-color: rgb(201, 215, 241); margin-bottom: 10px;">Accueil</a></li>
		
		<li class="subhead"><a href="accueil_rh.htm" style="background-color: rgb(220, 200, 190); margin-bottom: 10px;">Accueil RH</a></li>
		
		<li class="subhead"><a href="" style="background-color: rgb(77, 127, 222);">Administration</a></li>
			<li class="subtitle"><a href="liste_employes.htm" style="border-bottom: 1px solid rgb(77, 127, 222); color: rgb(77, 127, 222);">Gestion des employ&eacute;s</a></li>
			<li class="subtitle"><a href="liste_utilisateurs.htm" style="color: rgb(77, 127, 222);">Gestion des utilisateurs</a></li>
			
		
		<li class="subhead"><a href="" style="background-color: rgb(148, 219, 77);">Carrières</a></li>
			<li class="subtitle"><a href="liste_postes.htm" style="border-bottom: 1px solid rgb(148, 219, 77); color: rgb(148, 219, 77);">Gestion des postes</a></li>
			<li class="subtitle"><a href="liste_evaluations.htm" style="border-bottom: 1px solid rgb(148, 219, 77); color: rgb(148, 219, 77);">Gestions des evaluations</a></li>
			<li class="subtitle"><a href="liste_competences.htm" style="border-bottom: 1px solid rgb(148, 219, 77); color: rgb(148, 219, 77);">Gestion des compétences</a></li>
			<li class="subtitle"><a href="liste_metiers.htm" style="color: rgb(148, 219, 77);">Catalogue de m&eacute;tiers</a></li>
		
		<li class="subhead"><a href="" style="background-color: rgb(191, 191, 191);">Formations</a></li>
			<li class="subtitle"><a href="liste_formations.htm" style="border-bottom: 1px solid rgb(191, 191, 191); color: rgb(191, 191, 191);">Catalogue de formation</a></li>
			<li class="subtitle"><a href="liste_plan_formations.htm" style="color: rgb(191, 191, 191);">Plans de formations</a></li>
	</ul>
		
</div>
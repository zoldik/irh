<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Ajout ou modification d'un employé</title>
    <link href="style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<form:form method="post">
<fieldset>
<legend>Employé</legend>
    <fieldset>
        <legend>Informations</legend>
        <div id="nom">
            <div class="ligne">
                <span class="label">Civilité :</span>
                <form:select path="civilite">
        			<form:options items="${civilites}" itemLabel="libelle" itemValue="id" />
        		</form:select>
            </div>
            <div class="ligne">
                <span class="label">Nom :</span>
				<form:input path="nom" />
				<form:errors path="nom" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">Prénom :</span>
                <form:input path="prenom" />
				<form:errors path="prenom" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">Date de naissance :</span>
                <form:input path="dateNaissance" />
				<form:errors path="dateNaissance" cssClass="error"/>
            </div>
        </div>
        <div id="mail_tel">
            <div class="ligne">
                <span class="label">Email :</span>
                <form:input path="email" />
				<form:errors path="email" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">Tél. pro :</span>
                <form:input path="telephonePro" />
				<form:errors path="telephonePro" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">Tél. perso :</span>
                <form:input path="telephonePerso" />
				<form:errors path="telephonePerso" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">Tél. mobile :</span>
                <form:input path="telephoneMobile" />
				<form:errors path="telephoneMobile" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">Fax :</span>
                <form:input path="fax" />
				<form:errors path="fax" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">Rue :</span>
                <form:input path="adrRue" />
				<form:errors path="adrRue" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">CP :</span>
                <form:input path="adrCp" />
				<form:errors path="adrCp" cssClass="error"/>
            </div>
            <div class="ligne">
                <span class="label">Ville :</span>
                <form:input path="adrVille" />
				<form:errors path="adrVille" cssClass="error"/>
            </div>
        </div>
    </fieldset>
    
    <fieldset>
        <legend>Emplois Précédents</legend>
        <a class="ajout" href="./gestion_emplois_ajout.htm">
            Ajouter un emploi
        </a>
        <table class="adminlist">
            <thead>
                <tr>
                    <th>Date début</th>
                    <th>Date fin</th>
                    <th>Poste</th>
                    <th>Entreprise</th>
                    <th>Contrat</th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <tr class="row0">
                    <td>10/10/2006</td>
                    <td>20/11/2007</td>
                    <td>Secretaire Administration</td>
                    <td>Sigma Group</td>
                    <td>CDD</td>
                    <td align="center">
                        <a href="./gestion_emplois_modif.htm?id=1">
                            <img src="./images/edit.png" alt="Modifier l'utilisateur"/>
                        </a>
                    </td>
                    <td align="center">
                        <a href="./gestion_utilisateurs_suppr?id=1"  onclick="javascript: return confirm('Voulez-vous supprimer cet utilisateur?');">
                            <img src="./images/delete.png" alt="Supprimer l'utilisateur"/>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </fieldset>
    
    <fieldset>
        <legend>Diplomes</legend>
        <a class="ajout" href="./gestion_diplomes_ajout.htm">
            Ajouter un dimplome
        </a>
        <table class="adminlist">
            <thead>
                <tr>
                    <th>Année</th>
                    <th>Dénomination</th>
                    <th>Etablissement</th>
                    <th>Niveau</th>
                    <th>&nbsp;</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <tr class="row0">
                    <td>2006</td>
                    <td>BTS Communication</td>
                    <td>Notre Dame du Roc</td>
                    <td>Bac +2</td>
                    <td align="center">
                        <a href="./gestion_diplomes_modif.htm?id=1">
                            <img src="./images/edit.png" alt="Modifier l'utilisateur"/>
                        </a>
                    </td>
                    <td align="center">
                        <a href="./gestion_diplomes_suppr?id=1"  onclick="javascript: return confirm('Voulez-vous supprimer cet utilisateur?');">
                            <img src="./images/delete.png" alt="Supprimer l'utilisateur"/>
                        </a>
                    </td>
                </tr>
                <tr class="row1">
                    <td>2004</td>
                    <td>Bac STT Communication</td>
                    <td>Notre Dame du Roc</td>
                    <td>Bac</td>
                    <td align="center">
                        <a href="./gestion_diplomes_modif.htm?id=1">
                            <img src="./images/edit.png" alt="Modifier l'utilisateur"/>
                        </a>
                    </td>
                    <td align="center">
                        <a href="./gestion_diplomes_suppr?id=1"  onclick="javascript: return confirm('Voulez-vous supprimer cet utilisateur?');">
                            <img src="./images/delete.png" alt="Supprimer l'utilisateur"/>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </fieldset>
    
    <fieldset>
    <legend>Divers</legend>
		<div class="ligne">
		    <span class="label">Situation familiale :</span>
		    <form:select path="situationFamiliale">
       			<form:options items="${situationsFamiliale}" itemLabel="libelle" itemValue="id" />
       		</form:select>
		</div>
		<div class="ligne">
		    <span class="label">Nombre d'enfants :</span>
		    <select>
		        <option>&nbsp;</option>
		        <option>0</option>
		    </select>
		</div>
		<div class="ligne">
		    <span class="label">Description :</span>
		    <form:textarea path="description" />
		    <form:errors path="description" cssClass="error"/>
		</div>    
    </fieldset>

    <div class="ligne">
        <span class="label">&nbsp;</span>
        <a href="gestion_employes.htm">Retour</a>&nbsp;-&nbsp;<input type="submit" value="Valider" />
    </div>
</fieldset>
</form:form>

</body>
</html>

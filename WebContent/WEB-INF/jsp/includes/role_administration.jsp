<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/session-1.0" prefix="sess" %>

<sess:existsAttribute name="droit">
	<sess:equalsAttribute match="administration" name="droit" value="false">
		<sess:equalsAttribute match="drh" name="droit" value="false">
			<c:redirect url="erreur_droit.htm"/>
		</sess:equalsAttribute>
	</sess:equalsAttribute>
</sess:existsAttribute>
<sess:existsAttribute name="droit" value="false">
	<c:redirect url="identification.htm"/>
</sess:existsAttribute>
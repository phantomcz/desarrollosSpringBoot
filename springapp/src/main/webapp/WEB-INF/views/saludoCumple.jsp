<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head><title><fmt:message key="title"/></title>
  <style>
	    .error { color: red; }
	  </style>  
  </head>
  <body>
	<h1><fmt:message key="heading"/></h1>
  	<p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>   
	
	
	<c:url var="saludar" value="/saludoCumple.htm"></c:url>
	<form:form method="post" action="${saludar}" commandName="personaIngreso">
	
			
			<table>
				<tbody>
					<tr>
						<td>nombres:</td>
						<td><form:input path="nombres" /></td>
						<td><form:errors path="nombres" cssClass="campoConError"/></td>
					</tr>
					<tr>
						<td>apellido:</td>
						<td><form:input path="apellido" /></td>
						<td><form:errors path="apellido" cssClass="campoConError"/></td>
					</tr>
					<tr>
						<td>fecha Nac:</td>
						<td><form:input path="fechaNac" /></td>
						<td><form:errors path="fechaNac" cssClass="campoConError"/></td>
					</tr>
				</tbody>
			</table>
			
			<c:out value="${model.persona.nombre}"/> <c:out value="${model.persona.apellido}"/>
	    	<br><br>
	    	<c:out value="${model.persona.nombre}"/> <c:out value="${model.persona.fechaNac}"/>
	    	<br><br>
	    	<c:out value="${model.persona.nombre}"/> <c:out value="${model.persona.edad}"/>
	    	<br><br>
	    	<c:out value="${model.persona.nombre}"/> <c:out value="${model.persona.diasCuple}"/>
	    	<br><br>
	    	<c:out value="${model.persona.nombre}"/> <c:out value="${model.persona.poemaCumple}"/>
	  
	 		<br><br>
	  		<input type="submit" value="Execute">
		</form:form>
		<br>
		<br>
		<a href="<c:url value="hello.htm"/>">Home</a>
	</body>
	
	
</html>
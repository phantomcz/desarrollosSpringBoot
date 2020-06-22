<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head><title><fmt:message key="title"/></title>
  <style>
	    .error { color: red; }
	  </style>  
  </head>
  <script>
  		function limpiarPersonaIngreso() {
    		document.getElementById("personaIngreso").reset();
  		}
    	function limpiarFormulario() {
        	document.getElementById("miForm").reset();
  		}
</script>
  <body>
	<h1><fmt:message key="heading"/></h1>
	<c:url var="saludar" value="/saludoCumple.htm"></c:url>
	<form:form method="post" action="${saludar}" id="miForm" commandName="personaIngreso">
		<a href="<c:url value="hello.htm"/>">Home</a>
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
						<td>fecha Nac (DD/MM/YYYY):</td>
						<fmt:formatDate value="${fechaNac.date}" var="dateString" pattern="dd/MM/yyyy" />
						<td><form:input  path="fechaNac" /></td>
						<td><form:errors path="fechaNac" cssClass="campoConError"/></td>
					</tr>
				</tbody>
			</table>
			<br><br>
	  		<input type="submit" value="Ingresar" onclick="limpiarPersonaIngreso()">
	  		<input type="submit" value="limpiarFormulario" onclick="limpiarFormulario()">
	  		</form:form>
			<br>
			<br>
			<table>
				<tbody>
					<c:if test="${model.personaSaludada.nombre!=null}">
					<tr>
						<td>
							nombre:
						</td>
						<td>
						<c:out value="${model.personaSaludada.nombre}"/> <c:out value="${model.personaSaludada.apellido}"/>
						</td>
					</tr>
					</c:if>
					<c:if test="${model.personaSaludada.edad!=0 and
									model.personaSaludada.edad != null}">
					<tr>
						<td>
							Edad:
						</td>
						<td>
							<c:out value="${model.personaSaludada.edad}"/>
						</td>
					</tr>
					</c:if>
					<c:if test="${model.personaSaludada.diasCuple!=0 and
									model.personaSaludada.diasCuple!=null}">
					<tr >
						<td>Dias para tu cumpleaños:</td>
						<td>
							<c:out value="${model.personaSaludada.diasCuple}"/>
						</td>
					</tr>
					</c:if>
					<c:if test="${model.personaSaludada.diasCuple==0 and
							model.personaSaludada.poemaCumple!=null}">
					<tr >
						<td>Poema Cumpleaños:</td>
						<td>
							<c:out value="${model.personaSaludada.poemaCumple}" escapeXml="false"/>
						</td>
					</tr>
					</c:if>
				</tbody>
			</table>	 		
		
		<br>
		
	</body>
	
	
</html>
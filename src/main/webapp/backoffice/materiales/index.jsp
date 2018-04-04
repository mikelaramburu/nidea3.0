<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>BACKOFFICE Materiales</h1>

Buscador
<form action="backoffice/materiales" method="get">
	<input type="text" name="search" required placeholder="Nombre del Material">
	<input type="submit" value="Buscar">	
</form>


<ol>
	<c:forEach items="${materiales}" var="material">
		<c:set var="clase" value="" />	
		<c:choose>
			<c:when test="${material.precio > 25}">
				<c:set var="clase" value="text-danger" />
			</c:when>
			<c:when test="${material.precio > 6}">
				<c:set var="clase" value="text-primary" />
			</c:when>
		</c:choose>	
		<li>${material.nombre} - <span class="${clase}">${material.precio} &euro;</span></li>	
	</c:forEach>
</ol>

<jsp:include page="/templates/footer.jsp"></jsp:include>
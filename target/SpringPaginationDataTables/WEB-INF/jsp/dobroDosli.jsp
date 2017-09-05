<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<center>
	<div class="generic-container">
		<div class="alert alert-success lead">
	    	${success}
		</div>
		
  
		<span class="well pull-left">
			<a href="<c:url value='/' />">Početna strana</a>	
		</span>

		<span class="well pull-right">
			Go to <a href="<c:url value='/azuriranje.web' />">Lista proizvođača</a>
		</span>
	</div>
</center>
	
<%@ include file="footer.jsp" %>
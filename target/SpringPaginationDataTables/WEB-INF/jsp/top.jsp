<%-- 
    Document   : top
    Created on : Jul 26, 2016, 12:26:49 PM
    Author     : Pionir SU ; charset=utf-8
--%>

<%-- @ page language="java" contentType="text/html"
    pageEncoding="utf-8" --%> 
<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Organica.rs</title>
<!-- <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css"> -->
<link rel="stylesheet" type="text/css" href="${cp}/resources/jquery.dataTables.css">
<link href="${cp}/resources/default.css" rel="stylesheet" type="text/css">
	<link href="<c:url value='/resources/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/app.css' />" rel="stylesheet"></link>
<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
</head>

  <!--        <div class="container clearfix"> -->
                <body>
    <div id="wrap">

		<header>
			<div class="container clearfix">
				<div class="right">
				  <ul class="lang">
				    <li><a href="http://www.organica.rs/" target="_blank"><img src="${cp}/resources/images/lang-sr.png" width="24" height="19" alt="srpski"></a></li>
				    <li><a href="http://www.organica.rs/index-en.html" target="_blank"><img src="${cp}/resources/images/lang-en.png" width="24" height="19" alt="english"></a></li>
			      </ul>
				  <nav>
						<ul>
                                                     <li><a href="pocetna.web" target="_blank">Sertifikovani proizvođači</a></li>
						<!--	<li><a href="http://www.organica.rs/" target="_blank">Organska proizvodnja</a> -->
		
							<li><a href="login.web" target="_blank">Obrada</a></li>
						<!--	<li><a href="reportPdf.web" target="_blank">Lista proizvođača</a></li> -->
                                                        <li><a href="http://organic-nkolar.rhcloud.com/SpringJasperMaven/loadJasper.do" target="_blank">Lista proizvođača</a></li>
                                 
							<li><a href="http://www.organica.rs/kontakt.html" target="_blank">Kontakt</a></li>
						</ul>
					</nav>
				</div>
				<a href="http://www.organica.rs/" target="_blank" class="logo"><img src="${cp}/resources/images/logo.png" width="312" height="131" alt="Organic Control System"></a>
			</div>
		</header>                   
<!--        <h1>Hello World!</h1>
    </body>
</html>
-->

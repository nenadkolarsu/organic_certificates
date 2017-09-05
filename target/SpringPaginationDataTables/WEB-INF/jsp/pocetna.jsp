
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Organica.rs</title>
<!-- <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">  -->
<link rel="stylesheet" type="text/css" href="${cp}/resources/jquery.dataTables.css"> 
<link href="${cp}/resources/default.css" rel="stylesheet" type="text/css"> 
<script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<script type="text/javascript">

    //Plug-in to fetch page data 
	jQuery.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
	{
		return {
			"iStart":         oSettings._iDisplayStart,
			"iEnd":           oSettings.fnDisplayEnd(),
			"iLength":        oSettings._iDisplayLength,
			"iTotal":         oSettings.fnRecordsTotal(),
			"iFilteredTotal": oSettings.fnRecordsDisplay(),
			"iPage":          oSettings._iDisplayLength === -1 ?
				0 : Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
			"iTotalPages":    oSettings._iDisplayLength === -1 ?
				0 : Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
		};
	};

$(document).ready(function() {

	$("#example").dataTable( {
        "bProcessing": true,
        "bServerSide": true,
        "sort": "position",
        //bStateSave variable you can use to save state on client cookies: set value "true" 
        "bStateSave": false,
        //Default: Page display length
        "iDisplayLength": 10,
        //We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
        "iDisplayStart": 0,
        "fnDrawCallback": function () {
            //Get page numer on client. Please note: number start from 0 So
            //for the first page you will see 0 second page 1 third page 2...
            //Un-comment below alert to see page number
        	//alert("Current page number: "+this.fnPagingInfo().iPage);    
        },         
        "sAjaxSource": "springPaginationDataTablesPocetna.web",
        "aoColumns": [
            // utf8_encode({ "mData": "id" }),

            
//            utf8_encode({ "mData": "mesto" }),
//            utf8_encode({ "mData": "zemlja" }),
//            utf8_encode({ "mData": "rezerva2" }),
//            utf8_encode({ "mData": "rezerva1" }),
   //         { "mData": "proizvodjacId" },
   
            { "mData": "id" },
            { "mData": "proizvodjac" },
            { "mData": "adresa" },
            { "mData": "mesto" },
            { "mData": "zemlja" },
            { "mData": "rezerva2" },            
            { "mData": "rezerva1" }  
   

        ]
    } );

} );

</script>
</head>
<body>
    <div id="wrap">
<!-- http://stackoverflow.com/questions/29865056/jquery-datatables-does-not-show-unicode-characters -->
		<header>
			<div class="container clearfix">
				<div class="right">
                                                                            Ver 16.8.28
                                    <ul class="lang">

				    <li><a href="http://www.organica.rs/" target="_blank"><img src="${cp}/resources/images/lang-sr.png" width="24" height="19" alt="srpski"></a></li>
				    <li><a href="http://www.organica.rs/index-en.html" target="_blank"><img src="${cp}/resources/images/lang-en.png" width="24" height="19" alt="english"></a></li>
                                    </ul>
				  <nav>
						<ul>
                                                    <li><a href="pocetna.web" target="_blank">Sertifikovani proizvođači</a></li>
							<!--	<li><a href="http://www.organica.rs/" target="_blank">Organska proizvodnja</a> -->
		
							<li><a href="login.web" target="_blank" >Obrada</a></li>
						<!--	<li><a href="reportPdf.web" target="_blank">Lista proizvođača</a></li> -->
                                                        <li><a href="http://organic-nkolar.rhcloud.com/SpringJasperMaven/loadJasper.do" target="_blank">Lista proizvođača</a></li>
                                                        
							<li><a href="http://www.organica.rs/kontakt.html" target="_blank">Kontakt</a></li>
						</ul>
					</nav>
				</div>
				<a href="http://www.organica.rs/" target="_blank" class="logo"><img src="${cp}/resources/images/logo.png" width="312" height="131" alt="Organic Control System"></a>
			</div>
		</header>
   
                                <center>
<form:form action="" method="GET">
    <br>
    <h2 >Organic Control System - Sertifikovani proizvođači   </h2> 
<br>
 <table width="70%" style="border: 3px;background: rgb(243, 244, 248);"><tr><td>
	<table id="example" class="display" cellspacing="0" width="100%"> 
<!-- <table id="example" class="display dataTable no-footer" style="width: 70%;"> -->
        <thead>
            <tr>
 
                        <th align="left">Id</th>
     			<th align="left">Proizvodjač</th>
     			<th align="left">Adresa</th>
     			<th align="left">Mesto</th>
                        <th align="left">Zemlja</th>
                        <th align="left">Broj aktivnih</br> sertifikata</th>
<!--     			<th>Z</th> -->
                        <th align="left">Prikaz </br> sertifikata</th>
            </tr>
        </thead>       
    </table>
    </td>
    </tr>
         
        <tr><td>&nbsp</td></tr>   
        <tr><td>&nbsp</td></tr>   
        <tr><td>&nbsp</td></tr>   
        <tr>
         <td>
            <footer>
            <div class="container clearfix">
            <div class="left">&copy; 2016. Organic Control System</div>
            <div class="right"><a href="http://www.google.com/" target="_blank"><strong>BB</strong> dizajn</a></div>
            </div>
            </footer>
        </td>
         </tr>
 </table> 

</form:form>
</center>
 </div>
</body>


   
</html>
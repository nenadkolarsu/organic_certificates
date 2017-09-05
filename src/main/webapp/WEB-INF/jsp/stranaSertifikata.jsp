
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
        "sAjaxSource": "DrugaStranaSertifikata.web",
        "aoColumns": [
            { "mData": "nazivVrstaProizvodnje" },
            { "mData": "brojSertifikata" },
            { "mData": "tipSertifikata" },
            { "mData": "datumIzdavanja" },
            { "mData": "vaziDo" },
//            { "mData": "salary" },
            { "mData": "rezerva1" }, 
        ]
    } );

} );

</script>
</head>
<body>
    <div id="wrap">

		<header>
			<div class="container clearfix">
				<div class="right">
				  <ul class="lang">
				    <li><a href="index.html"><img src="${cp}/resources/images/lang-sr.png" width="24" height="19" alt="srpski"></a></li>
				    <li><a href="sablon.web"><img src="${cp}/resources/images/lang-en.png" width="24" height="19" alt="english"></a></li>
			      </ul>
				  <nav>
						<ul>
							<li><a href="op-ocs_privatni_standard.html">Organska proizvodnja</a>
								<ul>
									<li><a href="op-ocs_privatni_standard.html">OCS privatni standard</a></li>
									<li><a href="op-opsta_pravila.html">Opšta pravila</a></li>
									<li><a href="op-sertifikovani_proizvodjaci.html">Sertifikovani proizvođači</a></li>
									<li><a href="op-akreditacija.html">Akreditacija</a></li>
									<li><a href="op-kontrola.html">Kontrola</a></li>
									<li><a href="op-prijava_za_kontrolu_i_sertifikaciju.html">Prijava za kontrolu i sertifikaciju</a></li>
    <li><a href="op-uputstva_za_obelezavanje.html">Uputstva za obeležavanje</a></li>
	<li><a href="http://www.dnrl.minpolj.gov.rs/o_nama/organska.html">Važeći propisi u organskoj proizvodnji</a></li>
								</ul>
							</li>
							<li><a href="gp-upotreba_sertifikata.html">Geografsko poreklo</a>
								<ul>
									<li><a href="gp-upotreba_sertifikata.html">Upotreba sertifikata i oznaka geografskog porekla</a></li>
									<li><a href="gp-sertifikovani_proizvodjaci.html">Sertifikovani proizvođači</a></li>
									<li><a href="gp-opsta_pravila.html">Opšta pravila</a></li>
									<li><a href="files/ZAHTEV_V2_GI-D-12-02.doc">Zahtev za sertifikaciju</a></li>
								</ul>
							</li>
							<li><a href="vesti.html">Vesti</a></li>
							<li><a href="onama.html">O nama</a></li>
							<li><a href="kontakt.html">Kontakt</a></li>
						</ul>
					</nav>
				</div>
				<a href="index.html" class="logo"><img src="${cp}/resources/images/logo.png" width="312" height="131" alt="Organic Control System"></a>
			</div>
		</header>
   
                                <center>
<form:form action="" method="GET">
    <br>
    <h2 >Organic Control System - Sertifikovani proizvođači   </h2> 
<br>
<table width="70%" style="border: 3px;background: rgb(243, 244, 248);"><tr><td>
	<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
 
     			<th>Vrsta proizvoda</th>
     			<th>Broj sertifikata</th>
     			<th>Tip sertifikata</th>
                        <th>Datum izdavanja</th>
  			<th>Važi do</th>
<!--     			<th>Z</th> -->
                        <th>Dokument</th>
            </tr>
        </thead>       
    </table>
    </td></tr></table>
</form:form>
</center>
 </div>
</body>
            <footer>
            <div class="container clearfix">
            <div class="left">&copy; 2016. Organic Control System</div>
            <div class="right"><a href="http://www.google.com/" target="_blank"><strong>BB</strong> dizajn</a></div>
            </div>
            </footer>
</html>
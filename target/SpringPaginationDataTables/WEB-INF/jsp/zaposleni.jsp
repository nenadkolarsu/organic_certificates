

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
-->
<title>Add new zaposleni</title>
</head>
<body>
    <div> Zaposleni ${zaposleni} </div>

    <!-- 
    <form method="POST" action='ZaposleniController' name="frmAddZaposleni">
        ID : <input type="text" readonly="readonly" name="id"
            value="<c:out value="${zaposleni.id}" />" /> <br /> 
        Ime : <input
            type="text" name="ime"
            value="<c:out value="${zaposleni.proizvodnjac}" />" /> <br /> 
        
        Starost : <input
            type="text" name="starost"
            value="<c:out value="${zaposleni.adresa}" />" /> <br /> 
        Adresa : <input
            type="text" name="adresa"
            value="<c:out value="${zaposleni.adresa}" />" /> <br /> 

        Zarada : <input type="text" name="zarada"
            value="<c:out value="${zaposleni.zemlja}" />" /> <br /> 
        <input
            type="submit" value="Submit" />
    </form>
    -->            <!--     value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> <br /> -->
</body>
</html>

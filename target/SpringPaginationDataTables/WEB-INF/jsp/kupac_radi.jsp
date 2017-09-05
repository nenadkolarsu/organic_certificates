
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kupci</title>
<link rel="stylesheet" href="css/vicss.css">
    </head>
    <body>


        <div id="page-wrap">


            <h1>Pregled kupaca</h1>
            </br>
            </br>
            <a href="<c:url value="/main.htm"></c:url>">          Home</a> 
                </br>
            <a href="<c:url value="/kupacAdd.htm"></c:url>">Dodaj kupca</a> 
                            </br>

                <div class="CSSTableGenerator" >
                    <table style="border-collapse: collapse" cellpadding="7px"
                           border="1">
                        <tr>
                            <th> ID </th>
                            <th> Name </th>
                            <th> MB </th>
                            <th> PIB </th>
                            <th> PDV </th>
                            <th> Adresa </th>
                            <th> Mesto </th>
                            <th> Racun </th>
                            <th> action </th>
                        </tr>    



                    <c:forEach items="${kupac}" var="user">
                        <tr>
                            <td>${user.id}</td>  
                            <td>${user.name}</td>
                            <td>${user.maticni_broj}</td>
                            <td>${user.pib}</td>
                            <td>${user.pdv_potvrda}</td>
                            <td>${user.adresa}</td>
                            <td>${user.mesto}</td>
                            <td>${user.racun}</td>
                                
                            <td> <a href="<c:url value="/kupacEdit.htm?id=${user.id}"></c:url>">Edit</a> | <a href="<c:url value="/deleteKupac.htm?id=${user.id}"></c:url>">Remove</a></td>
                            <br />
                            </tr>
                    </c:forEach>




                </table>
            </div> <!-- table -->
        </div>
    </body>
</html>

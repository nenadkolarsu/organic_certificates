
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<%@ include file="top.jsp" %>

 <center>
            </br>
            
                <h2>Pregled sertifikata za proizvođača</h2>                            
            
          
            <h3> ${proizvodjac} -
                 ${adresa} -        
            ${mesto} </h3>
            </br>

              <!--    <div class="CSSTableGenerator" > -->
                <!--    <table style="border-collapse: collapse" cellpadding="7px"
                           border="1"> -->
                <table id="example" class="display dataTable no-footer" style="width: 70%;">    
                        <tr>
                            <th align="left"> Tip sertifikata </th>
                            <th align="left"> N0 sertifikata </th>
                            <th align="left"> Datum izdavanja </th>
                            <th align="left"> Važi do </th>
                            <th align="left"> Prikaz sertifikata </th>
                  <!--          <th> Adresa </th>
                            <th> Mesto </th>
                            <th> Racun </th>
                            <th> action </th> -->
                        </tr>    



                    <c:forEach items="${kupac}" var="user">
                        <tr>

                            <td>${user.nazivVrstaProizvodnje}</td>  
                            <td>${user.brojSertifikata}</td>
                            <td><fmt:formatDate value="${user.datumIzdavanja}" type="date" pattern="dd-MMM-yyyy"/></td>
                            <td><fmt:formatDate value="${user.vaziDo}" type="date" pattern="dd-MMM-yyyy"/></td>
             <!--                <td align="center"><a href="prikazSertifikata.web?id=${user.brojSertifikata}" target="_blank"><img src="https://hikashop.com/media/com_hikashop/upload/thumbnails/210x210/pdf.png" width="40" height="30" /></a> </td>  -->
                            <td align="center"><a href="download-document-${user.id}-${user.id}.web" target="_blank"><img src="https://hikashop.com/media/com_hikashop/upload/thumbnails/210x210/pdf.png" width="40" height="30" /></a> </td>
                    
                 <!--            <a href="http://www.espn.com" target="_blank" rel="nofollow">
        <img src="http://www.tizag.com/pics/htmlT/ahman.gif" class="linksESPN" />
      </a>
                                
                            <td> <a href="<c:url value="/kupacEdit.htm?id=${user.id}"></c:url>">Edit</a> | <a href="<c:url value="/deleteKupac.htm?id=${user.id}"></c:url>">Remove</a></td>
                            <br />
                 -->
                            </tr>
                    </c:forEach>
                            <tr>
                                <td>
                                    <a href="<c:url value="pocetna.web"></c:url>"> Povratak na stranu pretrage</a> 
                                </td>
                                <td></td>
                                <td></td>
                                <td></td>
                                 <td>
                                               <a href="<c:url value="http://organica.rs"></c:url>">Organica.rs</a> 
                                </td>
                            </tr>
 


                </table>
                 </center>
 <%@ include file="footer.jsp" %>
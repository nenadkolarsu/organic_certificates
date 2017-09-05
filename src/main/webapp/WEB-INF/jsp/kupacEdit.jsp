
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <link rel="stylesheet" href="css/mp.css">
    </head>
    <body>


        <form:form method="POST" action="updateKupac.htm" commandName="kupac">
            <form:errors path="*" cssClass="errorblock" element="div" />
            <table>
                <tr><h3>Izmena kupca</h3></tr>
            <tr>
                <td>Id :</td>
                <td><form:input path="id" value="${id}" />
                </td>
                <td><form:errors path="id" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Naziv :</td>
                <td><form:textarea path="name" />
                </td>
                <td><form:errors path="name" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Maticni broj :</td>
                <td><form:input path="maticni_broj" />
                </td>
                <td><form:errors path="maticni_broj" cssClass="error" />
                </td>
            </tr>
            <tr>
                <td>Pib :</td>
                <td><form:input path="pib" />
                </td>
                <td><form:errors path="pib" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Pdv :</td>
                <td><form:input path="pdv_potvrda" />
                </td>
                <td><form:errors path="pdv_potvrda" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Adresa :</td>
                <td><form:input path="adresa" />
                </td>
                <td><form:errors path="adresa" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Mesto :</td>
                <td><form:input path="mesto" />
                </td>
                <td><form:errors path="mesto" cssClass="error" />
                </td>
            </tr>

            <tr>
                <td>Racun :</td>
                <td><form:input path="racun" />
                </td>
                <td><form:errors path="racun" cssClass="error" />
                </td>
            </tr>
            </br>
            <tr>
                <td colspan="3"><input type="submit" ></td>
            </tr>
            <tr>
                <td colspan="3"><a href="main.htm"><input type="button" name="cancel" value="Cancel" /></a></td><br>
            </tr>
            <tr>
                <!--       <td colspan="3"><a href="/main.htm"><input type="reset" value="Clear form" /></a></td>   -->
                <!--  <td> <a href="<c:url value="/main.htm"></c:url>"Home</a></td>    -->
                </tr>

            </table>
    </form:form>

</body>
</html>




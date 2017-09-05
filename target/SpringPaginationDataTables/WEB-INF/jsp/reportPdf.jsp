<%-- 
    Document   : sablon
    Created on : Jul 26, 2016, 12:54:05 PM
    Author     : Pionir SU
--%>


<%@ include file="top.jsp" %>

                <div class="well lead">Datum va?enja od ... do</div>
                
                <form:form method="POST" class="form-horizontal" action="updateKupac.htm" commandName="sertifikati">

                    <div class="panel panel-default">
                                        <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Datum izdavanja: (dd/MM/yyyy)</label>
							<div class="col-md-3">
								<form:input type="date" path="datumIzdavanja" id="datumIzdavanja" class="form-control input-sm"/>
                                                                <div class="has-error">
									<form:errors path="datumIzdavanja" class="help-inline"/>
								</div>   
							</div>
							
						</div>
					</div>  
        
                                        <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" >Va?i do: (dd/MM/yyyy)</label>
							<div class="col-md-3">
								<form:input type="date" path="vaziDo" id="vaziDo" class="form-control input-sm"/>
                                                                <div class="has-error">
									<form:errors path="vaziDo" class="help-inline"/>
								</div>     
							</div>
							
						</div>
					</div> 
                        
                        </div>             
                   </form:form>
<%@ include file="footer.jsp" %>


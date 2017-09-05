<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="top.jsp" %>
<center>
	<div class="generic-container">
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Lista dokumenata ${user.id} - ${user.proizvodjac}</span></div>
		  	<div class="tablecontainer">
				<table class="table table-hover">
		    		<thead>
			      		<tr>
					        <th>No.</th>
                                                <th>Id</th>
                                                <th>Proizvodjač Id</th>
					        <th>File Name</th>
					        <th>Type</th>
					        <th>Sertifikat</th>
                                                <th>Vrsta proizvodnje</th>
                                                <th>Važi do</th>
					        <th width="100"></th>
					        <th width="100"></th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${documents}" var="doc" varStatus="counter">
						<tr>
							<td>${counter.index + 1}</td>
                                                        <td>${doc.id}</td>
                                                        
                                                        <c:set value="${doc.id}" var="proizvodjacId" /> 
                                                        <c:set var="proizvodjacId"> <fmt:message key="doc.id"/> </c:set>
                                                        <td>${doc.proizvodjacId}</td>
							<td>${doc.name}</td>
							<td>${doc.type}</td>
							<td>${doc.brojSertifikata}</td>
                                                        <td>${doc.nazivVrstaProizvodnje}</td>
                                                        
                                                        <td><fmt:formatDate value="${doc.vaziDo}" type="date" pattern="dd-MMM-yyyy"/></td>
							<td><a href="<c:url value='/download-document-${user.id}-${doc.id}.web' />" class="btn btn-success custom-width">download</a></td>
							<td><a href="<c:url value='/delete-document-${user.id}-${doc.id}.web' />" class="btn btn-danger custom-width">delete</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
		<div class="panel panel-default">
			
			<div class="panel-heading"><span class="lead">Upload novih dokumenata</span></div>
			<div class="uploadcontainer"> 
                                <form:form method="POST" action="uploadFile.web" modelAttribute="fileBucket" enctype="multipart/form-data" class="form-horizontal">         
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Upload documenta:</label>
							<div class="col-md-7">
								<form:input type="file" path="file" id="file" class="form-control input-sm"/>
								<div class="has-error">
									<form:errors path="file" class="help-inline"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Description:</label>
							<div class="col-md-7">
								<form:input type="text" path="description" id="description" class="form-control input-sm"/>
							</div>
							<div class="has-error">
									<form:errors path="description" class="help-inline"/>
							</div>
						</div>
					</div>

                                        <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Proizvodjac Id:</label>
							<div class="col-md-7">
								<form:input type="hidden" path="proizvodjacId" id="proizvodjacId" value="${user.id}" class="form-control input-sm" />
							</div>
                              
                                                      	<div class="has-error">
								<form:errors path="proizvodjacId" class="help-inline"/>
							</div>  
							
						</div>
					</div>
                                                        
                                        <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Broj sertifikata:</label>
							<div class="col-md-7">
								<form:input type="text" path="brojSertifikata" id="brojSertifikata" class="form-control input-sm"/>
							</div>
							
						</div>
					</div>
                                                        
                                        <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Vrsta proizvodnje:</label>
							<div class="col-md-7">
								<form:input type="text" path="nazivVrstaProizvodnje" id="nazivVrstaProizvodnje" class="form-control input-sm"/>
							</div>
							
						</div>
					</div>
                                                        
                                        <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Datum kontrole: (dd/MM/yyyy)</label>
							<div class="col-md-3">
								<form:input type="date" path="datumKontrole" id="datumKontrole" class="form-control input-sm"/>
                                                        	<div class="has-error">
									<form:errors path="datumKontrole" class="help-inline"/>
								</div>        
							</div>
							
						</div>
					</div>          
   
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
							<label class="col-md-3 control-lable" >Važi do: (dd/MM/yyyy)</label>
							<div class="col-md-3">
								<form:input type="date" path="vaziDo" id="vaziDo" class="form-control input-sm"/>
                                                                <div class="has-error">
									<form:errors path="vaziDo" class="help-inline"/>
								</div>     
							</div>
							
						</div>
					</div> 
                                                                
                                        <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Tip sertifikata</label>
							<div class="col-md-7">
								<form:input type="text" path="tipSertifikata" id="tipSertifikata" class="form-control input-sm"/>
							</div>
							
						</div>
					</div>
                                                        
                                        <div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="file">Napomena</label>
							<div class="col-md-7">
								<form:input type="text" path="rezerva1" id="rezerva1" class="form-control input-sm"/>
							</div>
							
						</div>
					</div>
                                                        
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Upload" class="btn btn-primary btn-sm">
						</div>
					</div>
	
				</form:form>
				</div>
		</div>
	 	<div class="well">
	 		Go to <a href="<c:url value='/azuriranje.web' />">Lista proizvođača</a>
	 	</div>
   	</div>
</center>
	
<%@ include file="footer.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>

	<div class="well lead">Podaci o proizvođaču</div>
        <center>
         	<c:if test="${edit}">
			<span class="well pull-left">
				<a href="<c:url value='/add-document-${sertifikati.id}.web' />">Klikni za upload i obradu dokumenata za proizvođača</a>	
			</span>
		</c:if>
  	<form:form method="POST" modelAttribute="sertifikati" class="form-horizontal" commandName="sertifikati">

     		<form:input type="hidden" path="id" id="id" />" 
                
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="id">Id</label>
				<div class="col-md-7">
					<form:input type="text" path="id" id="id" class="form-control input-sm" disabled="true"/>
					<div class="has-error">
						<form:errors path="id" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>                
	
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="proizvodjac">Proizvođač Id</label>
				<div class="col-md-7">
					<form:input type="text" path="proizvodjacId" id="proizvodjacId" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="proizvodjacId" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
                                        
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="proizvodjac">Proizvođač</label>
				<div class="col-md-7">
					<form:input type="text" path="proizvodjac" id="proizvodjac" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="proizvodjac" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="adresa">Adresa</label>
				<div class="col-md-7">
					<form:input type="text" path="adresa" id="adresa" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="adresa" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="mesto">Mesto</label>
				<div class="col-md-7">
					<c:choose>
						<c:when test="${edit}">
							<form:input type="text" path="mesto" id="mesto" class="form-control input-sm" /> 
						</c:when>
						<c:otherwise>
							<form:input type="text" path="mesto" id="mesto" class="form-control input-sm" />
							<div class="has-error">
								<form:errors path="mesto" class="help-inline"/>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="zemlja">Zemlja</label>
				<div class="col-md-7">
					<form:input type="text" path="zemlja" id="zemlja" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="zemlja" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>
                                        
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="aktivan">Aktivan</label>
				<div class="col-md-7">
					<form:input type="text" path="aktivan" id="aktivan" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="aktivan" class="help-inline"/>
					</div> 
				</div>
			</div>
		</div>                                        

		<div class="row">
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
	<!--					<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">  Cancel</a>
        -->
 					<input type="submit" value="Update" class="btn btn-primary btn-sm"/> 
                                        <a href="<c:url value='/list.web' />" class="btn btn-danger custom-width">  Cancel </a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list.web' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<c:if test="${edit}">
			<span class="well pull-left">
				<a href="<c:url value='/add-document-${sertifikati.id}.web' />">Klikni za upload i obradu dokumenata za proizvođača</a>	
			</span>
		</c:if>
	
	</form:form>
</center>
<!-- disabled="true" -->	
<%@ include file="footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Registration Form</title>
	<link href="<c:url value='/resources/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/resources/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="well lead">User Registration Form</div>

  	<form:form method="POST" modelAttribute="user" class="form-horizontal" commandName="user">

     		<form:input type="hidden" path="${b.id}" id="id" />" 
		
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
							<form:input type="text" path="mesto" id="mesto" class="form-control input-sm" disabled="true"/>
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
			<div class="form-actions floatRight">
				<c:choose>
					<c:when test="${edit}">
						<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
					</c:when>
					<c:otherwise>
						<input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<c:if test="${edit}">
			<span class="well pull-left">
				<a href="<c:url value='/add-document-${user.proizvodjacId}' />">Click here to upload/manage your documents</a>	
			</span>
		</c:if>
	
	</form:form>

	
</body>
</html>
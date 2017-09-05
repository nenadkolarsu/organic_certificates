<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
	<div class="generic-container">
            	<div class="well">
	 		<a href="<c:url value='/newuser.web' />" class="col-sm-10 control-label">Dodaj novog proizvođača</a>
                        <br> <br>
        <div class="generic-container" style="min-height: 5px">

	<div class="starter-template">
	<!--	<h4>Search Form</h4> bio class generic-container
		<br>
-->
		<div id="feedback"></div>

		<form class="form-horizontal" id="search-form" method="POST">
			<div class="form-group form-group-lg">
			<!--	<label class="col-sm-2 control-label">Search</label> -->
				<div class="col-sm-05">
                                    <input type=text class="form-control" id="whereUslov" name="whereUslov">
				</div>
			</div>
                    <!--
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="email">
				</div>
			</div>
                    -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Search</button>
				</div>
			</div>
		</form>

	</div>

</div>

	 	</div>
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Lista proizvođača </span></div>
		  	<div class="tablecontainer">
				<table class="table table-hover">
		    		<thead>
			      		<tr>
                                                <th>Id</th>
					        <th>Proizvođač</th>
					        <th>Adresa</th>
					        <th>Mesto</th>
					        <th>Zemlja</th>
                                                <th>Aktivan</th>
					        <th width="100"></th>
					        <th width="100"></th>
						</tr>
			    	</thead>
		    		<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
                                                        <td>${user.id}</td>
							<td>${user.proizvodjac}</td>
							<td>${user.adresa}</td>
							<td>${user.mesto}</td>
							<td>${user.zemlja}</td>
                                                        <td>${user.aktivan}</td>
							<td><a href="<c:url value='/edit-user-${user.id}.web' />" class="btn btn-success custom-width">edit</a></td>
							<td><a href="<c:url value='/delete-user-${user.id}.web' />" class="btn btn-danger custom-width">delete</a></td>
						</tr>
					</c:forEach>
		    		</tbody>
		    	</table>
		    </div>
		</div>
	 	<div class="well">
	 		<a href="<c:url value='/newuser.web' />">Dodaj novog proizvođača</a>
	 	</div>
   	</div>
<%@ include file="footer.jsp" %>
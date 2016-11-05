<template:basic htmlTitle="Staff" bodyTitle="People">

	<div class="row">
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="">
				<div class="row">
					<div class="col-md-6">
						<div class="btn-group ">
							<button type="button"
								class="btn btn-info dropdown-toggle waves-effect waves-light"
								data-toggle="dropdown" aria-expanded="true">
								Actions <span class="caret"></span>
							</button>
							
							<ul class="dropdown-menu" role="menu" id="dropDownResult">
							</ul>
						</div>
					</div>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th><input type="checkbox"></th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
							<th>Age</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody id="STAFF_RESULT">

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/jquery-tmpl" id="STAFF_TMPL"> 
		<tr>
			<td><input type="checkbox"></td>
			<td>{{= firstName }}</td>
			<td>Mac Queen</td>
			<td>@steve</td>
			<td>20</td>
			<td>Active</td>
		</tr>
	</script>

	<%@include file="../../views/dashboard/footer.jsp"%>
	<script src="<c:url value="/static/school/js/school_1002_0201.js" />"></script>
</template:basic>

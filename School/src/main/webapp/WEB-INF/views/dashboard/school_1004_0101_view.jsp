<template:basic htmlTitle="Classroom" bodyTitle="classroom">
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					
					<table class="table table-hover table-striped">
						<thead>
						<tr>			
						<td class="col-md-2">CLASSROOM_ID</td>
						<td class="col-md-8">CLASSROOM</td>
						<td class="col-md-2">Action</td>
						</tr>
						
						</thead>
						<tbody id="CLSROOM-RESULT"></tbody>
					</table>
		
		
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

		






<script id="CLSROOM-TMPL" type="text/jquery-tmpl">
	<tr>
		
		<td>{{= id }}</td>
		<td>{{= classroom }}</td>
		<td><a href="javascript:"><span class="ion ion-chevron-down"></span></a></td>
	</tr>
	<tr style="">
		<td colspan="3">
			<table class="table table-hover table-striped">
				<tr>
					<th>Head1</td>
					<th>Head2</td>
					<th>Head3</td>
				</tr>
				<tr>
					<td>Chil1</td>
					<td>Child2</td>
					<td>Child2</td>
				</tr>
				<tr>
					<td>Chil1</td>
					<td>Child2</td>
					<td>Child2</td>
				</tr>
				<tr>
					<td>Chil1</td>
					<td>Child2</td>
					<td>Child2</td>
				</tr>
			</table>
		</td>
	</tr>

</script>
<%@include file="../../views/dashboard/footer.jsp" %>
<script src="<c:url value="/static/school/js/school_1004_0101.js" />"></script>
</template:basic>

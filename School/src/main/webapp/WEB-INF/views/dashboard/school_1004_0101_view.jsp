<template:basic htmlTitle="Classroom" bodyTitle="classroom">
<input id="STUDENT-URL" type="hidden" value="<c:url value="/dashboard/people/school_1002_0302_r002.chitra"/> ">
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					
					<table class="table table-hover table-striped">
						<thead>
						<tr>			
						<th class="col-md-2 ">CLASSROOM_ID</th>
						<th class="col-md-8 ">CLASSROOM</th>
						<th class="col-md-2 ">Action</th>
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
		
		<td class="CLSROOM-ID">{{= id }}</td>
		<td>{{= classroom }}</td>
		<td><a href="javascript:" class="list-students"><span class="ion text-purple ion-chevron-down"></span></a></td>
	</tr>
	<tr style="display:none;" class="show-students">
		<td colspan="3">
		<div style="height:500px;">
		  <table class="table table-hover table-striped">
			<thead>
				<tr>
					<th class="col-md-2 ">STUDENT ID</th>
					<th class="col-m4-4 ">Khmer Name</th>
					<th class="col-md-4 ">English Name</th>
					<th class="col-md-2 ">
						<button class="btn btn-xs btn-purple waves-effect waves-light m-b-5">
							 <span>Download Excel</span> <i class="fa  fa-file-excel-o"></i> 
						</button>
					</th>
				</tr>
			</thead>
			<tbody class="STUDENTS-RESULT" height:1200px>
			</tbody>
			<tfoot style="display:none">
				<tr>
					<td colspan="4" align="center">There is no data!</td>
				</tr>
			</tfoot>
		</table>
		<div class="group">
	       <nav class="STUDENTS-PAGING">
			</nav>
        </div>
	  </td>
	</tr>

</script>
 <script type="text/jquery-tmpl" id="STUDENTS_TMPL">

		<tr>
			<td>{{= id }}</td>
			<td>{{= kmLastName }} {{= kmFirstName }}</td>
			<td>{{= firstName }} {{= lastName }}</td>
			<td>
				
			</td>
		</tr>

 </script>
<%@include file="../../views/dashboard/footer.jsp" %>
<script src="<c:url value="/static/school/js/school_1004_0101.js" />"></script>
</template:basic>

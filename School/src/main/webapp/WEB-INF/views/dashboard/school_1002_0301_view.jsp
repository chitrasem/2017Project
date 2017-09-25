<template:basic htmlTitle="Students" bodyTitle="People">
<!-- ============================================================== -->	
<form id="school_1002_0301_download" action="<c:url value="/dashboard/people/school_1002_0301_download"/> " method="post">
	<input type="hidden" name="srcStudentId" id="srcStudentId">
</form>
<form id="school_1002_0303_form" action="school_1002_0303.act" method="post">
	<input type="hidden" name="studentId" id="viewStudentId" value="0">
</form>

	<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<!-- <div class="table-responsive"> -->
						<div class="">
						   <form id="school_1002_0302_form" action="school_1002_0302.act" method="post">
						   <input type="hidden" name="studentId" id="studentId" value="0">
							<div class="row">
								<div class="col-md-6">
									<div class="btn-group">
                                          <button type="button" id="actionStudent" class="btn btn-purple dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">Actions 
                                          <span class="caret"></span>
                                          </button>
                                          <ul class="dropdown-menu" role="menu" id="dropDownResult" >
                                          </ul>
                                      </div>                                      
									<button id="btnAdd" type="button" class="btn btn-purple waves-effect waves-light">
										<span>Add</span> <i class="ion ion-person-add"></i>
									</button>      
									<button id="btnDownload" type="button" class="btn btn-purple waves-effect waves-light">
										<span>Download Excel</span> <i class="ion ion-ios7-cloud-download"></i>
									</button>                               
								</div>
								<div class="col-md-6">
									
								</div>
							</div>
						   </form>
						   <div style="min-height:500px;">
							<table class="table table-hover table-striped">
								<thead>
									<tr>
										<th >
										<input type="checkbox">
										</th>
										<th>ឈ្មោះជាភាសាខ្មែរ</th>
										<th>ឈ្មោះជាភាសាអង់គ្លេស</th>
										<th>ថ្ងៃខែឆ្នាំកំណើត</th>
										<th>លេខទូរស័ព្ទ</th>
										<th>ជម្រើស</th>
										<th>កំណត់ចំណាំ</th>
									</tr>
								</thead>
								<tbody id="STUDENT_RESULT" style="hight: 100px;">

								</tbody>
							</table>
							</div>
							<!-- Pagination -->
							<div class="group text-right">
	                          	<nav id="pagination">
								</nav>
                          	
                          	</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End row -->
	<script type="text/jquery-tmpl" id="STUDENT_TMPL">                                       
		<tr>
			<td><input  type="checkbox">
				<input type="hidden" value="{%= id %}" class="STUDENT_ID">
			</td>
			<td>
			<image class="thumb-sm pop_img_over img-circle" src="${pageContext.request.contextPath}{%= imagePath %}{%= imageName %}" alt="{%= firstName %} " />
			<a href="javascript:" class="btn-view">{%= kmLastName %}&nbsp;{%= kmFirstName %}
			<span class="driver"></span>
			{%if (gender === "M") %}
			<i  class="ion ion-male m-r-15 text-pink"></i>
			{%else%}
			<i  class="ion ion-female m-r-15 text-purple"></i>
			{%/if%}
			</a>			
			</td>		
			<td>{%= firstName %}&nbsp{%= lastName %}</td>
			<td>{%= school.string.formatBirthDate( birthDate ) %}</td>
			<td>{%= phone1 %}</td>
			<td>							
				<button  class="btn btn-edit btn-xs btn-default waves-effect waves-light m-b-5">
					<i class="fa  fa-caret-square-o-down"></i> 
				</button>
			{%if (state === "Inactive") %}				
				<button class="btn btn-xs btn-default waves-effect waves-light m-b-5">
					<i class="fa fa-money"></i> 
				</button>
			{%/if%}
			</td>
			<td>{%= biography %}</td>
		</tr>
	</script>	
	<script>
	var studentForm = "school_1002_0302.act";
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1002_0301.js" />"></script>
</template:basic>

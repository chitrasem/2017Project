<template:basic htmlTitle="Students" bodyTitle="People">
	<!-- ============================================================== -->	
	<div class="row">
		<div class="col-lg-12">
			<div class="portlet">
				<div class="portlet-heading bg-info">
					<h3 class="portlet-title">User Management</h3>
					<div class="portlet-widgets"> 	
                       <input style="height:25px" type="text" class="search-bar" placeholder="Type here for search..."> 
						<a href="javascript:" class="right-bar-toggle waves-effect waves-light"><i class="ion-arrow-down-b"></i></a>
						<span class="divider"></span>       
						<a href="javascript:" data-toggle="search"><i class="ion-search"></i></a> 
						<span class="divider"></span>  
						<span class="divider"></span>  
						<span class="divider"></span>
						<span class="divider"></span>
						<span class="divider"></span>
						<span class="divider"></span>
						<span class="divider"></span>
						<span class="divider"></span>
						<span class="divider"></span>
						<span class="divider"></span>  
						<span class="divider"></span>  
						<span class="divider"></span>  
						<span class="divider"></span>  
						<span class="divider"></span>  
						<span class="divider"></span>     
						<a href="javascript:" data-toggle="reload"><i class="ion-refresh"></i></a> 
						<span class="divider"></span> 
						<a data-toggle="collapse" data-parent="#accordion1" href="#bg-info"><i class="ion-minus-round"></i></a> 
						<span class="divider"></span> 
						<a href="javascript:" data-toggle="remove"><i class="ion-close-round"></i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div id="bg-info" class="panel-collapse collapse in">
					<div class="portlet-body bg-info">


					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Searching*********************************************************************** -->
	       	<div class="row">                        
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-body">
	                <div class="input-group">
	                    <input type="text" id="searchName" name="example-input1-group2" class="form-control input-lg" placeholder="Search any name">
	                    <span class="input-group-btn">
	                        <button id="btnSearchName" type="button" class="btn-lg btn waves-effect waves-light btn-primary w-md"><i class="fa fa-search"></i></button>
	                    </span>
	                </div>
	            </div>
	        </div>
	    </div>
	
	</div>
	<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="table-responsive">
						   <form id="school_1002_0301" action="school_1002_0302.act" method="post">
						   <input type="hidden" name="studentId" id="studentId" value="0">
							<div class="row">
								<div class="col-md-6">
									<div class="btn-group">
                                          <button type="button" id="actionStudent" class="btn btn-success dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">Actions 
                                          <span class="caret"></span>
                                          </button>
                                          <ul class="dropdown-menu" role="menu" id="dropDownResult" >
                                          </ul>
                                      </div>
								</div>
							</div>
						   </form>
							<table class="table table-hover">
								<thead>
									<tr>
										<th >
												<input type="checkbox">
										</th>
										<th>Student ID</th>
										<th>Khmer Name</th>
										<th>English Name</th>
										<th>Gender</th>
										<th>Age</th>
										<th>Status</th>
										<th>Memo</th>
									</tr>
								</thead>
								<tbody id="STUDENT_RESULT">

								</tbody>
							</table>
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
				<input type="hidden" value="{{= id }}" class="STUDENT_ID">
			</td>
			<td>{{= id }}</td>
			<td>{{= kmLastName }}&nbsp;{{= kmFirstName }}</td>
			<td>{{= firstName }}&nbsp{{= lastName }}</td>
            <td>
			{{if (gender == "M") }}
				Male
			{{else}}
				Female
			{{/if}}
			</td>
			<td>{{= birthDate }}</td>
			<td>Active</td>
			<td>{{= biography }}</td>
		</tr>
	</script>
	
	<script>
	var studentForm = "school_1002_0302.act";
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1002_0301.js" />"></script>
</template:basic>

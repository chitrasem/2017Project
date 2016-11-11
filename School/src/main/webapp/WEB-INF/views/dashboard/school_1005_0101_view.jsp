<template:basic htmlTitle="Students" bodyTitle="People">

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
						<!-- <div class="table-responsive"> -->
						<div class="">
						   <form id="school_1002_0301" action="school_1002_0302.act" method="post">
						   <input type="hidden" name="studentId" id="studentId" value="0">
							<div class="row">
								<div class="col-md-6">
									<div class="btn-group">
										<button id="btnAddPayment" class="btn btn-purple">Add Payment</button>
                                          <!-- <button type="button" id="actionPayment" class="btn btn-success dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">Actions 
                                          <span class="caret"></span>
                                          </button>
                                          <ul class="dropdown-menu" role="menu">
                                          </ul> -->
                                      </div>
								</div>
							</div>
						   </form>
							<table class="table table-hover table-striped">
								<thead>
									<tr>
										<th >
										<input type="checkbox">
										</th>
										<th>Student ID</th>
										<th>Khmer Name</th>
										<th>English Name</th>
										<th>Gender</th>
										<th>Age</th>
										<th>Status</th>
										<th>Memo</th>
									</tr>
								</thead>
								<tbody id="PAYMENT_RESULT" style="hight: 100px;">

								</tbody>
							</table>
							<!-- Pagination -->
							<div class="group">
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
	<script type="text/jquery-tmpl" id="PAYMENT_TMPL">                                       
		
		
	</script>
	
	<script>
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1005_0101.js" />"></script>
</template:basic>

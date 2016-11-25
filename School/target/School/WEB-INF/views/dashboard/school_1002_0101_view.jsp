<template:basic htmlTitle="Users" bodyTitle="People">
	<!-- ============================================================== -->
	<div class="row">
		<div class="col-lg-12">
			<div class="portlet">
				<div class="portlet-heading bg-info">
					<h3 class="portlet-title">Users Management</h3>
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
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-12 col-sm-12 col-xs-12">
												<div class="table">
													<div class="row">
														<div class="col-md-6">
															<div class="btn-group open">
				                                            <button type="button" class="btn btn-info dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">Actions <span class="caret"></span></button>
				                                            <ul class="dropdown-menu" role="menu">
				                                                <li><a href="javascript:">Export excel</a></li>
				                                                <li><a href="javascript:">Add new user</a></li>
				                                                <li class="divider"></li>
				                                                <li><a href="javascript:"><i>Select users to see more actions</i></a></li>
				                                            </ul>
				                                        </div>
														</div>
													</div>
													<table class="table table-hover">
														<thead>
															<tr>
																<th ><input type="checkbox"> </th>
																<th>First Name</th>
																<th>Last Name</th>
																<th>Username</th>
																<th>Email</th>
																<th>Status</th>
															</tr>
														</thead>
														<tbody id="USER_RESULT">
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

					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/x-jquery-tmpl" id="USER_TMPL" >
		<tr>
			<td><input type="checkbox"></td>
			<td>{{= firstName }}</td>
			<td>{{= lastName}}</td>
			<td>{{= ssoId }}</td>
			<td>{{= email }}</td>
			<td>{{= state }}</td>
		</tr>
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/school_1002_0101.js" />"></script>
    
</template:basic>

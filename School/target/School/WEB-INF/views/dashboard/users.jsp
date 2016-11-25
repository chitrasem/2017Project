<template:basic htmlTitle="Users" bodyTitle="Users">
	<!-- ============================================================== -->
	<!-- Start right Content here -->
	<div class="content" ng-app="myApp" >
		<div class="container" ng-controller="UserController as ctrl" >
			 <div class="row">
                  <div class="col-md-12">
                      <div class="panel panel-default">
                          <div class="panel-heading">
                              <h3 class="panel-title">User Information</h3>
                              <p>${users}</p>
                          </div>
                          <div class="panel-body">
                              <div class="row">
                                  <div class="col-md-12 col-sm-12 col-xs-12">
                                      <div class="table-responsive">
                                          <table class="table">
                                              <thead>
                                                  <tr>
                                                      <th>#</th>
                                                      <th>First Name</th>
                                                      <th>Last Name</th>
                                                      <th>Username</th>
                                                      <th>Email</th>
                                                      <th>State</th>
                                                      <th>Role</th>
                                                      <th>Action</th>
                                                  </tr>
                                              </thead>
                                              <tbody>
                                                  <tr ng-repeat="u in ctrl.users">
                                                      <td><span ng-bind="u.id"></span></td>
                                                      <td><span ng-bind="u.firstName"></span></td>
                                                      <td><span ng-bind="u.lastName"></span></td>
                                                      <td><span ng-bind="u.ssoId"></span></td>
                                                      <td><span ng-bind="u.email"></span></td>
                                                      <td><span ng-bind="u.state"></span></td>
                                                      <td ng-repeat="p in u.userProfiles"><span ng-bind="p.type"></span></td>
                                                      <td>                                                      	
                              						  	<button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                                                      </td>
                                                  </tr>                                                  
                                                  
                                              </tbody>
                                          </table>
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                  </div>
              </div> <!-- End row -->


		</div>
		<!-- container -->

	</div>
	<!-- content -->

	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/kms/js/app.js' />"></script>
      <script src="<c:url value='/static/kms/js/service/user_service.js' />"></script>
      <script src="<c:url value='/static/kms/js/controller/user_controller.js' />"></script>
</template:basic>

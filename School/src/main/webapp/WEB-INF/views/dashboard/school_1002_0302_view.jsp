<template:basic htmlTitle="New Student" bodyTitle="People">
	<!-- ============================================================== -->
	
<div class="row">
	<div class="col-md-6">												
		<div class="btn-group open">
               <button type="button" id="actionStudent" class="btn btn-info dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">Actions <span class="caret"></span></button>
               <ul class="dropdown-menu" role="menu" id="dropDownResult" >
               </ul>
          	</div>
	</div>
	<div class="clearfix"></div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					<form class="form-horizontal">
					<fieldset>
						<legend>Student Information</legend>
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="firstName">First name:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="firstName" placeholder="Enter first name">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="lastName">Last name:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="lastName" placeholder="Enter last name">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="kmFirstName">First name in Khmer:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="kmFirstName" placeholder="First name in Khmer">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="firstName">Last name in Khmer:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="lastName" placeholder="Last name in Khmer">
						 		</div>
                            </div>
                        </div>	
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4">Gender:</label>
                             	<div class="col-sm-8">
                             		<select id="gender">
                             			<option value="">--Select Gender--</option>
                             			<option value="M">Male</option>
                             			<option value="F">Female</option>
                             		</select>
						 		</div>
                            </div>
                        </div>	
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="dateOfBirth">Date of Birth:</label>
                             	<div class="col-sm-8">
									<input type="date" class="form-control" id="lastName" placeholder="Enter Date of Birth">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-12">
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="placeOfBirth">Place of Birth:</label>
                             	<div class="col-sm-10">
                             		<textarea rows="2" cols="100" id="placeOfBirth" placeholder="Enter place of birth"></textarea>
						 		</div>
                            </div>
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="biography">Biography:</label>
                             	<div class="col-sm-10">
                             		<textarea rows="10" cols="100" id="placeOfBirth" placeholder="Enter biography"></textarea>
						 		</div>
                            </div>
                        </div>                        
					</fieldset>
					<fieldset>
						<legend>Contact Information</legend>
							
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="telephone1">Telephone 1:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="telephone1" placeholder="Enter telephone 1">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="telephone2">Telephone 2:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="telephone2" placeholder="Enter telephone 2">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="emailAddr">Email Address:</label>
                             	<div class="col-sm-8">
									<input type="email" class="form-control" id="emailAddr" placeholder="Enter email address">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-12">
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="placeOfBirth">Current Address:</label>
                             	<div class="col-sm-10">
                             		<textarea rows="2" cols="100" id="currentAddr" placeholder="Enter current address"></textarea>
						 		</div>
                            </div>
                        </div>
					</fieldset>
					<fieldset>
						<legend>Family Information</legend>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="motherName">Mother's name:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="motherName" placeholder="Enter mother's name">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="motherTelphone">Mother's Telephone:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="motherTelphone" placeholder="Enter mother's telephone">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="fatherName">Father's name:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="fatherName" placeholder="Enter father's name">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="fatherTelephone">Father's Telephone:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" id="fatherTelephone" placeholder="Enter father's telephone">
						 		</div>
                            </div>
                        </div>
                        
					</fieldset>                        							 
                        <div class="clearfix"></div>
                        <input id="btnSave" type="button" class="btn btn-info " value="Save">
					  <!-- <button type="submit" class="btn btn-default">Submit</button> -->
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1002_0302.js" />"></script>
</template:basic>

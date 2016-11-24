<template:basic htmlTitle="New Student" bodyTitle="People">
	<!-- ============================================================== -->

<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					<form class="form-horizontal" id="school_1002_0302_form">
					<fieldset>
						<legend>Memo</legend>
                     	<div class="col-md-12">
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="content">Memo:</label>
                             	<div class="col-sm-10">
									<input type="text" class="form-control" value="សូមបង់ប្រាក់ដើប្បីចូលរៀន" name="content" id="content" placeholder="Enter memo">
						 		</div>
                            </div>
                        </div>                        
                     	<div class="col-md-12" id="MEMO_RESULT">
                        </div>
						<legend>Student Information</legend>				
						<div class="col-md-2">		
		                  	<a class="pull-left col-sm-" href="javascript:">
		                    	<img class="thumb-lg img-circle" src="<c:url value="/static/images/users/avatar-2.jpg" />" alt="">
		                    </a>
		                </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="firstName">First name:</label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" data-firstName name="firstName" id="firstName" placeholder="Enter first name">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="lastName">Last name:</label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter last name">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="kmFirstName">First name in Khmer:</label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" name="kmFirstName" id="kmFirstName" placeholder="First name in Khmer">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="kmLastName">Last name in Khmer:</label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" name="kmLastName" id="kmLastName" placeholder="Last name in Khmer">
						 		</div>
                            </div>
                        </div>	    
                        
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
						
						
                     	<div class="col-md-2">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4">Gender:</label>
                             	<div class="col-sm-8 ">
                             		<select class="btn btn-sm btn-purple" name="gender" id="gender">
                             			<option value="">--Select Gender--</option>
                             			<option value="M">Male</option>
                             			<option value="F">Female</option>
                             		</select>
						 		</div>
                            </div>
                        </div>	
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="birthDate">Date of Birth:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" name="birthDate" id="birthDate" placeholder="Enter Date of Birth">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-8">
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="birthPlace">Place of Birth:</label>
                             	<div class="col-sm-10">
                             		<textarea rows="2" cols="100" name="birthPlace" id="birthPlace" placeholder="Enter place of birth"></textarea>
						 		</div>
                            </div>
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="biography">Biography:</label>
                             	<div class="col-sm-10">
                             		<textarea rows="10" cols="100" name="biography" id="biography" placeholder="Enter biography"></textarea>
						 		</div>
                            </div>
                        </div>                        
					</fieldset>
					<fieldset>
						<legend>Contact Information</legend>
							
                     	<div class="col-md-4">
                     		<div class="form-group">
                            	<label class="control-label col-sm-6" for="phone1">Telephone 1:</label>
                             	<div class="col-sm-6">
									<input type="text" class="form-control" name="phone1" id="phone1" placeholder="Enter telephone 1">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-4">
                     		<div class="form-group">
                            	<label class="control-label col-sm-6" for="phone2">Telephone 2:</label>
                             	<div class="col-sm-6">
									<input type="text" class="form-control" name="phone2" id="phone2" placeholder="Enter telephone 2">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-4">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="email">Email Address:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" name="email" id="email" placeholder="Enter email address">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-12">
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="currentAddr">Current Address:</label>
                             	<div class="col-sm-10">
                             		<textarea rows="2" cols="100" name="currentAddr" id="currentAddr" placeholder="Enter current address"></textarea>
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
									<input type="text" class="form-control" name="motherName" id="motherName" placeholder="Enter mother's name">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="motherPhone">Mother's Telephone:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" name="motherPhone" id="motherPhone" placeholder="Enter mother's telephone">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="fatherName">Father's name:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" name="fatherName" id="fatherName" placeholder="Enter father's name">
						 		</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="fatherPhone">Father's Telephone:</label>
                             	<div class="col-sm-8">
									<input type="text" class="form-control" name="fatherPhone" id="fatherPhone" placeholder="Enter father's telephone">
						 		</div>
                            </div>
                        </div>
                        
					</fieldset>                        							 
                        <div class="clearfix"></div>
                        <input id="btnSave" type="button" class="btn btn-info " value="Save">
                        <input id="btnClear" type="button" class="btn btn-danger " value="Clear">
                        <input id="btnCancel" type="button" class="btn btn-warning " value="Cancel">
					  <!-- <button type="submit" class="btn btn-default">Submit</button> -->
					</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>

 var studentId = "${studentId}";
 var url = "school_1002_0301.act";
 var getStudentUrl = "school_1002_0302_r001.chitra/"+studentId;
 
</script>
<script type="text/x-jquery-tmpl" id="MEMO_TMPL">
	<div class="form-group" >
      	<label style="text-align:right" class="col-sm-1" for="content">Date:</label>
      	<label style="text-align:left" class="col-sm-2" for="content">{{= school.string.formatDatetime(registerDate) }}</label>
      	<label style="text-align:right" class="col-sm-1" for="content">Memo:</label>
      	<label style="text-align:left" class="col-sm-4" for="content">{{= content }}</label>
      	<label style="text-align:right" class="col-sm-2" for="content">Register Person:</label>
      	<label style="text-align:left" class="col-sm-2" for="content">{{= registerPerson }}</label>
     </div>
</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1002_0302.js" />"></script>
</template:basic>

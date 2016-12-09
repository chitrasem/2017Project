<template:basic htmlTitle="New Student" bodyTitle="People">
	<!-- ============================================================== -->
	
<input type="hidden" id="courseUrl" value="<c:url value="/dashboard/course/school_1004_0101_r001.chitra"/> "  >
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					
					 <div id="full-width-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="full-width-modalLabel" aria-hidden="true" style="display: none;">
                     <div class="modal-dialog modal-full">
                         <div class="modal-content">
                             <div class="modal-header">
                                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                 <h4 class="modal-title" id="full-width-modalLabel">ផ្លាស់ប្តូររូបថត</h4>
                             </div>
                             <div class="modal-body">
								                       
                                 <!-- The file upload form used as target for the file upload widget -->
						     <form id="fileupload" action="<c:url value="/upload/test"/>" method="POST" enctype="multipart/form-data">
						        Redirect browsers with JavaScript disabled to the origin page
						        <noscript><input type="hidden" name="redirect" value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>
						        The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload
						        <div class="row fileupload-buttonbar">
						            <div class="col-lg-7">
						                The fileinput-button span is used to style the file input field as button
						                <span class="btn btn-success fileinput-button">
						                    <i class="glyphicon glyphicon-plus"></i>
						                    <span>Add files...</span>
						                    <input type="file" name="files[]" multiple>
						                </span>
						                <button type="submit" class="btn btn-primary start">
						                    <i class="glyphicon glyphicon-upload"></i>
						                    <span>Start upload</span>
						                </button>
						                <button type="reset" class="btn btn-warning cancel">
						                    <i class="glyphicon glyphicon-ban-circle"></i>
						                    <span>Cancel upload</span>
						                </button>
						                <button type="button" class="btn btn-danger delete">
						                    <i class="glyphicon glyphicon-trash"></i>
						                    <span>Delete</span>
						                </button>
						                <input type="checkbox" class="toggle">
						                The global file processing state
						                <span class="fileupload-process"></span>
						            </div>
						            The global progress state
						            <div class="col-lg-5 fileupload-progress fade">
						                The global progress bar
						                <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
						                    <div class="progress-bar progress-bar-success" style="width:0%;"></div>
						                </div>
						                The extended global progress state
						                <div class="progress-extended">&nbsp;</div>
						            </div>
						        </div>
						        The table listing the files available for upload/download
						        <table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
						    </form> 
						    
						    
                             </div>
                             <div class="modal-footer">
                                 <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                 <button type="button" class="btn btn-primary waves-effect waves-light">Save changes</button>
                             </div>
                         </div><!-- /.modal-content -->
                     </div><!-- /.modal-dialog -->
                 </div><!-- /.modal -->
                                        
                                        
					<form class="form-horizontal" id="school_1002_0302_form">
					<fieldset>
						<legend><strong><i>Memo</i></strong></legend>
						<table class="table">
							<thead>
								<tr>
								<td>Memo</td>
								<td colspan="2">
									<input type="text" class="form-control"  name="content" id="content" placeholder="Enter memo">
								</td>
								</tr>
								
							
							</thead>
							<tbody id="MEMO_RESULT">							
							</tbody>
						</table>
                     	<!-- <div class="col-md-12">
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="content">Memo:</label>
                             	<div class="col-sm-10">
									<input type="text" class="form-control" value="សូមបង់ប្រាក់ដើប្បីចូលរៀន" name="content" id="content" placeholder="Enter memo">
						 		
						 		</div>
                            </div>
                        </div>                        
                     	<div class="col-md-12" id="MEMO_RESULT">
                        </div> -->
						<legend> <strong><i>Student Information</i></strong></legend>				
						<div class="col-md-2">		
		                  	<a class="pull-left col-sm-" href="javascript:" data-toggle="modal" data-target="#full-width-modal" >
		                    	<img class="thumb-lg img-circle" src="<c:url value="/static/images/users/avatar-2.jpg" />" alt="">
		                    </a>
		                </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="firstName">First name <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" data-firstName name="firstName" id="firstName" placeholder="Enter first name">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="lastName">Last name <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter last name">
						 		</div>
                            </div>
                        </div>
                        
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="kmFirstName">First name in Khmer <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" name="kmFirstName" id="kmFirstName" placeholder="First name in Khmer">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="kmLastName">Last name in Khmer <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" name="kmLastName" id="kmLastName" placeholder="Last name in Khmer">
						 		</div>
                            </div>
                        </div>	    
                        
		                 							 
                        <div class="clearfix"></div>
						<div style="height:10px;"></div> 
						<hr>
						
                     	<div class="col-md-2">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4">Gender <span class="text-danger">*</span></label>
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
                            	<label class="control-label col-sm-4" for="birthDate">Date of Birth <span class="text-danger">*</span></label>
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
                             		<textarea rows="5" cols="100" name="biography" id="biography" placeholder="Enter biography"></textarea>
						 		</div>
                            </div>
                        </div>                        
					</fieldset>
					<fieldset>
						<legend><strong><i>Contact Information</i></strong></legend>
							
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
						<legend> <strong><i>Family Information</i></strong></legend>
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
					
					<fieldset>
						<legend><strong><i>Course</i></strong></legend>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="sbCourse">Course <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">
                             		<select class="form-control" name="course" id="sbCourse">
                             			<option value="">Choose Course... </option>
                             			<option value="1">EIC1(2016-2017,Morning)</option>
                             		</select>
						 		</div>
						 		<div class="col-sm-1">
						 			<button title="Add Course" class="btn btn-purple waves-effect waves-light "><i class="ion ion-android-add"></i></button>
						 		</div>
                            </div>
                        </div>                    							 
                        <div class="clearfix"></div>
                        <div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="sbSession">Study Session <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">                             		
                             		<select class="form-control" name="session" id="sbSession">
                             			<option value="">Choose Session... </option>
                             			<option value="M">Morning</option>
                             			<option value="A">Afternoon</option>
                             			<option value="E">Evening</option>
                             		</select>
						 		</div>
						 		<div class="col-sm-1">
						 			<button title="Add Study Session" class="btn btn-purple waves-effect waves-light "><i class="ion ion-android-add"></i></button>
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
	<tr>
      	<td>{{= school.string.formatDatetime(registerDate) }}</td>
      	<td>{{= content }}</td>
      	<td>{{= registerPerson }}</td>
     </tr>
</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <!-- The template to display files available for download -->
	<!-- The jQuery UI widget factory, can be omitted if jQuery UI is already included -->
	<script src="<c:url value="/static/js/vendor/jquery.ui.widget.js" />"></script>
	<!-- <script src="//blueimp.github.io/JavaScript-Templates/js/tmpl.min.js"></script> -->
	<script src="<c:url value="/static/js/vendor/tmpl.min.js" />" ></script>
	
	<script src="<c:url value="/static/js/jquery.iframe-transport.js" />"> </script>
	<!-- The basic File Upload plugin -->
	<script src="<c:url value="/static/js/jquery.fileupload.js" /> "> </script>
	<!-- The File Upload processing plugin -->
	<script src="<c:url value="/static/js/jquery.fileupload-process.js" />"> </script>
	<!-- The File Upload image preview & resize plugin
	
	<!-- The File Upload user interface plugin -->
	<script src="<c:url value="/static/js/jquery.fileupload-ui.js" /> "> </script>
    <script src="<c:url value="/static/school/js/school_1002_0302.js" />"> </script>
</template:basic>

<template:basic htmlTitle="New Student" bodyTitle="People">
	<!-- ============================================================== -->
	
<input type="hidden" id="courseUrl" value="<c:url value="/dashboard/course/school_1004_0101_r001.chitra"/> "  >
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					<div  id="uploadModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" style="display: none;">
                      <!-- Modal -->
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                    <h4 class="modal-title" id="myLargeModalLabel">Large modal</h4>
                                </div>
                                <div class="modal-body">
                                <form id="fileupload" name="fileupload" action="<c:url value="/upload/test"/>" method="POST" enctype="multipart/form-data">
						     
						        <div class="row fileupload-buttonbar">
						            <div class="col-lg-7">
						                <span class="btn btn-success fileinput-button">
						                    <i class="glyphicon glyphicon-plus"></i>
						                    <span>Add files...</span>
						                    <input type="file" name="files[]" multiple data-url="<c:url value="/upload/test"/>">
						                </span>
						                <button type="submit" id="btnUpload" class="btn btn-primary start">
						                    <i class="glyphicon glyphicon-upload"></i>
						                    <span>Start upload</span>
						                </button>
						            </div>
						            <div class="col-lg-5 fileupload-progress fade">
						                <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
						                    <div class="progress-bar progress-bar-success" style="width:0%;"></div>
						                </div>
						                The extended global progress state
						                <div class="progress-extended">&nbsp;</div>
						            </div>
						        </div>
						        The table listing the files available for upload/download
						        <table role="presentation" class="table table-striped"><tbody class="files" id="fileList"></tbody></table>
						 
						   	</form> 
                            </div>
                                                       
                             <div class="modal-footer">
                                 <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                 <button type="button" class="btn btn-primary waves-effect waves-light">Save changes</button>
                             </div>
                            </div><!-- /.modal-content -->    
                        </div><!-- /.modal-dialog -->
                        
                    </div>
					
					
                                        
                                        
					<form class="form-horizontal" id="school_1002_0302_form">
					<fieldset>
						<legend><strong><i>កំណត់ចំណាំ</i></strong></legend>
						<table class="table">
							<thead>
								<tr>
								<td>កំណត់ចំណាំ</td>
								<td colspan="2">
									<input type="text" class="form-control"  name="content" id="content" placeholder="សូមវាយបញ្ចូលកំណត់ចំណាំ">
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
		                  	<a class="pull-left col-sm-" href="javascript:" data-toggle="modal" data-target="#uploadModal" >
		                    	<img id="imgPhoto" class="thumb-lg img-circle" src="<c:url value="/static/images/users/avatar-2.jpg" />" alt="">
		                    </a>
		                   <input type="hidden" name="imageName" value="/avatar-2.jpg"/>
		                   <input type="hidden" name="imageUrl" value="/static/images/users"/>
		                </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="firstName">នាមជាភាសាអង់គ្លេស <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" data-firstName name="firstName" id="firstName" placeholder="Enter first name">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="lastName">គោតនាមជាភាសាអង់គ្លេស <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter last name">
						 		</div>
                            </div>
                        </div>
                        
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="kmFirstName">នាមជាភាសាខ្មែរ <span class="text-danger">*</span></label>
                             	<div class="col-sm-7">
									<input type="text" class="form-control" name="kmFirstName" id="kmFirstName" placeholder="First name in Khmer">
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-5">
                     		<div class="form-group">
                            	<label class="control-label col-sm-5" for="kmLastName">គោតនាមជាភាសាខ្មែរ<span class="text-danger">*</span></label>
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
                            	<label class="control-label col-sm-4">ភេទ <span class="text-danger">*</span></label>
                             	<div class="col-sm-8 ">
                             		<select class="btn btn-sm btn-purple" name="gender" id="gender">
                             			<option value="">ជ្រើសរើសភេទ--</option>
                             			<option value="M">ប្រុស</option>
                             			<option value="F">ស្រី</option>
                             		</select>
						 		</div>
                            </div>
                        </div>	
                     	<div class="col-md-6">
                     		<div class="form-group">
                            	<label class="control-label col-sm-4" for="birthDate">ថ្ងៃ ខែ ឆ្នាំកំណើត <span class="text-danger">*</span></label>
                             	<div class="col-sm-8">
							 		<div class="input-group">
	                                    <input type="text" class="form-control span2" readonly="readonly" data-date-format="yyyy-mm-dd" name="birthDate" placeholder="yyyy/mm/dd" id="birthDate">
	                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
	                              
									</div>
						 		</div>
                            </div>
                        </div>
                     	<div class="col-md-8">
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="birthPlace">ទីកន្លែងកំណើត</label>
                             	<div class="col-sm-10">
                             		<textarea rows="2" cols="100" name="birthPlace" id="birthPlace" placeholder="Enter place of birth"></textarea>
						 		</div>
                            </div>
                     		<div class="form-group">
                            	<label class="control-label col-sm-2" for="biography">ការណែនាំ</label>
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
<!-- The template to display files available for upload -->
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger"></strong>
        </td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start" disabled>
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<!-- The template to display files available for download -->
<script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade">
        <td>
            <span class="preview">
                {% if (file.thumbnailUrl) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                {% } %}
            </span>
        </td>
        <td>
            <p class="name">
                {% if (file.url) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
                {% } else { %}
                    <span>{%=file.name%}</span>
                {% } %}
            </p>
            {% if (file.error) { %}
                <div><span class="label label-danger">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
            {% if (file.deleteUrl) { %}
                <button class="btn btn-danger delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" name="delete" value="1" class="toggle">
            {% } else { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>

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

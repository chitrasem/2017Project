<template:basic htmlTitle="My Students" bodyTitle="My Students">
	<div class="row font-km">
      <div class="col-md-6">
          <div class="panel panel-default">
              <div class="panel-heading">
                  <h3 class="panel-title">បញ្ចីរាយនាមសិស្ស</h3>
              </div>
              
              <div class="panel-body">              
                  <div class="media-main">                                    
                     <div class="pull-right btn-group-sm">
                         <a href="javascript:" class="btn btn-success waves-effect waves-light tooltips" data-placement="top" data-toggle="tooltip" data-original-title="Add">
                             <i class="fa fa-pencil"></i>
                         </a>
                     </div>
                     
                  <div class="row">
                      <div class="col-md-12 col-sm-12 col-xs-12">                   
                     	
                     		<fieldset>
                     			<legend>ជម្រើសនៃការស្វែងរក</legend>
                     				<div class="row"> 
						                <div class="col-md-8">							                	                    				   		
	                                        <div class="radio radio-info radio-inline">
	                                            <input type="radio" id="kmRadio" value="km" name="langRadio" checked>
	                                            <label for="kmRadio"> ភាសាខ្មែរ </label>
	                                        </div>
	                                        <div class="radio radio-info radio-inline">
	                                            <input type="radio" id="enRadio" value="en" name="langRadio">
	                                            <label for="enRadio"> English </label>
	                                        </div>
						                </div>
                     				   <div class="col-md-8">                      				   		
	                                        <div class="input-group">
							                    <input type="text" id="searchName" name="example-input1-group2" class="form-control input-sm" placeholder="ស្វែងរកតាមរយៈឈ្មោះ...">
							                    <span class="input-group-btn">
							                        <button id="btnSearchName" type="button" class="btn-sm btn waves-effect waves-light btn-primary w-md"><i class="fa fa-search"></i></button>
							                    </span>
							                </div>
                     				   </div>
                     				   <div class="alert alert-info">
                     				   	<p id="messageTyping"></p>                     				   	
                     				   <br/><br/>
									   </div>
                     				</div>
                     		</fieldset>
                     	
                          <table class="table table-hover table-striped table-bordered" id="tb_student">
                              <thead>
                              </thead>
                              <tbody>
                              </tbody>
                              <tfoot>
                              </tfoot>
                              
                          </table>
                          	<div class="group">
	                          	<nav id="pagination">
								</nav>
								<div>
									<a href="<c:url value="/dashboard/student/export"/> " class="btn active">Export all students as Excel Files</a>
								</div>
                          	
                          	</div>
                          	
                      </div>
                  </div>
              </div>
             </div>
          </div>
      </div>
      <div class="col-md-6" id="stu_infor_details" style="display:none">
      	<div class="panel">
              <div class="panel-body">
                  <div class="media-main">
                      <a class="pull-left" href="#">
                          <img class="thumb-lg img-circle" src="<c:url value="/static/images/users/avatar-2.jpg" />" alt="">
                      </a>
                      <div class="pull-right btn-group-sm">
                          <a href="#" class="btn btn-success waves-effect waves-light tooltips" data-placement="top" data-toggle="tooltip" data-original-title="Edit">
                              <i class="fa fa-pencil"></i>
                          </a>
                          <a href="#" class="btn btn-danger waves-effect waves-light tooltips" data-placement="top" data-toggle="tooltip" data-original-title="Delete">
                              <i class="fa fa-close"></i>
                          </a>
                      </div>
                      <div class="info">
                          <h4 id="info_full_name">Chitra Sem (Chitra Sem)</h4>
                          <p class="text-muted">Student</p>
                          <fieldset class="text-muted" >
                          	<legend class="text-muted">ពត៏មាន ផ្ទាល់ខ្លួន</legend>
                          	<div class="form-group">
	                          	<label class="control-label col-sm-4">ថ្ងៃ/ខែ/ឆ្នាំ កំណើត:</label>
	                          	<label class="col-sm-8" id="info_birth_date">2015/01/12<span class="អាយុ"> (១ ឆ្នាំ)</span></label>
	                        </div>
	                        <div class="form-group">
	                          	<label class="control-label col-sm-4">ភេទ:</label>
	                          	<label class="col-sm-8" id="info_gender">ប្រុស</label>
	                        </div>
	                        <div class="group">
	                          	<label class="control-label col-sm-4 text-muted">សញ្ចាតិ:</label>
	                          	<label class="col-sm-8" id="info_nationality">Cambodian</label>
	                        </div> 
	                        <div class="group">
	                          	<label class="control-label col-sm-4 text-muted">Marital status:</label>
	                          	<label class="col-sm-8" id="info_maritalstatus">Single</label>
	                        </div>            
	                        <legend class="text-muted">ទំនាក់ទំនង ពត៏មាន</legend>
                        	<div class="group">
	                          	<label class="control-label col-sm-4 text-muted">Phone number:</label>
	                          	<label class="col-sm-8" id="info_phoneNumber">086-457-324</label>
                          	</div>
                        	<div class="group">
	                          	<label class="control-label col-sm-4 text-muted">Email Address:</label>
	                          	<label class="col-sm-8" id="info_emailaddress">sabaychitra84@gmail.com</label>
                          	</div>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Home Address:</label>
	                          	<label class="col-sm-8" id="info_currentAddressr">Prey Kombot, Chom Choa, Porsenchey, Phnom Penh</label>
                          	</div>  
	                        <legend class="text-muted">ពត៏មានអំពី ឳពុក ម្តាយ​​​</legend>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Father's name:</label>
	                          	<label class="col-sm-8" id="info_fatherName">Sem Sokleang</label>
                          	</div>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Father's phone:</label>
	                          	<label class="col-sm-8" id="info_fatherPhone">012-286-944</label>
                          	</div>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Mohter's name:</label>
	                          	<label class="col-sm-8" id="info_motherName">Poa Tol</label>
                          	</div>
                        	<div class="form-group">
	                          	<label class="control-label col-sm-4 text-muted">Mother's phone:</label>
	                          	<label class="col-sm-8" id="info_motherPhone">012-286-944</label>
                          	</div>
	                        <legend>Contact Information</legend>             
                          </fieldset>
                      </div>
                  </div>
                  <div class="clearfix"></div>
                  <hr/>
                  <ul class="social-links list-inline">
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Facebook"><i class="fa fa-facebook"></i></a>
                      </li>
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Twitter"><i class="fa fa-twitter"></i></a>
                      </li>
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="LinkedIn"><i class="fa fa-linkedin"></i></a>
                      </li>
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Skype"><i class="fa fa-skype"></i></a>
                      </li>
                      <li>
                          <a title="" data-placement="top" data-toggle="tooltip" class="tooltips" href="" data-original-title="Message"><i class="fa fa-envelope-o"></i></a>
                      </li>
                  </ul>
              </div> <!-- panel-body -->
          </div> <!-- panel -->
      </div>
  </div> <!-- End Row -->
	
      <script src="<c:url value='/static/kms/js/student.js' />"></script>
</template:basic>

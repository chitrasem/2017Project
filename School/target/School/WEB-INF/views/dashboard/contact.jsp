<template:basic htmlTitle="Contact" bodyTitle="Contact">
	<!-- ============================================================== -->
	<!-- Start right Content here -->

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
      <div class="col-sm-6 col-lg-4">
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
                          <h4>Jonathan Smith</h4>
                          <p class="text-muted">Graphics Designer</p>
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
      </div> <!-- end col -->
     </div>
      <script src="<c:url value='/static/kms/js/student.js' />"></script>
</template:basic>

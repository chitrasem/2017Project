<%@page import="org.joda.time.DateTime"%>
<template:basic htmlTitle="Payment" bodyTitle="ប្រភពប្រាក់ចំណូល">
<!-- Modal Part -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="payer_modal" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
	    <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">បញ្ចីឈ្មោះសិស្ស</h4>
	      </div>
	      <div class="modal-body">
	      	<table class="table">
	      		<thead>
	      			<tr>
	      				<th>ជ្រើសរើស</th>
	      				<th>លេខសម្គាល់</th>
	      				<th>ឈ្មោះជាភាសាខ្មែរ</th>
	      				<th>ឈ្មោះជាភាសាអង់គ្លេស</th>
	      				<th>ថ្នាក់</th>
	      				<th>ថ្ងៃ/ខែ/ឆ្នាំ កំណើត</th>
	      			</tr>
	      		</thead>
	      		<tbody id="STUDENT_LIST_RESULT">
	      		</tbody>
	      	</table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">បិទ</button>
	        <button type="button" class="btn btn-default waves-effect" id="chStudent">ជ្រើសយក
	        	<i class="material-icons right"></i>
	        </button>
	      </div>
    </div>
  </div>
</div>
<!-- End Modal Part -->

	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">						
							<div class="row">							
								<div class="col-md-12">     
									<div class="pull-right">                                 
										<button id="btnDownload" type="button" class="btn btn-purple waves-effect waves-light">
											<span>ទាញយក</span> <i class="ion ion-ios7-cloud-download-outline"></i>
										</button>                               
										<button id="btnSave" type="button" class="btn btn-purple waves-effect waves-light">
											<span>រកស្សទុក</span> <i class="ion ion-checkmark-circled"></i>
										</button>      
										<button type="button" class="btn btn-purple waves-effect waves-light">
											<span>ត្រឡប់ក្រោយវិញ</span> <i class="ion ion-android-system-back"></i>
										</button> 
									</div>                              
								</div>
								<span>&nbsp;</span>
							<div class="row">
							<table class="table">
								<tbody>
									<tr>
										<th>  </th>
										<td><p class="form-control-static">អ្នកគិតលុយ(អ្នកទទួលប្រាក់)</p></td>
										<td><input disabled="disabled" class="dis form-control" value="${ user.ssoId }" type="text"/></td>
										<td>										
	          								<p class="form-control-static">សូមជ្រើសរើសអ្នកបង់ប្រាក់</p>
	          							</td>
										<td class="form-inline">
											<div class="form-group">
												<input class="form-control" data-stu-id="" data-status="" type="text" disabled="disabled" id="txtPayer" class="dis">											
											</div>											
												<input type="checkbox" name="vehicle"  id="chkPayer" class="checkbox-info" checked>	
											<button type="button" class="btn btn-default btn-sm waves-effect waves-light" data-toggle="modal" id="fnPayer" >
												<span>ស្វែងរកសិស្ស</span><i class="ion ion-android-search"></i>												
											</button>
										</td>
									</tr>
								</tbody>			
							</table>
							</div>
							<div class="row">
							<table class="table table-hover table-striped">
								<thead>
									<tr>
										<th >										
											<div class="btn-group">								    
												<button id="ADD_PAY_DTL" type="button" class="btn  form-control-staticbtn-sm btn-default waves-effect waves-light">
													<i class="ion ion-plus"></i>
												</button>
											</div>
										</th>
										<th class="text-center">ជម្រើស</th>
										<th class="text-center">បង់សម្រាប់</th>
										<th class="text-center">តម្លៃ</th>
										<th class="text-center">បញ្ចុះតម្លៃ</th>
										<th class="text-center">សរុប</th>
										<th class="text-center"></th>	
									</tr>
										
									<tr>
										<th class="text-center form-control-static" colspan="3">សរុប</th>
										<th class="text-center" id="">
											 <div class="input-group currency pull-right">
								             <span class="input-group-addon">រៀល</span>
										  	 <input type="text" class="form-control currency" id="TOT_UNIT_PRICE" disabled="disabled" value="0">
								           </div>										
										</th>
										<th class="text-center" >
											 <div class="input-group currency pull-right">
								             <span class="input-group-addon">រៀល</span>
										  	 <input type="text" class="form-control currency" id="TOT_AMT_DST" disabled="disabled" value="0">
								           </div>
										</th>
										<th class="text-center" >
										 <div class="input-group currency pull-right">
								             <span class="input-group-addon">រៀល</span>
										  	 <input type="text" class="form-control currency" id="TOT_AMT_TOTAL" disabled="disabled" value="0">
								           </div>										
										</th>																		
								          
										<td class="text-center"></td>
									</tr>	
								</thead>
								<tbody id="PAYMENT_DTL_RESULT" style="hight: 100px;">																
								</tbody>
							</table>
							
							</div>
							</div><!-- ROW -->
						</div> <!--  -->
					</div>
				</div>
			</div>
		</div>
	</div><!-- End .row -->
	<script type="text/jquery-tmpl" id="PAYMENT_DTL_TMPL"> 
		<tr>		
		<td>
			<input class="form-control-static myRadio pull-right" name="myRadio" type="radio">
		</td>
		<td>			
			<select style="width:160px;" class="form-control PAY_STATUS">
				<option>បង់ថ្លៃសាលា</option>
				<option>បង់ថ្លៃសៀវភៅ</option>
				<option>កុំព្យូទ័រ</option>
			</select>
		</td>
		<td>
			<div class="form-group">
              <div class='input-group date datetimepicker'>
                  <input type='text' value="{%= PAY_DTL_DESCR %}" class="form-control PAY_DTL_DESCR" />
                  <span class="input-group-addon">
                      <span class="glyphicon glyphicon-calendar"></span>
                  </span>
              </div>
          	</div>
		</td>
		<td>											
          <div class="input-group currency" style="text-align:right;">
             	<span class="input-group-addon">រៀល</span>
			<input  type="text" class="form-control currency UNIT_PRICE" value="{%= UNIT_PRICE %}">
           </div>
		</td>
		<td>											
           <div class="input-group currency pull-right">
             <span class="input-group-addon">រៀល</span>
		  	 <input type="text" class="form-control currency AMT_DST" value="{%= AMT_DST %}">
           </div>
		</td>
		<td>											
           <div class="input-group currency">
             <span class="input-group-addon">រៀល</span>
             <input type="text" disabled="disabled" class="form-control currency AMT_TOTAL" value="{%= AMT_TOTAL %}">
           </div>
		</td>
			<th>
				<button class="btn btn-sm btn-default waves-effect waves-light CLS_REMOVE">
					<i class="ion ion-minus"></i>
				</button>					
			</th>
		</tr>				
	</script>
	<script type="text/jquery-tmpl" id="STUDENT_LIST_TMPL">    
			<tr>
				<td><input type="radio" name="radioBtn"></td>
				<td class="STU_ID">{%= id %}</td>
				<td class="STU_NAME">{%= kmLastName %} {%= kmFirstName %}</td>
				<td class="STU_NAME_ENG">{%= lastName %} {%= firstName %}</td>
				<td>EIC5</td>
				<td>{%= birthDate %}</td>
			</tr>
	</script>
	<script type="text/jquery-tmpl" id="PAYMENT_TMPL">                                       
		<form>
			<input type="text" name>
		</form>		
	</script>
	
	<script>
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1005_0102.js"/>?<joda:format value="<%= new DateTime() %>" style="SM" />"></script>
</template:basic>
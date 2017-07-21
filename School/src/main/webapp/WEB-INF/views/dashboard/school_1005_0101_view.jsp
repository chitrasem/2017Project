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
	<!-- Modal -->
	  <div class="modal fade" id="addIncome" role="dialog">
	    <div class="modal-dialog modal-lg">	 
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title" style="font-family: Battambang;" >áááááááááá¶áááááá¼á</h4>
	        </div>
	        
	    <div class="col-md-12">
	    	<div class="col-md-3">	    
	    		<div class="row modal-body">
		    		<form class="form-horizontal">
		    			
					  <div class="form-group">
					    <label class="control-label col-sm-6" for="excRate">á¢áááá¶áááá¼ááááá¶áá</label>
					    <div class="col-sm-6">
					    	<input type="text" class="form-control" id="excRate" value="4000" name="excRate">
					    </div>
					  </div>			
					  <div class="form-group">
					    <label class="control-label col-sm-4" for="currUs">áá»áááá¶</label>
					    <div class="col-sm-8">
					    	<input type="text" class="form-control" id="currUs" value="1" name="currUs">
					    </div>
					  </div>
						<div class="form-group">							
						    <label class="control-label col-sm-4" for="currKm">ááááá</label>
						    <div class="col-sm-8">
						    	<input type="text" class="form-control" id="currKm" value="0" name="currKm">
						    </div>
						</div>
		    		</form>
	    		</div>
	    	</div>	    	
	    	<div class="col-md-1"></div>	 
	    	<div class="col-md-8">	    
	        <div class="modal-body">
				<form class="form-horizontal" id="school_1005_0101_f001">				
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="qty">áá¼ááááá¾ááá¾ááááááááááá¶áááá¼áá¼á :</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control" id="qty" value="0" name="qty">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="descr">áááááááááá (Description)</label>
				    <div class="col-sm-5">
				    	<input type="text" class="form-control" id="descr" placeholder="áá¼ááá¶áááááá¼áááááááááá·á..." name="descr">
				    </div>
				    <label class="control-label btn btn-default col-sm-2" for="descr">ááááááá·áááá¶</label>
				  </div>	
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="qty">áááá½á (Quantity)</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control" id="qty" value="0" name="qty">
				    </div>
				  </div>		
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="unitPrc">ááááááá¶á (Unit Price) ááá</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control right" id="unitPrc" value="0" name="unitPrc">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="unitPrc">ááááááá¶á (Unit Price) áá»áááá¶</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control right" id="unitPrc" value="0" name="unitPrc">
				    </div>
				  </div>	
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="amount">áááááááá»á (Amount)</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control disable" id="amount" value="0" readonly="readonly" name="amount">
				    </div>
				  </div>					  
				</form>
	        </div>	    	
	    	</div>
	    </div>   
	        <div class="modal-footer">
	          <button type="button" class="btn btn-purple" id="btnAddIncome">áááááá</button>
	          <button type="button" class="btn btn-purple" data-dismiss="modal">áááááá</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	  <!-- End Modal -->
	  
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<!-- <div class="table-responsive"> -->
						<div class="">
						   <div class="row">
						   		<div class="col-md-12">
						   		rererr
						   		</div>
						   </div>
						   <input type="hidden" name="studentId" id="studentId" value="0">
							<div class="row">							
								<div class="col-md-6">
									<div class="btn-group">														
										<button data-toggle="modal" id="payPop" data-target="#addIncome"class="btn btn-purple waves-effect waves-light">
											<i class="ion ion-plus"></i>
											<span>បន្ថែមប្រាក់ចំណូលទូរទៅ</span>
										</button>
                                      </div>	                                     		
										<div class="btn-group">	
	                                      <form id="school_1005_0102" action="school_1005_0102.act" method="GET">	 								
											<button id="btnAddPayment" class="btn btn-purple waves-effect waves-light">
												<i class="ion ion-plus"></i>
												<span>បន្ថែមនប្រាក់ចំណូលថ្លៃសិក្សា</span>
											</button>
	                                      </form>
	                                    </div>
								</div>			
							</div>					   
							<table class="table table-hover table-striped">
								<thead>
									<tr>
										<th class="text-center">
										<input type="checkbox">
										</th>
										<th class="text-center">កាលបរិច្ឆេទចុះក្នុងបញ្ចី</th>
										<th class="text-left">ប្រភេទនៃកាបង់ប្រាក់</th>
										<th class="text-left">អ្នកទទួលប្រាក់</th>
										<th class="text-left">អ្នកបង់ប្រាក់</th>
										<th class="text-right">ចំនួន</th>
										<th class="text-right">បញ្ចុះតម្លៃ</th>
										<th class="text-right">តម្លៃសរុប</th>
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
		<tr>
			<td class="text-center">
				<input type="checkbox">
				<input type="hidden" value="{%= PAY_ID %}" class="pay_id">
			</td>
			<td class="text-center">{%= school.string.formatDatetime( pay_date ) %}</td>
			<td class="text-left"><a href="javascript:" data-payment-id="{%= pay_id %}" class="pay_descr">{%= pay_descr %}</a></td>
			<td class="text-left">{%= receiver %}</td>
			<td class="text-left">{%= payer_km %}</td>
			<td class="text-right">{%= school.string.numberWithComma( count_unit ) %}</td>		
			<td class="text-right">{%= school.string.numberWithComma( pay_dtl_amt_km ) %}</td>	
			<td class="text-right">{%= school.string.numberWithComma( pay_dtl_disc ) %}</td>	
			<td class="text-right">{%= pay_dtl_amt_km - pay_dtl_disc %}</td>		
		</tr>
	</script>	
	<script>
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1005_0101.js" />"></script>
</template:basic>

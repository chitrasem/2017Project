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
	          <h4 class="modal-title" style="font-family: Battambang;" >បន្ថែមប្រាក់ចំណូល</h4>
	        </div>
	        
	    <div class="col-md-12">
	    	<div class="col-md-3">	    
	    		<div class="row modal-body">
		    		<form class="form-horizontal">
		    			
					  <div class="form-group">
					    <label class="control-label col-sm-6" for="excRate">អត្រាប្តូរប្រាក់</label>
					    <div class="col-sm-6">
					    	<input type="text" class="form-control" id="excRate" value="4000" name="excRate">
					    </div>
					  </div>			
					  <div class="form-group">
					    <label class="control-label col-sm-4" for="currUs">ដុល្លា</label>
					    <div class="col-sm-8">
					    	<input type="text" class="form-control" id="currUs" value="1" name="currUs">
					    </div>
					  </div>
						<div class="form-group">							
						    <label class="control-label col-sm-4" for="currKm">ខ្មែរ</label>
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
				    <label class="control-label col-sm-5" for="descr">ឈ្មោះទំនេញ (Description)</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control" id="descr" placeholder="សូមវាយបញ្ចូលឈ្មោះទំនិញ..." name="descr">
				    </div>
				  </div>	
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="qty">ចំនួន (Quantity)</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control" id="qty" value="0" name="qty">
				    </div>
				  </div>		
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="unitPrc">តម្លៃរាយ (Unit Price) រៀល</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control right" id="unitPrc" value="0" name="unitPrc">
				    </div>
				  </div>
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="unitPrc">តម្លៃរាយ (Unit Price) ដុល្លា</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control right" id="unitPrc" value="0" name="unitPrc">
				    </div>
				  </div>	
				  <div class="form-group">
				    <label class="control-label col-sm-5" for="amount">តម្លៃសរុប (Amount)</label>
				    <div class="col-sm-7">
				    	<input type="text" class="form-control disable" id="amount" value="0" readonly="readonly" name="amount">
				    </div>
				  </div>					  
				</form>
	        </div>	    	
	    	</div>
	    </div>   
	        <div class="modal-footer">
	          <button type="button" class="btn btn-purple" id="btnAddIncome">បន្ថែម</button>
	          <button type="button" class="btn btn-purple" data-dismiss="modal">បោះបង់</button>
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
						   <form id="school_1005_0101_form">
						   <input type="hidden" name="studentId" id="studentId" value="0">
							<div class="row">
							
								<div class="col-md-6">
									<div class="btn-group">									
										<button data-toggle="modal" id="btnAddPayment" data-target="#addIncome"class="btn btn-purple waves-effect waves-light">Add Payment</button>
                                      </div>
								</div>
							</div>
						   </form>						   
							<table class="table table-hover table-striped">
								<thead>
									<tr>
										<th class="text-center">
										<input type="checkbox">
										</th>
										<th class="text-center">កាលបរិច្ឆេទចុះក្នុងបញ្ចី</th>
										<th class="text-right">ប្រភេទទំនិញ(<span class="text-primary">Items</span>)</th>
										<th class="text-right">ចំនួន(<span class="text-primary">Q.T.Y</span>)</th>
										<th class="text-right">តម្លៃរាយ(<span class="text-primary">Unit Price</span>)</th>
										<th class="text-right">តម្លៃសរុប(<span class="text-primary">Amount</span>)</th>
										<th class="text-right">តម្លៃសរុបបង់ជាដុល្លា</th>
										<th class="text-right">តម្លៃសរុបបង់ជារៀល</th>
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
				<input type="hidden" value="{%= paymentId %}" class="PAYMENT_ID">
			</td>
			<td class="text-center">{%= school.string.formatDatetime( transactionDate ) %}</td>
			<td class="text-center"><a href="javascript:" data-payment-id="{%= id %}" class="descr">{%= description %}</a></td>
			<td class="text-right">{%= school.string.numberWithComma( "1" ) %}</td>
			<td class="text-right">{%= school.string.numberWithComma( amountUs ) %}</td>
			<td class="text-right">{%= school.string.numberWithComma( "100000") %}</td>
			<td class="text-right">{%= school.string.numberWithComma( amountUs ) %} <span class="text-primary">ដុល្លា</span></td>
			<td class="text-right">{%= school.string.numberWithComma( amountKm ) %} <span class="text-primary">រៀល</span></td>			
		</tr>
	</script>	
	<script>
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1005_0101.js" />"></script>
</template:basic>

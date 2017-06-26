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
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<!-- <div class="table-responsive"> -->
						<div class="">
						   <form id="school_1005_0101_form" name="school_1002_0301_form" action="<c:url value="/dashboard/payment/school_1005_0102.act"/>" method="post">
						   <input type="hidden" name="studentId" id="studentId" value="0">
							<div class="row">
								<div class="col-md-6">
									<div class="btn-group">
									
										<button id="btnAddPayment" class="btn btn-purple">Add Payment</button>
                                          <!-- <button type="button" id="actionPayment" class="btn btn-success dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">Actions 
                                          <span class="caret"></span>
                                          </button>
                                          <ul class="dropdown-menu" role="menu">
                                          </ul> -->
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
				<input type="hidden" value="{{= paymentId }}" class="PAYMENT_ID">
			</td>
			<td class="text-center">{{= school.string.formatDatetime( transactionDate ) }}</td>
			<td class="text-center">{{= description }}</td>
			<td class="text-right">{{= school.string.numberWithComma( "1" ) }}</td>
			<td class="text-right">{{= school.string.numberWithComma( amountUs ) }}</td>
			<td class="text-right">{{= school.string.numberWithComma( "100000") }}</td>
			<td class="text-right">{{= school.string.numberWithComma( amountUs ) }} <span class="text-primary">ដុល្លា</span></td>
			<td class="text-right">{{= school.string.numberWithComma( amountKm ) }} <span class="text-primary">រៀល</span></td>			
		</tr>
	</script>	
	<script>
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1005_0101.js" />"></script>
</template:basic>

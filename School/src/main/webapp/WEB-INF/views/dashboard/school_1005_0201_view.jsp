<template:basic htmlTitle="Students" bodyTitle="People">
	<!-- Searching*********************************************************************** -->
	       	<div class="row">                        
	    <div class="col-lg-12">
	        <div class="panel panel-default">
	            <div class="panel-body">	
	            <table class="table">
	            	<tr>
	            		<td>	            			            
							<div class="form-group">
				              <div class='input-group'>				              		
								  <select class="selectpicker form-control" style="width:80px;" id="proYear">
								  </select>
				              </div>
				          	</div>
	            		</td>
	            		<td>	            			            
							<div class="form-group">
				              <div class='input-group datetimepickerYYYYMMDD'>
				                  <input type='text' value="" class="form-control dt_yyyymmdd" />
				                  <span class="input-group-addon">
				                      <span class="glyphicon glyphicon-calendar">ClassRoom</span>
				                  </span>
				              </div>
				          	</div>
	            		</td>
	            	</tr>
	            </table>
	              
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
						   <div class="row">
						   		<div class="col-md-12">
						   		</div>
						   </div>
						   <input type="hidden" name="studentId" id="studentId" value="0">
							<div class="row">							
								<div class="col-md-6">
									<div class="btn-group">														
										<button data-toggle="modal" id="payPop" data-target="#addIncome"class="btn btn-purple waves-effect waves-light">
											<i class="ion ion-plus"></i>
											<span>aa</span>
										</button>
                                      </div>	                                     		
										<div class="btn-group">	
	                                      <form id="school_1005_0102" action="school_1005_0102.act" method="GET">	 								
											<button id="btnAddPayment" class="btn btn-purple waves-effect waves-light">
												<i class="ion ion-plus"></i>
												<span>aa</span>
											</button>
	                                      </form>
	                                    </div>
								</div>			
							</div>					   
							<table class="table table-bordered table-hover table-striped row-border order-column" cellspacing="0" width="100%" id="dtTable">
								<thead id="PAYMENT_TOT_RESULT">
									<tr>
										<th class="text-left text-middle" rowspan="2">អត្ថលេខ</th>
										<th class="text-left"  rowspan="2">KhmerName</th>
										<th class="text-left" rowspan="2">EnglishName</th>
										<th class="text-center" rowspan="2">ភេទ</th>
										<th colspan="3" class="text-center">
											<span>សរុបប្រចាំឆ្នាំ</span>
										</th>
										<th colspan="3" class="text-center">
											<span>ខែមករា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>កុម្ភៈ</span>
										</th>
										<th colspan="3" class="text-center">
											<span>មិនា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>មេសា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>ឧសភា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>មិថុនា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>កក្កដា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>សីហា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>កញ្ញា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>តុលា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>វិច្ឆិកា</span>
										</th>
										<th colspan="3" class="text-center">
											<span>ឆ្នូ</span>
										</th>
									</tr>
									<tr>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
									
										<th class="text-right">AmountIncome</th>
										<th class="text-right">DiscountAmount</th>
										<th class="text-right">RemainAmount</th>
										
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
	<script type="text/jquery-tmpl" id="PAYMENT_TOT_TMPL">
	 {%if status == "2"%}
		<tr>
			<td colspan="4" class="text-center">សរុប</td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_yyyy_tot ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_yyyy_tot ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( sum_amt_tot ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_jan ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_jan ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_jan ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_feb ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_feb ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_feb ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_mar ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_mar ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_mar ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_apr ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_apr ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_apr ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_may ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_may ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_may ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_jun ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_jun ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_jun ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_jul ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_jul ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_jul ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_aug ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_aug ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_aug ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_sep ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_sep ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_sep ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_oct ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_oct ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_oct ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_nov ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_nov ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_nov ) %} <span> &#6107;</span></td>

	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_dec ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_dec ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_dec ) %} <span> &#6107;</span></td>
		</tr>	
	  {%/if%}
	</script>
	<script type="text/jquery-tmpl" id="PAYMENT_TMPL">
	 {%if status == "1"%}
		<tr>
			<td>{%= student_id %}</td>
			<td class="text-left">{%= full_name_km %}</td>
			<td class="text-left"><span>{%= full_name_en %}</span></td>
			<td class="text-center">{%if gender == "F"%}ស្រី{%else%}ប្រុស{%/if%}</td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_yyyy_tot ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_yyyy_tot ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( sum_amt_tot ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_jan ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_jan ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_jan ) %} <span> &#6107;</span></td>
			{%if amt_mm_jan == "" %}
				<td class="bg-danger"></td>
				<td class="bg-danger"></td>
				<td class="bg-danger"></td>				
				{%else%}
				<td class="text-right">{%= school.string.numberWithComma( amt_mm_feb ) %} <span> &#6107;</span></td>	
				<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_feb ) %} <span> &#6107;</span></td>	
				<td class="text-right">{%= school.string.numberWithComma( tot_mm_feb ) %} <span> &#6107;</span></td>
			{%/if %}
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_mar ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_mar ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_mar ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_apr ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_apr ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_apr ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_may ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_may ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_may ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_jun ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_jun ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_jun ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_jul ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_jul ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_jul ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_aug ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_aug ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_aug ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_sep ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_sep ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_sep ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_oct ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_oct ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_oct ) %} <span> &#6107;</span></td>
	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_nov ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_nov ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_nov ) %} <span> &#6107;</span></td>

	
			<td class="text-right">{%= school.string.numberWithComma( amt_mm_dec ) %} <span> &#6107;</span></td>	
			<td class="text-right"  class="dt_yyyymm">{%= school.string.numberWithComma( disc_mm_dec ) %} <span> &#6107;</span></td>	
			<td class="text-right">{%= school.string.numberWithComma( tot_mm_dec ) %} <span> &#6107;</span></td>
		</tr>	
	  {%/if%}
	</script>	
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1005_0201.js" />"></script>
</template:basic>

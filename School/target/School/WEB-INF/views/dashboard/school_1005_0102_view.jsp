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
		<div class="col-lg-6">
			<div class="col-md-6">
               <div class="form-group">
                   <label class="control-label col-sm-4" for="payType">Type:</label>
                    <div class="col-sm-8">
                    	<select id="payType" class="btn btn-pink btn-sm">
							<option value="">Choose...</option>
							<option value="income">Income</option>
							<option value="expense">Expense</option>
						</select>
			 		</div>
                </div>
             </div>
             
			<div id="resultMethod"></div>
		</div>
		<div class="col-lg-6">
		Book
		</div>
	</div>
	<script type="text/jquery-tmpl" id="PAYMENT_TMPL">                                       
		
		
	</script>
	
	<script>
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1005_0102.js" />"></script>
</template:basic>

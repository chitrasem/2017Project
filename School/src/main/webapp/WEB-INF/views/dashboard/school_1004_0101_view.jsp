<template:basic htmlTitle="Classroom" bodyTitle="បន្ទប់រៀន">
<!-- Modal Part -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" id="classroom_modal" role="dialog" aria-labelledby="classroom_modal">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
	    <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">បន្ថែមបន្ទប់រៀន</h4>
	      </div>
	      <div class="modal-body">
	      	<table class="table">
	      			<tr class="trBg" >
	      				<th class="text-right text-default form-control-static">បន្ទប់៖</th>
						<td class="text-center">
							 <div class="input-group">
							  	 <input type="text" class="form-control">
				           </div>										
						</td>
	      				<th class="text-right text-default form-control-static">កំរិតថ្នាក់៖</th>
						<td class="text-left">
							 <div class="input-group">							 		
					           <select style="width:160px;" class="form-control PAY_STATUS">
									<option>បង់ថ្លៃសាលា</option>
									<option>បង់ថ្លៃសៀវភៅ</option>
									<option>ជំនួយកុំព្យូទ័រ</option>
									<option>ផ្សេងៗ</option>
								</select>
								&nbsp;
								<button class="btn btn-default waves-effect waves-light">
								<i class="ion ion-plus"></i>
							</button>
				            </div>								
						</td>	
	      			</tr>
	      			<tr class="trBg">	      									
	      				<th class="text-right text-default form-control-static">កំរិតថ្នាក់៖</th>
						<td class="text-left">
							 <div class="input-group">							 		
					           <select style="width:160px;" class="form-control PAY_STATUS">
									<option>បង់ថ្លៃសាលា</option>
									<option>បង់ថ្លៃសៀវភៅ</option>
									<option>ជំនួយកុំព្យូទ័រ</option>
									<option>ផ្សេងៗ</option>
								</select>
								&nbsp;
								<button class="btn btn-default waves-effect waves-light">
								<i class="ion ion-plus"></i>
							</button>
				            </div>								
						</td>    									
	      				<th class="text-right text-default form-control-static">កំរិតថ្នាក់៖</th>
						<td class="text-left">
							 <div class="input-group">							 		
					           <select style="width:160px;" class="form-control PAY_STATUS">
									<option>បង់ថ្លៃសាលា</option>
									<option>បង់ថ្លៃសៀវភៅ</option>
									<option>ជំនួយកុំព្យូទ័រ</option>
									<option>ផ្សេងៗ</option>
								</select>
								&nbsp;
								<button class="btn btn-default waves-effect waves-light">
								<i class="ion ion-plus"></i>
							</button>
				            </div>								
						</td>
	      			</tr>
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
<input id="STUDENT-URL" type="hidden" value="<c:url value="/dashboard/people/school_1002_0302_r002.chitra"/> ">
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="row">                                   
						<button id="btnAdd" type="button" class="btn btn-purple waves-effect waves-light" data-toggle="modal">
							<i class="ion ion-plus-round"></i>
						</button>      
						<button id="btnDownload" type="button" class="btn btn-purple waves-effect waves-light" >
							<i class="ion ion-ios7-cloud-download"></i>
						</button>  
					</div>
					<table class="table table-hover table-striped">
						<thead>
						<tr>			
						<th class="">បន្ទប់</th>
						<th class="">កំរិតថ្នាក់</th>
						<th class="">ឆ្នាំសិក្សា</th>
						<th class="">ចំនួនសិស្ស</th>
						<th class="">គ្រូបង្រៀន</th>
						<th class="col-md- ">វេន</th>
						</tr>
						</thead>
						<tbody id="CLSROOM-RESULT">
							<tr>
								<td>10A</td>
								<td>10</td>
								<td>2016-2017</td>
								<td>50</td>
								<td>Sem Chitra</td>
								<td>ព្រឹក</td>							
							</tr>
							<tr>
								<td>10B</td>
								<td>10</td>
								<td>2016-2017</td>
								<td>50</td>
								<td>Sem Chitra</td>
								<td>រសៀល</td>							
							</tr>
							<tr>
								<td>10C</td>
								<td>10</td>
								<td>2016-2017</td>
								<td>50</td>
								<td>Sem Chitra</td>
								<td>ល្ងាច</td>							
							</tr>						
						</tbody>						
					</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script id="CLSROOM-TMPL" type="text/jquery-tmpl">
	<tr>
		
		<td class="CLSROOM-ID">{{= id }}</td>
		<td>{{= classroom }}</td>
		<td><a href="javascript:" class="list-students"><span class="ion text-purple ion-chevron-down"></span></a></td>
	</tr>
	<tr style="display:none;" class="show-students">
		<td colspan="3">
		<div style="height:500px;">
		  <table class="table table-hover table-striped">
			<thead>
				<tr>
					<th class="col-md-2 ">STUDENT ID</th>
					<th class="col-m4-4 ">Khmer Name</th>
					<th class="col-md-4 ">English Name</th>
					<th class="col-md-2 ">
						<button class="btn btn-xs btn-purple waves-effect waves-light m-b-5">
							 <span>Download Excel</span> <i class="fa  fa-file-excel-o"></i> 
						</button>
					</th>
				</tr>
			</thead>
			<tbody class="STUDENTS-RESULT" height:1200px>
			</tbody>
			<tfoot style="display:none">
				<tr>
					<td colspan="4" align="center">There is no data!</td>
				</tr>
			</tfoot>
		</table>
		<div class="group">
	       <nav class="STUDENTS-PAGING">
			</nav>
        </div>
	  </td>
	</tr>

</script>
 <script type="text/jquery-tmpl" id="STUDENTS_TMPL">

		<tr>
			<td>{{= id }}</td>
			<td>{{= kmLastName }} {{= kmFirstName }}</td>
			<td>{{= firstName }} {{= lastName }}</td>
			<td>
				
			</td>
		</tr>

 </script>
<%@include file="../../views/dashboard/footer.jsp" %>
<script src="<c:url value="/static/school/js/school_1004_0101.js" />"></script>
</template:basic>

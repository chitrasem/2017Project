<template:basic htmlTitle="Classroom" bodyTitle="បន្ទប់រៀន">
<!-- Modal Part -->
<div class="modal fade " tabindex="-1" id="classroom_modal" role="dialog" aria-labelledby="classroom_modal">
  <div class="modal-dialog " role="document">
    <div class="modal-content">
	    <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">បន្ថែមកំរិត</h4>
	      </div>
	      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="grade" class="control-label">កម្រិត:</label>
            <input type="text" name="grade" class="form-control" id="grade">
          </div>
          <div class="form-group">
            <label for="descr" class="control-label">ពិពណ៌នា:</label>
            <input type="text" name="descr" class="form-control" id="descr">
          </div>
        </form>
        <div>        	                                 
		<button id="" type="button" class="btn btn-purple waves-effect waves-light" data-toggle="modal">
			<i class="ion ion-plus-round"></i>
		</button> 
        </div>
	      <table class="table table-strip">
	      	<thead>
	      		<tr>
	      			<th>កម្រិត</th>
	      			<th>ពិពណ៌នា</th>
	      			<th>កាលបរិច្ឆេទបន្ថែម</th>
	      			<th>អ្នកបន្ថែម</th>
	      		</tr>
	      	</thead>
	      	<tbody id="GRADE_RESULT">
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
						<th class="" >បន្ទប់</th>
						<th class="">កំរិតថ្នាក់</th>
						<th class="" style="width:177px;">ឆ្នាំសិក្សា</th>
						<th class="" style="width:85px;">ចំនួនសិស្ស</th>
						<th class="">គ្រូបង្រៀន</th>
						<th class="col-md- ">វេន</th>
						<th class="" style="width:103px;">ជម្រើស</th>
						</tr>
						<tr style="background: #A0A0A0">
							<th>
							<input type="text" class="form-control">
							</th>
							<th>		
								<div class="input-group">							
								<select class="form-control">
									<option>Grade 12</option>
									<option>Grade 12</option>
									<option>Grade 12</option>
								</select>								
								<div class="input-group-btn">
									<button id="addGrade" class=" btn waves-effect waves-light btn-primary"><i class="ion ion-plus"></i></button>
								</div>
								</div>
							</th>
							<th>		
							<div class="input-group">																
								<select class="form-control">
									<option>2016-2017</option>
									<option>2015-2016</option>
									<option>2014-2015</option>
								</select>									
								<div class="input-group-btn">
									<button class=" btn waves-effect waves-light btn-primary"><i class="ion ion-plus"></i></button>
								</div>
							</div>					
							</th>								
							<th></th>
							<th>
							<div class="input-group">
								<input type="text" class="form-control" disabled="disabled">								
								<div class="input-group-btn">
									<button class=" btn waves-effect waves-light btn-primary"><i class="ion ion-search"></i></button>
								</div>
							</div>					
							
							</th>
							<th>		
							<div class="input-group">															
								<select class="form-control">
									<option>ព្រឹក</option>
									<option>រសៀល</option>
									<option>ល្ងាច</option>
								</select>
								<div class="input-group-btn">
									<button class=" btn waves-effect waves-light btn-primary"><i class="ion ion-plus"></i></button>
								</div>
							</div>	
							</th>				
							<th>
								<button class="btn waves-effect waves-light btn-purple"><i class="glyphicon glyphicon-search"></i></button>
								<button class="btn waves-effect waves-light btn-purple"><i class="glyphicon glyphicon-floppy-save"></i></button>
							</th>			
						</tr>
						</thead>
						<tbody id="CLSROOM-RESULT">
							<tr>
								<td>10B</td>
								<td>10</td>		
								<td>2016-2017</td>		
								<td class="text-right">50</td>
								<td>Sem Chitra</td>
								<td>រសៀល</td>			
								<td></td>				
							</tr>
							<tr>
								<td>10C</td>
								<td>10</td>		
								<td>2016-2017</td>	
								<td class="text-right">50</td>
								<td>Sem Chitra</td>
								<td>ល្ងាច</td>			
								<td></td>								
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
		
		<td class="CLSROOM-ID">{%= id %}</td>
		<td>{%= classroom %}</td>
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
 <script type="text/jquery-tmpl" id="GRADE_TMPL">
		<tr>
			<td>{%= name %}</td>
			<td>{%= descr %}</td>
			<td>{%= reg_dt %}</td>
			<td>{%= reg_nm %}</td>	
			</td>
		</tr>
 </script>
 <script type="text/jquery-tmpl" id="STUDENTS_TMPL">
		<tr>
			<td>{%= id %}</td>
			<td>{%= kmLastName %} {%= kmFirstName %}</td>
			<td>{%= firstName %} {%= lastName %}</td>
			<td>				
			</td>
		</tr>
 </script>
<%@include file="../../views/dashboard/footer.jsp" %>
<script src="<c:url value="/static/school/js/school_1004_0101.js" />"></script>
</template:basic>

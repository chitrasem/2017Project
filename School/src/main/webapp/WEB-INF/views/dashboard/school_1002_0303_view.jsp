<template:basic htmlTitle="View Profile" bodyTitle="Profile">
	<!-- ============================================================== -->
<div class="row">
	<div class="col-md-12">
		<div class="row">
		</div>	
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
								 
                        <div class="clearfix"></div>
                        <input id="btnEdit" type="button" class="btn btn-info " value="Edit">
                        <input id="btnClear" type="button" class="btn btn-danger " value="Back">
                        
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<input type="hidden" id="viewURL" value="<c:url value="/dashboard/people/school_1002_0302_r001.chitra/"/> ">
<%-- <input type="hidden" id="editURL" value="<c:url value="/dashboard/people/school_1002_0302.chitra/"/> "> --%>
<form id="school_1002_0302_form" action="<c:url value="/dashboard/people/school_1002_0302.act/"/> " method="post">
	<input type="hidden" name="studentId" value="${ studentId }">
</form>
<script>

 var studentId = "${studentId}";
 var viewURL = $("#viewURL").val()+studentId;
/*  var editURL = $("#editURL").val()+studentId;  */
 
</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1002_0303.js" />"> </script>
</template:basic>

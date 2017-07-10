<template:basic htmlTitle="Students" bodyTitle="ប្រភពប្រាក់ចំណូល">
	<div class="row">
		<div class="col-lg-12">
			<table class="table">
				<thead></thead>
				<tbody>
					<tr>
						<td>កាលបរិច្ឆេទ</td>
						<td><input type="text"/></td>
						<td>អ្នកគិតលុយ(អ្នកទទួលប្រាក់)</td>
						<td><input disabled="disabled" class="dis" value="${ user.ssoId }" type="text"/></td>
					</tr>
					<tr>
						<td>សូមជ្រើសរើសអ្នកបង់ប្រាក់</td>
						<td>
							<input type="text" disabled="disabled" class="dis">
							<input type="checkbox" name="vehicle" value="Car" checked>
							<a href="javascript:">ស្វែងរកសិស្ស</a>
						</td>
						<td>ជ្រើសរើសសិស្ស</td>
						<td><input type="text"/></td>
					</tr>
				</tbody>
				
			</table>
			
		</div>
	</div>
	<script type="text/jquery-tmpl" id="PAYMENT_TMPL">                                       
		<form>
			<input type="text" name>
		</form>		
	</script>
	
	<script>
	</script>
    <%@include file="../../views/dashboard/footer.jsp" %>
    <script src="<c:url value="/static/school/js/school_1005_0102.js" />"></script>
</template:basic>

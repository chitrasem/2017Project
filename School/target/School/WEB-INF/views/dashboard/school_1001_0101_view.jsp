<template:basic htmlTitle="Dashboard" bodyTitle="Dashboard"> 
 <div class="row" id="APP_RESULT">
 </div>
 <script type="text/jquery-tmpl" id="APP_TMPL">
 </div>
  <div class="col-md-6 col-sm-6 col-lg-3">
         <div class="mini-stat clearfix bx-shadow">
             <a class="{{= classMini }}" href="<c:url value="{{= url }}"/>"><i class="{{= classIcon }}"></i></a>
             <div class="mini-stat-info text-right text-muted">
                 <span class="counter">5210</span>
                 New Users
             </div>
             <div class="tiles-progress">
                 <div class="m-t-20">
                     <h5 class="text-uppercase">{{= name }} <span class="pull-right">57%</span></h5>
                     <div class="progress progress-sm m-0">
                         <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="57" aria-valuemin="0" aria-valuemax="100" style="width: 57%;">
                             <span class="sr-only">57% Complete</span>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
     </div>
 </script>
		

<%@include file="../../views/dashboard/footer.jsp" %>    
<script src="<c:url value="/static/school/js/school_1001_0101.js" />"></script>

</template:basic>


<template:basic htmlTitle="Profile" bodyTitle="Profile">
<!-- Custom Modals -->
 <div class="row">
     <div class="col-md-12">
         <div class="panel panel-default">
             <div class="panel-body"> 
                 <!-- sample modal content -->            


                 <div id="panel-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                     <div class="modal-dialog">
                         <div class="modal-content p-0 b-0">
                             <div class="panel panel-color panel-primary">
                                 <div class="panel-heading"> 
                                     <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> 
                                     <h3 class="panel-title">Panel Primary</h3> 
                                 </div> 
                                 <div class="panel-body"> 
                                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p> 
                                 </div> 
                             </div>
                         </div><!-- /.modal-content -->
                     </div><!-- /.modal-dialog -->
                 </div><!-- /.modal -->
                 <button class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-target="#panel-modal">Panel in Modal</button>

             </div>
         </div>
     </div>
 </div> <!-- End row -->
</template:basic>
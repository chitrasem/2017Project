<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="headContent" fragment="true" required="false" %>
<%@ attribute name="navigationContent" fragment="true" required="true" %>
<%@ include file="/WEB-INF/views/base.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <title>KMS || <c:out value="${fn:trim(htmlTitle)}" /></title>
        
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <link rel="shortcut icon" href="<c:url value="/static/images/favicon_1.ico" />">

        <!-- Base Css Files -->
        <link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet" />

        <!-- Font Icons -->
        <link href="<c:url value="/static/assets/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" />
        <link href="<c:url value="/static/assets/ionicon/css/ionicons.min.css" />" rel="stylesheet" />
        <link href="<c:url value="/static/css/material-design-iconic-font.min.css" />" rel="stylesheet">

        <!-- animate css -->
        <link href="<c:url value="/static/css/animate.css" />" rel="stylesheet" />

        <!-- Waves-effect -->
        <link href="<c:url value="/static/css/waves-effect.css" />" rel="stylesheet">
        
        <!-- sweet alerts -->
        <link href="<c:url value="/static/assets/sweet-alert/sweet-alert.min.css" />" rel="stylesheet">

		<!--calendar css-->
        <link href="<c:url value="/static/assets/fullcalendar/fullcalendar.css" />" rel="stylesheet" />
        <link href="<c:url value="/static/assets/select2/select2.css" />" rel="stylesheet" type="text/css" />
        
        <!-- Custom Files -->
        <link href="<c:url value="/static/css/helper.css" />" rel="stylesheet" type="text/css" />
        <link href="<c:url value="/static/css/style.css" />" rel="stylesheet" type="text/css" />
        
        <link href="<c:url value="/static/kms/css/kms.css" />" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="<c:url value="/static/js/modernizr.min.js" />"></script>
        <script src="<c:url value="/static/js/jquery.min.js" />"></script>
        <jsp:invoke fragment="headContent" />
    </head>
    <body class="fixed-left">
    <!-- Begin page -->
        <div id="wrapper">
        
            <!-- Top Bar Start -->
            <div class="topbar">
                <!-- LOGO -->
                <div class="topbar-left">
                    <div class="text-center">
                        <a href="<c:url value="/"/>" class="logo"><i class="md md-terrain"></i> <span>School </span></a>
                    </div>
                </div>
                <!-- Button mobile view to collapse sidebar menu -->
                <div class="navbar navbar-default" role="navigation">
                    <div class="container">
                        <div class="">
                            <div class="pull-left">
                                <button class="button-menu-mobile open-left">
                                    <i class="fa fa-bars"></i>
                                </button>
                                <span class="clearfix"></span>
                            </div>
                            <div class="navbar-form pull-left" >                            
                            
							
									
                                <div class="form-group">
                                    <input type="text" id="searchName" class="form-control search-bar" placeholder="Type here for search...">
									<a href="javascript:" class="right-bar-toggle waves-effect waves-light"><i class="ion-arrow-down-b"></i></a>
                               
                                </div>
                                <button type="button" class="btn btn-sm btn-primary"><i class="fa fa-search"></i></button>
                            </div>

                            <ul class="nav navbar-nav navbar-right pull-right">
                                <li class="dropdown hidden-xs">
                                    <a href="#" data-target="#" class="dropdown-toggle waves-effect waves-light" data-toggle="dropdown" aria-expanded="true">
                                        <i class="md md-notifications"></i> <span class="badge badge-xs badge-danger">3</span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu-lg">
                                        <li class="text-center notifi-title">Notification</li>
                                        <li class="list-group">
                                           <!-- list item-->
                                           <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left">
                                                    <em class="fa fa-user-plus fa-2x text-info"></em>
                                                 </div>
                                                 <div class="media-body clearfix">
                                                    <div class="media-heading">New user registered</div>
                                                    <p class="m-0">
                                                       <small>You have 10 unread messages</small>
                                                    </p>
                                                 </div>
                                              </div>
                                           </a>
                                           <!-- list item-->
                                            <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left">
                                                    <em class="fa fa-diamond fa-2x text-primary"></em>
                                                 </div>
                                                 <div class="media-body clearfix">
                                                    <div class="media-heading">New settings</div>
                                                    <p class="m-0">
                                                       <small>There are new settings available</small>
                                                    </p>
                                                 </div>
                                              </div>
                                            </a>
                                            <!-- list item-->
                                            <a href="javascript:void(0);" class="list-group-item">
                                              <div class="media">
                                                 <div class="pull-left">
                                                    <em class="fa fa-bell-o fa-2x text-danger"></em>
                                                 </div>
                                                 <div class="media-body clearfix">
                                                    <div class="media-heading">Updates</div>
                                                    <p class="m-0">
                                                       <small>There are
                                                          <span class="text-primary">2</span> new updates available</small>
                                                    </p>
                                                 </div>
                                              </div>
                                            </a>
                                           <!-- last list item -->
                                            <a href="javascript:void(0);" class="list-group-item">
                                              <small>See all notifications</small>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="hidden-xs">
                                    <a href="#" id="btn-fullscreen" class="waves-effect waves-light"><i class="md md-crop-free"></i></a>
                                </li>
                              <!--   <li class="hidden-xs">
                                    <a href="#" class="right-bar-toggle waves-effect waves-light"><i class="md md-chat"></i></a>
                                </li> -->
                                <li class="dropdown">
                                    <a href="" class="dropdown-toggle profile" data-toggle="dropdown" aria-expanded="true"><img src="<c:url value="/static/images/avatar-1.jpg" />" alt="user-img" class="img-circle"> </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="<c:url value="/admin/profile" />"><i class="md md-face-unlock"></i> Profile</a></li>
                                        <li><a href="javascript:void(0)"><i class="md md-settings"></i> Settings</a></li>
                                        <li><a href="javascript:void(0)"><i class="md md-lock"></i> Lock screen</a></li>
                                        <li> <a href="<c:url value="/logout" /> "> <i class="md md-settings-power"></i> Logout</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                </div>
            </div>
            <!-- Top Bar End -->


            <!-- ========== Left Sidebar Start ========== -->
            <jsp:invoke fragment="navigationContent" />            
            <!-- Left Sidebar End --> 
            

            <!-- Right Sidebar -->
            <div class="side-bar right-bar nicescroll">
                <h4 class="text-center">Advance Search</h4>
                <div class="contact-list nicescroll">
                    <ul class="list-group contacts-list">
                        <li class="list-group-item">
                            <input type="text">
                            <span class="clearfix"></span>
                        </li>
                    </ul>  
                </div>
            </div>
            <!-- /Right-bar -->            
            



            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->                      
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container">

                        <!-- Page-Title -->
                        <div class="row">
                            <div class="col-sm-12">
                                <h4 class="pull-left page-title"><c:out value="${fn:trim(bodyTitle)}" /></h4>
                                <%-- <ol class="breadcrumb pull-right">
                                    <li><a href="#">Moltran <c:out value="${fn:trim(bodyTitle)}" /></a></li>
                                    <li><a href="#">Pages <c:out value="${fn:trim(bodyTitle)}" /></a></li>
                                    <li class="active">Blank Page <c:out value="${fn:trim(bodyTitle)}" /></li>
                                </ol> --%>
                            </div>
                        </div>
                        
                        <jsp:doBody />
                        
                        

                        <!-- Pls Remove -->
                        <!-- <div style="height:600px;"></div> -->
                       


                    </div> <!-- container -->
                               
                </div> <!-- content -->

                <footer class="footer text-right">
                    2015 � Moltran.
                </footer>

            </div>




        </div>
        <!-- END wrapper -->
    </body>
</html>

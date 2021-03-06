<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="extraHeadContent" fragment="true" required="false" %>
<%@ attribute name="extraNavigationContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/views/base.jspf" %>
<template:main htmlTitle="${htmlTitle}" bodyTitle="${bodyTitle}">
    <jsp:attribute name="headContent">
        <jsp:invoke fragment="extraHeadContent" />
    </jsp:attribute>
    <jsp:attribute name="navigationContent">
    <div class="left side-menu">
                <div class="sidebar-inner slimscrollleft">
                    <!--- Divider -->
                    <div id="sidebar-menu">
                        <ul>
                            <li>
                                <a href="<c:url value="/dashboard/school_1001_0101.act"/>" class="waves-effect"><i class="md md-home"></i><span> Dashboard </span></a>
                            </li>
                            
                             <li class="has_sub">
                                <a href="<c:url value="/school_1002_0101.act"/>" class="waves-effect"><i class="md md-people"></i><span> People </span><span class="pull-right"><i class="md md-add"></i></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<c:url value="/dashboard/people/school_1002_0101.act"/>">Manage Users</a></li>
                                    <li><a href="<c:url value="/dashboard/people/school_1002_0201.act"/>">Manage Teachers</a></li>
                                    <li><a href="<c:url value="/dashboard/people/school_1002_0301.act"/>">Manage Students</a></li>
                                </ul>
                            </li>                              
                            
                            <li>
                                <a href="<c:url value="/dashboard/contact/school_1003_0101.act"/>" class="waves-effect"><i class="md md-contacts"></i><span> Contact List </span></a>
                            </li>                                                 
                            <li>
                                <a href="<c:url value="/dashboard/classroom/school_1004_0101.act"/>" class="waves-effect"><i class="md md-event"></i><span> Classroom </span></a>
                            </li>       
                             <li class="has_sub">
                                <a href="<c:url value="/dashboard/payment/school_1005_0101.act"/>" class="waves-effect"><i class="md md-attach-money"></i><span> Payment </span><span class="pull-right"><i class="md md-add"></i></span></a>
                                <ul class="list-unstyled">
                                    <li><a href="<c:url value="/dashboard/payment/school_1005_0101.act"/>">Income</a></li>
                                    <li><a href="<c:url value="/dashboard/payment/school_1005_0201.act"/>">School Fee List</a></li>
                                    <li><a href="<c:url value="/dashboard/payment/school_1005_0301.act"/>">Expense</a></li>
                                </ul>
                            </li>                         
                            <li>
                                <a href="<c:url value="/dashboard/attendance/school_1006_0101.act"/>" class="waves-effect"><i class="md md-contacts"></i><span> Attendance </span></a>
                            </li>
                            <sec:authorize access="hasRole('DIRECTOR')">
                            <li>
                                <a href="<c:url value="/dashboard/users"/>" class="waves-effect"><i class="md md-people"></i><span> Users </span></a>
                            </li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('TEACHER')">
                            <li>
                                <a href="<c:url value="/dashboard/students"/>" class="waves-effect"><i class="md md-people"></i><span> My Students </span></a>
                            </li>
                            </sec:authorize>                              
                            <li>
                                <a href="<c:url value="/dashboard/event"/>" class="waves-effect"><i class="md md-event"></i><span> Event </span></a>
                            </li>                       
                            <li>
                                <a href="<c:url value="/dashboard/student/export"/>" class="waves-effect"><i class="md md-event"></i><span> Download Excel </span></a>
                            </li>
                            <li>
                                <a href="calendar.html" class="waves-effect"><i class="md md-event"></i><span> Calendar </span></a>
                            </li>
                            <li>
                                <a href="javascript:" id="cropImage" data-toggle="modal" data-target="#cropModal" class="waves-effect"><i class="md md-person"></i><span> Crop Image </span></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
     <jsp:invoke fragment="extraNavigationContent" />
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</template:main>

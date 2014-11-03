<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I.R.A Bank</title>

    
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">



<div class="row">
<div class="well-lg col-md-6">


<div class="panel panel-primary">
			<div class="panel panel-heading">
			I.R.A BANK
			</div>
              
              <form class="well form-inline" name="loginForm" action="<c:url value='/j_spring_security_check' />" method='POST'>
			 
			 <br>

			 <!-- Login Failed Test -->
			  <c:if test="${not empty LoginStatus}">
				<div class="label-group">
					<div id="status" class="label-info">Login failed. Please try again. 
					</div>
					<br /> 
				</div>
			</c:if>
			
			<!-- Login Failed Test -->
			  <c:if test="${not empty LogoutStatus}">
				<div class="label-group">
					<div id="status" class="label-success">Logged out successfully.
					</div>
					<br /> 
				</div>
			</c:if>

			<!-- Registration Failed Test -->
			 <c:if test="${ userRegistrationStatus != null}">
	             <div class="label-group">
	                   <div id="status" class="label label-info">${userRegistrationStatus}</div>
	             </div>
              </c:if>
             <br>

             
			<%
				/*Check if Login did not happen*/
				if(request.getAttribute("loginError") != null)
				{%>
				<p ><span class="label label-warning" style="float:right;font-weight:bold;">${loginError}</span></p>	
			  <%}%>


		<h4 style="position:absolute;left:400px; top:180px; color:#FFFF">Your SiteKey is: <strong class="label label-primary" style="font-size:14px">${sitekey}</strong></h4>
	
			  <input type="hidden" class="form-control" id="j_username" name='j_username' value="${userName}" maxlength="30" >
			
	      		  <br>
	       		 <input type="password" class="form-control" placeholder="Password"  id="j_password" name='j_password' maxlength="15">
	       		 
				<!-- placeholder -->
				<div> <br><br></div>

				  <div class="row">		
					<div class="col-md-12 col-md-8">
						<input name="login" type="submit" value="Login" class = "btn btn-primary"/>
						<input name="cancel" type="reset" value="Cancel"  class = "btn btn-danger"/>
					</div>
					<div class="col-xs-6 col-md-4">
						<a href="<%=request.getContextPath()%>/register" class="btn btn-danger" role="button">New User Register</a> 
					</div>
					</div>

	

			 </form>
	
</div>

</div>
</div>
</nav>

 <!-- Bootstrap css -->
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />

<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>

<!-- Jquery JS Files -->  
<script src="<%=request.getContextPath()%>/js/jquery.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"  type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"  type="text/javascript" ></script>

<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</body>
</html>
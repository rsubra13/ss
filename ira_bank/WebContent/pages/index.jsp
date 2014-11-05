<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="<%=request.getContextPath()%>/js/keyboard.js" charset="UTF-8"  type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/keyboard.css" media="screen"/>

<title>I.R.A Bank</title>

    
</head>
<body>

<div class="row">
	<div class="well-lg col-md-6">
		<div class="panel panel-primary">
			<div class="panel panel-heading">
					Login
			</div>
			<form name="usernameForm" id="usernameForm" action="/ira_bank/userNameCheck" method='POST' class="well form-inline" >
			  <br>
				 <c:if test="${ userstatus != null}">
		             <div class="btn-primary">
		                   <div id="status" class="label-primary">${userstatus}</div>
		             </div>
	              </c:if>
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

				   <input type="text" class="form-control" id="userName" name='userName' placeholder="Username" maxlength="30" class="" data-validate="required,alphanumeric" >
		      	   <br>	<br><br>       	
		      	   
		      	   <div class="row">		
					<div class="col-md-12 col-md-8">
							<input name="login" type="submit" value="submit" class = "col-md-2 btn btn-success"/>
					</div>
					<div class="col-xs-6 col-md-4">
					<a href="<%=request.getContextPath()%>/register" class="btn btn-danger" role="button">New User Register</a> 
					</div>
					</div>
				</form>	
				
			
			
		</div>	
	</div>
</div>

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

<script src="<%=request.getContextPath()%>/js/verify.notify.js" charset="UTF-8"  type="text/javascript"></script>

</body>
</html>
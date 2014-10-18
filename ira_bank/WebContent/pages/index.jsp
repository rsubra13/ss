<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I.R.A Bank</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">  


    
</head>
<body>

<div class="row">
<div class="well-lg col-md-6">


<div class="panel panel-primary">
<div class="panel panel-heading">
I.R.A BANK
</div>
                
			<form id ="loginform" name="loginForm" target="_self" method="post" action="Welcome" class="well form-inline">

				<input name="username"  type="text" class="form-control"  placeholder="Username" maxlength="30"/>

				<input name	="password" type="password" class="form-control" placeholder="Password" maxlength="15"/>

				<!-- placeholder -->
				<div> <br><br></div>

				<div class="form-inline">
				<input name="login" type="submit" value="Login" class = "btn btn-primary"/>
				<input name="cancel" type="reset" value="Cancel"  class = "btn btn-danger"/>
				</div>

			 </form>
	
			<%
				
				if(request.getAttribute("loginError") != null)
				{%>
				<p style="position:absolute;left:620px;top:400px;color:red">${loginError}</p>	
			  <%}%>
</div>

</div>
</div>




<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.js"></script>
</body>
</html>
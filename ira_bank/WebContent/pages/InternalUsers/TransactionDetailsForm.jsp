<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<c:url var="actionUrl" value="save" />

<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />

<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>


<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>

</head>
<body>
<form:form id="TransactionDetailsForm" commandName="RequestDetailsPopulateBean" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend>Edit Transaction Details</legend>

		<div class="form-control">
			<label for="UserName">Request</label>
			<form:input path="reqDesc"  required="required" placeholder="Request Description" />
		</div> 

		<div class="form-control">
			<label for="First Name">Is Authorized</label>
			<form:input path="isAuthorized" required="required"  placeholder="Authorization" />
		</div>


		<div class="form-control">
			<label for="First Name">User Id</label>
			<form:input path="reqUsedId"  required="required" placeholder="reqUsedId"  />
		</div>
		
	

	</fieldset>
</form:form>



</body>

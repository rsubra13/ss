<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<c:url var="actionUrl" value="save" />

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


<form:form id="userDetailsForm" commandName="userDetailsFormBean" method="post"
	action="${actionUrl}" class="pure-form pure-form-aligned">

	<fieldset>
		<legend>Edit User Details</legend>

		<div class="pure-control-group">
			<label for="UserName">UserName</label>
			<form:input path="userName"  required="required" placeholder="Username" />
		</div> 

		<div class="pure-control-group">
			<label for="First Name">Email Id</label>
			<form:input path="emailId" required="required"  placeholder="Email Id" />
		</div>

	<!-- 	<div class="pure-control-group">
			<label for="password" type>password</label>
			<form:input path="password" required="required" type="hidden" placeholder="password" />
		</div> -->

		<div class="pure-control-group">
			<label for="First Name">First Name</label>
			<form:input path="firstName"  required="required" placeholder="firstName"  />
		</div>
		<div class="pure-control-group">
			<label for="Last Name">Last Name</label>
			<form:input path="lastName" required="required" placeholder="Last Name"  />
		</div>

		<div class="pure-control-group">
			<label for="Address">Address</label>
			<form:input path="address" required="required" placeholder="address"  />
		</div>

		<div class="pure-control-group">
			<label for="contactNum">Phone Number</label>
			<form:input path="contactNum" required="required" placeholder="contactNum" />
		</div>

		<!-- <div class="pure-control-group">
			<label for="dob">D.O.B</label>
			<form:input path="dob" class="datepicker" />
		</div> -->

		<div class="form-group">
              <label for="dob">DOB</label>

                  <div class="input-group date">
                      <input type="text" id="dob" name="dob" class="datepicker" placeholder= "Select your date of birth" value="${userDetailsFormBean.dob}" required>
                      <!-- bootstrap Date picker -->
                      <script type="text/javascript">
                         $('.datepicker').datepicker(
                            { 
                             autoclose: true,
                             orientation: "right",
                             minDate: "-50Y", 
                             maxDate: "0D" ,
                             changeMonth : true,
                             changeYear : true,
                             dateformat: 'mm/dd/yyyy',
                             defaultDate: $("#dob").val()});
                      </script>

                  </div>
            </div>
		<div class="pure-control-group">
			<label for="roleId">roleId</label>
			<form:input path="roleId" required="required" placeholder="roleId" />
		</div>


	    <div class="pure-control-group">
			<label for="secQue1">Sec Que 1</label>
			<form:input path="secQue1" required="required"  placeholder="secQue1"  />
		</div>

		<div class="pure-control-group">
			<label for="secAns1">Sec Ans 1</label>
			<form:input path="secAns1" required="required" placeholder="secAns1"/>
		</div>

		<div class="pure-control-group">
			<label for="secQue2">Sec Que 1</label>
			<form:input path="secQue2" required="required" placeholder="secQue2" />
		</div>
		<div class="pure-control-group">
			<label for="secAns2">Sec Ans 2</label>
			<form:input path="secAns2" required="required" placeholder="secAns2" />
		</div>

		<form:input path="userId" type="hidden" />
		<form:input path="password" type="hidden" />
	<!-- 	<form:input path="dob" type="hidden" /> -->

	</fieldset>
</form:form>



<script src="<%=request.getContextPath()%>/js/jquery.ui.datepicker.js"  type="text/javascript" ></script>

</body>

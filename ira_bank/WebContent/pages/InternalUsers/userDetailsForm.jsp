<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="save" />

<form:form id="userDetailsForm" commandName="user" method="post"
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

		<div class="pure-control-group">
			<label for="password">password</label>
			<form:input path="password" required="required" placeholder="password" />
		</div>

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

		<div class="pure-control-group">
			<label for="DOB">D.O.B</label>
			<form:input path="dob" class="datepicker" required="required" placeholder="dob"  />
		</div>
		<div class="pure-control-group">
			<label for="roleId">roleId</label>
			<form:input path="roleId" required="required" placeholder="role" />
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

	</fieldset>
</form:form>
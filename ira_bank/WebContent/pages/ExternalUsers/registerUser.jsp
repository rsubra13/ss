<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <title>User Registration</title>

 <!-- The problem was having different folders, so place all css files in CSS folder. -->
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.theme.min.css" />
 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-1.10.2.js" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font-awesome.min.css" />

<!-- JS Files -->  
<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.10.4.custom.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
</head>

<body>

<div class="row">
<div class="page-header">
    <h1><span class="label label-warning">Registration form </span></h1>
</div>

<!-- Registration form - START -->
<div class="row">
<div class="col-md-8">
<div class="panel">
  <form class="form-inline col-md-8 well row-fluid" method="POST" id="userRegistrationFormBean" commandName="userRegistrationFormBean" action="/ira_bank/register">
        <c:if test="${ userRegistrationStatus != null}">
             <div class="btn-primary">
                   <div id="status" class="label-primary">${userRegistrationStatus}</div>
             </div>
        </c:if>
        <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                
            <!--  username -->
            <div class="form-group">
                <label for="Username">Username</label>
                    <div class="input-group">
                            <input type="text" id="userName" name="userName" placeholder="" class="form-control" value="${userRegistrationFormBean.userName}">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
            </div>

            <!-- Password-->      
            <div class="form-group">
              <label for="Password">Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="password" name="password"  placeholder="password" value="${userRegistrationFormBean.password}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        <span class="help-block">Minimum length of password is 5.</span>
                    </div>
            </div>     
        
                    <!-- First Name -->            
            <div class="form-group">
              <label for="FirstName">First Name</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="firstName" name="firstName"  placeholder="First Name" value="${userRegistrationFormBean.firstName}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
            </div>

            <!-- Last Name -->
             <div class="form-group">
              <label for="LastName">Last Name</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="lastName" name="lastName"  placeholder="Last Name" value="${userRegistrationFormBean.lastName}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
            </div>

         <!-- Email -->
            <div class="form-group">
              <label for="InputEmail">Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="emailId" name="emailId"   placeholder="Enter Email" value="${userRegistrationFormBean.emailId}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div> <br>

        <!-- Address -->
            <div class="form-group">
              <label for="Address">Address</label>
                    <div class="input-group">
                        <input type="text" class="form-control col-md-12" id="address"  rows="10" ,cols="15" name="address"  placeholder="Address" value="${userRegistrationFormBean.address}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div> <br>

        <!-- Address -->
            <div class="form-group">
              <label for="contactNum">contactNum</label>
                    <div class="input-group">
                        <input type="phone" class="form-control" id="contactNum" name="contactNum"   placeholder="Phone Number" value="${userRegistrationFormBean.contactNum}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div> <br><br>

        <!-- DOB -->
        <!-- This is not proper , need to make it perfect. -->
            <div class="control-group">
              <label for="dob">DOB</label>
                  <div class="input-group">
                      <input type="text" id="dob" name="dob" class="datepicker" placeholder= "Select your date of birth" value="${userRegistrationFormBean.dob}" required>
                      <!-- bootstrap Date picker -->
                      <script type="text/javascript">
                         $('.datepicker').datepicker(
                            { 
                             autoclose: true,
                             orientation: "right",
                             minDate: "-50Y", 
                             maxDate: "0D" ,
                             dateformat: 'mm/dd/yyyy',
                             defaultDate: $("#dob").val()});
                      </script>
                  </div>
            </div>

        <!-- User Role -->
        <div class="control-group">
            <label class="control-label"  for="Role">Type of User</label>
                <div class="controls">
                    <select name="role">  

                       
                            <option value= 6715>Regular User</option>     
                            <option value=8767> Merchant </option>
                     </select>
                </div>
        </div>


         <!-- Sec Que 1 -->
          <div class="form-group">
              <label for="Address">Security Que 1</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="secQue1" rows="2" ,cols="3" name="secQue1"   placeholder="security Que 1" value="${userRegistrationFormBean.secQue1}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div> <br>
         <!-- Sec Ans 1 -->
            <div class="form-group">
              <label for="Address">Security Ans 1</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="secAns1" rows="2" ,cols="3" name="secAns1"   placeholder="security Ans 1" value="${userRegistrationFormBean.secAns1}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div> <br>

         <!-- Sec Que 2 -->
            <div class="form-group">
              <label for="Address">Security Que 2</label>
                    <div class="input-group">
                        <input type="textarea" class="form-control" id="secQue2" rows="2" ,cols="3" name="secQue2"   placeholder="security Que 2" value="${userRegistrationFormBean.secQue2}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div> <br> <br>

         <!-- Sec Ans 2 -->
            <div class="form-group">
              <label for="Address">Security Ans 2</label>
                    <div class="input-group">
                        <input type="textarea" class="form-control" id="secAns2" rows="" , cols="3" name="secAns2"   placeholder="security Ans 2" value="${userRegistrationFormBean.secAns2}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div> <br>


                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-info pull-right">
            </div>
        </form>
        <!-- Registration form-->
    </div>
</div>


</div>

</body>
</html>
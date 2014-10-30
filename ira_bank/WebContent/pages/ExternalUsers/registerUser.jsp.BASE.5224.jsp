<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <title>User Registration</title>



 <!-- The problem was having different folders, so place all css files in CSS folder. -->
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

</head>

<body>

<!-- Registration -->
<!--first split-->

<div class="row">
<br><br>
   <div class="col-md-6">
     

         <div class="panel panel-info">
              <div class="panel-heading">
                <form class=" row-fluid" method="POST" id="userRegistrationFormBean" 
                commandName="userRegistrationFormBean" action="/ira_bank/register">
                      <c:if test="${ userRegistrationStatus != null}">
                           <div class="btn-primary">
                                 <div id="status" class="label-primary">${userRegistrationStatus}</div>
                           </div>
                      </c:if>

             <div class="btn-warning"><h2>Register Form</h2></strong></div>
            <span class="glyphicon glyphicon-asterisk"></span>Required Fields</strong>
                
            <!--  username -->
            <div class="form-group">
                <label  for="Username">Username</label>
                    <div class="input-group">
                            <input type="text" id="userName" name="userName" placeholder="" class="form-control " value="${userRegistrationFormBean.userName}">
                           <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
            </div>

            <!-- Password-->      
            <div class="form-group">
              <label  for="Password">Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control " id="password" name="password"  placeholder="password" value="${userRegistrationFormBean.password}" required>
                       <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                       
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
            </div>

        <!-- Address -->
            <div class="form-group">
              <label for="Address">Address</label>
                    <div class="input-group">
                        <textarea class="form-control col-md-12" id="address"  rows="4" ,cols="4" name="address"  placeholder="Address" value="${userRegistrationFormBean.address}" required> </textarea>
                        
                        </div>
            </div>

       
       </div>
      </div>
    </div>

  <!--   Start the second split -->   
   <div class="col-md-6" >
      <div class=" panel panel-info">
         <div class="panel-heading">
        <!-- DOB -->
        <!-- This is not proper , need to make it perfect. -->

         <!-- Ph Number -->
            <div class="form-group">
              <label for="contactNum">Phone Number</label>
                    <div class="input-group">
                        <input type="phone"  id="contactNum" name="contactNum"   placeholder="Phone Number" value="${userRegistrationFormBean.contactNum}" required>
                      
                        </div>
            </div>

            <div class="form-group">
              <label for="dob">DOB</label>

                  <div class="input-group date">
                      <input type="text" id="dob" name="dob" class="datepicker" placeholder= "Select your date of birth" value="${userRegistrationFormBean.dob}" required>
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

        <!-- User Role -->
        <div class="form-group">
            <label class="control-label"  for="Role">Type of User</label>
                <div class="controls">
                    <select name="role">  
                            <option value=6715>Regular User</option>     
                            <option value=8767> Merchant </option>
                     </select>
                </div>
        </div>


       <!-- Sec Que 1 -->
            <div class="form-group">
              <label for="Address">Security Question 1</label>
                    <div class="input-group">
                        <textarea class="form-inline" id="secQue1" rows="3" ,cols="7" name="secQue1"   placeholder="Security Que 1" value="${userRegistrationFormBean.secQue1}" required> </textarea>
                      
                        </div>

         <!-- Sec Ans 1 -->
            <div class="form-group">
              <label for="Address">Security Answer 1</label>
                    <div class="input-group">
                        <textarea class="form-inline" id="secAns1" rows="3" ,cols="7" name="secAns1"   placeholder="Security Ans 1" value="${userRegistrationFormBean.secAns1}" required> </textarea>
                   
                       
                        </div>
            </div> <br>

         <!-- Sec Que 2 -->
            <div class="form-group">
              <label for="Address">Security Question 2</label>
                    <div class="input-group">
                        <textarea class="form-control" id="secQue2" rows="" ,cols="3" name="secQue2"   placeholder="Security Que 2" value="${userRegistrationFormBean.secQue2}" required> </textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        
                        </div>
            </div>
         <!-- Sec Ans 2 -->
            <div class="form-group">
              <label for="Address">Security Answer 2</label>
                    <div class="input-group">
                        <textarea class="form-control" id="secAns2" rows="" , cols="3" name="secAns2"   placeholder="security Ans 2" value="${userRegistrationFormBean.secAns2}" required></textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div> 




    </div>
    </div>
    </div>
    <div class="form control">
                <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-danger pull-center">
      </div>   
        </form><!-- Registration form End-->
    
      
</div>

</body>
</html>
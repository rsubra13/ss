<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I.R.A Bank</title>
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
<script src="<%=request.getContextPath()%>/js/verify.notify.js"></script>
</head>
<body>
<div class="panel panel-primary">
  <div class="panel-heading">FORGOT PASSWORD</div>
</div>


  <div class="panel-body">
    <form class="form-horizontal" action="/ira_bank/Forgot" id="forgotPasswordFormBean" 
                commandName="forgotPasswordFormBean" method="POST">
                 <c:if test="${ Status != null}">
                           <div class="btn-primary">
                                 <div id="status" class="label-primary">${Status}</div>
                           </div>
                      </c:if>
   <div class=" col-md-offset-1 form-group">
              <label class=" control-label" for="InputEmail">Email</label>
                    <div class=" col-md-7 input-group">
                        <input type="email" class="form-control" id="emailId" name="emailId"   placeholder="Enter Email" data-validate="required,email" value="${userRegistrationFormBean.emailId}" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            </div>

 
  <div class=" form-group">
              <label for="dob">DOB</label>

                  <div class="input-group date col-md-7 ">
                      <input type="text"  id="dob" name="dob" class="datepicker form-control" data-validate="required" placeholder= "Select your date of birth"  value="${userRegistrationFormBean.dob}" >
 <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>                    
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
            <div class="form-group ">
              <label class="control-label" for="secQue1" >Security Question 1</label>
                    <div class="input-group col-md-7">
                        <textarea class="form-control" id="secQue1" rows="2"  name="secQue1"   placeholder="Security Que 1" value="${userRegistrationFormBean.secQue1}" readonly> </textarea>
                       <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
					</div>
         <!-- Sec Ans 1 -->
            <div class="form-group ">
              <label  class="control-label" for="secAns1">Security Answer 1</label>
                    <div class="input-group col-md-7">
                        <textarea class="form-control" id="secAns1" rows="2"  name="secAns1" data-validate="required,alphanumeric"  placeholder="Security Ans 1" value="${userRegistrationFormBean.secAns1}" > </textarea>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                       
                        </div>
            </div> 

         <!-- Sec Que 2 -->
            <div class="form-group ">
              <label  class="control-label" for="secQue2">Security Question 2</label>
                    <div class="input-group  col-md-7">
                        <textarea class="form-control" id="secQue2" rows="2"  name="secQue2"   placeholder="Security Que 2"   value="${userRegistrationFormBean.secQue2}" readonly> </textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        
                        </div>
            </div>
         <!-- Sec Ans 2 -->
            <div class="form-group ">
              <label class="control-label" for="secAns2" >Security Answer 2</label>
                    <div class="input-group col-md-7 ">
                        <textarea class="form-control" id="secAns2" rows="2"  name="secAns2"   placeholder="security Ans 2"  data-validate="required,alphanumeric" value="${userRegistrationFormBean.secAns2}"  ></textarea>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
            
            </div> 
  <div class="col-md-12">
    <div class="form-group">
                <input type="submit" name="submit" id="submit" value="Send" class="centered  btn btn-danger  ">
      </div> 
      </div>    
         
</form>
</div>
<script>
$( "form" ).submit(function( event ) {
	
	$( "form" ).submit();
});
</script>
</body>
</html>
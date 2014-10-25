<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="../../css/bootstrap.css" />  
<title>CREDIT / DEBIT Funds</title>
</head>
<body>
<%
String context_path=request.getContextPath();
String navbar_path=context_path+"/pages/navbar.jsp";
%>
<%@include file="../navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading"> CREDIT / DEBIT Funds</div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" role="form">
  <div class="form-group">

  <label class="radio-inline col-sm-4 control-label">
  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> Credit
</label>
<label class="radio-inline col-sm-4 control-label">
  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2"> Debit
</label>

   </div>
    
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">From/To</label>
    <div class="col-sm-7 col-md-7">
      <input type="Text" class="form-control" id="inputPassword3" placeholder="From/To Account Number">
    </div>
  </div>
  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input type="Text" class="form-control" id="inputamount" placeholder="Amount">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>
    
  </div>
</div>
<script src="../../js/jquery-1.10.2.js"></script>
    <script src="../../js/bootstrap.js"></script>
</body>
</html>
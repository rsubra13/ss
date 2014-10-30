<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I.R.A bank</title>
</head>
<body>
<%@include file="../common/navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading">Bill Pay User</div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" role="form" action="" method="post">
  <div class="form-group">
    <label for="inputText3" class="col-sm-2 control-label">From</label>
    <div class="col-sm-7">
      <input name="from_account" type="Text" class="form-control" id="inputText3" placeholder="Merchant name " value="" readonly>
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input name="amount" type="Text" class="form-control" id="inputamount" placeholder="Amount" value="">
    </div>
  </div>
  <div class="form-group">
  <label for="inputamount" class="col-sm-2 control-label">PKI</label>
  <div class="col-sm-7 col-md-7">
  <label for="file" class="centered btn btn-primary btn-sm">Choose File</label>
    <input id= "file" type="file" style="display:none;">
    </div></div>
 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
      <button type="submit" class="btn btn-default">Authorize</button>
    </div>
  </div>
</form>

</body>
</html>
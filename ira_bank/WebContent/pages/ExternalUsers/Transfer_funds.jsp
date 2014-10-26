<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transfer Funds</title>
 
</head>
<body>
${userRegistrationStatus}<br/>
${userName}<br/>
<%@include file="../navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading">TRANSFER FUNDS</div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" role="form" action="/ira_bank/Transfer" method="post">
  <div class="form-group">
    <label for="inputText3" class="col-sm-2 control-label">From</label>
    <div class="col-sm-7">
      <input name="from_account" type="Text" class="form-control" id="inputText3" placeholder="From Account Number" value="${SampTransFormBean.from_account}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">To</label>
    <div class="col-sm-7 col-md-7">
      <input name="to_account" type="Text" class="form-control" id="inputPassword3" placeholder="To Account Number" value="${SampTransFormBean.to_account}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input name="amount" type="Text" class="form-control" id="inputamount" placeholder="Amount" value="${SampTransFormBean.amount}">
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

</body>
</html>
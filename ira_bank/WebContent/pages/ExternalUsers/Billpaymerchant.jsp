<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I.R.A Bank</title>
</head>
<body>
<%@include file="../common/navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading">Bill Pay Merchant</div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" role="form" action="" method="post">
  <div class="form-group">
    <label for="inputusername" class="col-sm-2 control-label">Select Username</label>
    <div class="col-sm-7">
      <select class="form-control" id="inputusername" name="username">
  <option value="First Issue">First user</option>
  <option value="Second Issue">Second user</option>
  <option value="Third Issue">Third user</option>
  <option value="Fourth Issue">Fourth user</option>
  <option value="Fifth Issue">Fifth user</option>
</select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input name="amount" type="Text" class="form-control" id="inputamount" placeholder="Amount" value="">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
      <button type="submit" class="btn btn-default">Send</button>
    </div>
  </div>
</form>
    
  </div>
</body>
</html>
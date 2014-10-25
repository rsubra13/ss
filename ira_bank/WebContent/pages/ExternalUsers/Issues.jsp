<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../navbar.jsp" %>

<div class="panel panel-primary">
  <div class="panel-heading">Submit An Issue</div>
</div>
<form class="form-horizontal" role="form">
  <div class="form-group">
    <label for="inputissues" class="col-sm-2 control-label">Issues</label>
    <div class="col-sm-7">
      <select class="form-control" id="inputissues">
  <option>First Issue</option>
  <option>Second Issue</option>
  <option>Third Issue</option>
  <option>Fourth Issue</option>
  <option>Fifth Issue</option>
</select>
    </div>
  </div>
  <div class="form-group">
    <label for="inputDesc" class="col-sm-2 control-label">Description</label>
    <div class="col-sm-7">
      <textarea class="form-control" rows="3" id="inputDesc"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label for="inputpriority" class="col-sm-2 control-label">Priority</label>
    <div class="col-sm-7">
      <select class="form-control" id="inputpriority">
  <option>Critical</option>
  <option>Normal</option>
  <option>Medium</option>
 
</select>
    </div>
  </div>
    <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>
  
</body>
</html>
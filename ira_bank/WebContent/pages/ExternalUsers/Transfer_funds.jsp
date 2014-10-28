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
      <c:if test="${transferStatus != null}">
                <div class="btn-primary">
                   <div id="status" class="label-primary">${transferStatus}</div>
                </div>
  </c:if>
    <form class="form-horizontal" role="form" method="POST" id="transferFormBean" 
    commandName="transferFormBean" action="/ira_bank/ExternalUsers/Transfer_funds">
  <div class="form-group">
    <label for="inputText3" class="col-sm-2 control-label">From</label>
    <div class="col-sm-7">
      <input name="fromaccount" type="Text" class="form-control" id="inputText3" placeholder="From Account Number" value = <%=request.getAttribute("TextValue")%> readonly="true" required>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">To</label>
    <div class="col-sm-7 col-md-7">
      <input name="toaccount" type="Text" class="form-control" id="inputPassword3" placeholder="To Account Number" value="${TransferFormBean.toaccount}" required>
    </div>
  </div>
  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input name="amount" type="Text" class="form-control" id="inputamount" placeholder="Amount" value="${TransferFormBean.amount}" required>
    </div>
  </div>
    <div class="form-group">
    <label for="pki" class="col-sm-2 control-label">PKI</label>
    <div class="col-sm-7 col-md-7">
      <input name="pki" type="Text" class="form-control" id="inputpki" placeholder="PKI" value="${TransferFormBean.pki}">
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
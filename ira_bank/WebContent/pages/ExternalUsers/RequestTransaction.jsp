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
<div ><label for="inputText3"> ${StatusHere}</label>
<div><label for="inputText3">${transactStatus}</label></div>
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
  
    <form class="form-horizontal" role="form" action="/ira_bank/ExternalUsers/Request" method="POST" id="transferFormBean" 
    commandName="transferFormBean"> 
  
  <div class="form-group">
 
    <label for="inputText3" class="col-sm-2 control-label">From</label>
    <div class="col-sm-7">
      <input name="fromaccount" type="Text" class="form-control" id="inputText3" placeholder="From Account Number" value = <%=request.getAttribute("TextValue")%>  readonly="true" required>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">To</label>
    <div class="col-sm-7 col-md-7">
      <input name="to_account" type="Text" class="form-control" id="inputPassword3" placeholder="To Account Number" value="${InternalTransactionFormBean.to_account}">
    </div>
  </div>
  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input name="amount" type="Text" class="form-control" id="inputamount" placeholder="Amount" value="${InternalTransactionFormBean.amount}">
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
	 <!-- Button for Request Transaction -->
	  <button type="submit" class="btn btn-default">Request Transaction</button>
      
    </div>
  </div>
</form>
    
  </div>
</div>

</body>
</html>
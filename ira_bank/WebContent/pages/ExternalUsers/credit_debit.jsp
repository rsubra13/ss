<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>I.R.A Bank</title>
</head>
<body>

<%@include file="../navbar.jsp" %> 

         <div class="panel panel-info">
              <div class="panel-heading">
                <form class=" row-fluid" method="POST" id="accountFormBean" 
                commandName="accountFormBean" action="credit_debit">
                <c:if test="${ accountStatus != null}">
                <div class="btn-primary">
                   <div id="status" class="label-primary">${accountStatus}</div>
                </div>
                </c:if>
                </form>
           </div>
           </div>




<div class="panel panel-primary">
  <div class="panel-heading"> CREDIT/DEBIT Funds</div>
</div>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title"></h3>
  </div>
  <div class="panel-body">
    <form class="form-horizontal" role="form">
  <div class="form-group">

  <label class="radio-inline col-sm-4 control-label">
  <input type="radio" name="CreditDebit" id="inlineRadio1" value="Credit"> Credit
</label>
<label class="radio-inline col-sm-4 control-label">
  <input type="radio" name="CreditDebit" id="inlineRadio2" value="Debit"> Debit
</label>

   </div>
    
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">From/To</label>
    <div class="col-sm-7 col-md-7">
      <input type="Text" class="form-control" id="inputPassword3" name="accountNumber" placeholder="From/To Account Number">
    </div>
  </div>
  <div class="form-group">
    <label for="inputamount" class="col-sm-2 control-label">Amount</label>
    <div class="col-sm-7 col-md-7">
      <input type="Text" class="form-control" id="inputamount" name="amount" placeholder="Amount">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-7 col-md-offset-2 col-md-7">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
     
			<%
				/*Check if Login did not happen*/
				if(request.getAttribute("accountSuccess") != null)
				{%>
				<p ><span class="label label-warning" style="float:right;font-weight:bold;">${accountSuccess}</span></p>	
			  <%}
				else if(request.getAttribute("accountError") != null)
				{%>
				<p ><span class="label label-warning" style="float:right;font-weight:bold;">${accountError}</span></p>	
			  <%}
			  %>
  
  
</form>
    
  </div>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.css" />  
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.css.map " />  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I.R.A Bank</title>
</head>
<body>

  <div class="container-fluid">
<div class="row ">
<div class="col-md-offset-1 col-md-10">
  <div class="panel panel-primary">
  
  <div class="panel-heading">Approved Requests</div>
  <div class="panel-body">
  </div>
  
        <c:if test="${accountStatus != null}">
                <div class="btn-primary">
                   <div id="status" class="label-primary">${accountStatus}</div>
                </div>
  		</c:if>
     
  <!-- Table -->
  
  <table class="table table-condensed">
  	<thead>
			 <tr>
			 <td>Request Id</td>
			<td>Merchant ID</td>
			 <td>Account number </td>
			 <td>Amount</td>
			 <td>Private Key</td>
			 <td>Action</td>
			 </tr>
    </thead>
			 
			 <tbody>
			 
			   <c:forEach items="${BillpayInfo}" var="Billpaylist" varStatus="loopCounter">
			   <c:if test="${Billpaylist.status == 'MerchantPending'}">
			   <c:if test="${Billpaylist.acctNumber == Useracount}">
			   <tr>
			   <form class="form-horizontal" action="/ira_bank/ExternalUsers/BillpayUser" method="POST" id="billpayuserFormBean">
			   <input type = "hidden" name = "billid" value = "${Billpaylist.billId}">
			   <input type = "hidden" name = "merchantid" value = "${Billpaylist.merchantId.userId}">
			   <input type = "hidden" name = "accountno" value = "${Billpaylist.acctNumber}">
			   <input type = "hidden" name = "amount" value = "${Billpaylist.amount}"> 
			   <td><c:out value="${Billpaylist.billId}" /></td>            
			   <td><c:out value="${Billpaylist.merchantId.userId}" /></td>
			   <td><c:out value="${Billpaylist.acctNumber}" /></td>
			   <td><c:out value="${Billpaylist.amount}" /></td>
			   <td><input type="password"  name="privateKey"  value ="tesst" id="privateKey" /></td>
<!-- 				<td><textarea name="privatekey" rows = "50" id="privatekey" required></textarea></td> -->
			   <td><button  type="action" name="action" id="accept" value="Accept">Approve</button> <button  type="action" name="action" id="reject" value="Reject">Reject</button></td>
			   </form>			                      
			   </tr>
			   </c:if>
			   </c:if>
			   </c:forEach>
			   
			</tbody>
	</table>
</div>
</div>
</div>
</div>


</body>
</html>
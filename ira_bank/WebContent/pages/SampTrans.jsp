<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>I.R.A Bank</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">  
    
</head>
<body>
${userRegistrationStatus}
${userName}
<br/>
<form id ="transact" name="transact" target="_self" method="post" action="<%=request.getContextPath()%>/transaction" class="well form-inline">
				<input name="to_account"  type="text" class="form-control"  placeholder="Enter to Account" maxlength="30" value="${SampTransFormBean.to_account}"/>
                <input name="Request" type="submit" value="Request" class = "btn btn-primary"/>
</form>
</body>
</html>
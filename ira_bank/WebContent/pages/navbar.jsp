
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.css" />  
<link rel="stylesheet" type="text/css" media="screen" href="<%=request.getContextPath()%>/css/bootstrap.css.map " />  

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-default " role="navigation">
        <div class="container">
        <p class="navbar-text navbar-right"><a href="<%=request.getContextPath()%>/pages/ExternalUsers/Issues.jsp" class="navbar-link">Submit an Issue</a></p>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">

                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">I.R.A Bank</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                  <li><a href="<%=request.getContextPath()%>/pages/ExternalUsers/Accounts.jsp">Account</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/ExternalUsers/Transfer_funds.jsp">Transfer Funds</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/ExternalUsers/Payments.jsp">Payment</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/ExternalUsers/credit_debit.jsp">Debit/Credit</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/ExternalUsers/user_profile.jsp">Profile</a></li>
		    <li><a href="<%=request.getContextPath()%>/pages/SampTrans">Request Transactions</a></li>
			
                </ul>
                
            </div>
        
        </div>
        <!-- /.container -->
    </nav>
</body>
 <!-- JavaScript -->
    <script src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
</html>
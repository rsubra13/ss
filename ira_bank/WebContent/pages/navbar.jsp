
<html>
<head>
<link rel="stylesheet" type="text/css" media="screen" href="../css/bootstrap.css" />  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse " role="navigation">
        <div class="container">
        
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
                  <li><a href="Accounts.jsp">Account</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/ExternalUsers/Transfer_funds.jsp">Transfer Funds</a></li>
            <li><a href="Payment.jsp">Payment</a></li>
            <li><a href="<%=request.getContextPath()%>/pages/ExternalUsers/credit_debit.jsp">Debit/Credit</a></li>
            <li><a href="Profile.jsp">Profile</a></li>

                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
</body>
 <!-- JavaScript -->
    <script src="../js/jquery-1.10.2.js"></script>
    <script src="../js/bootstrap.js"></script>
</html>
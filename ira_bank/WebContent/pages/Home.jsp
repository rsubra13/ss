<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>I R A Home Page</title>

   
    <!-- Add custom CSS here -->

    <style>
        body {
            margin-top: 60px;
        }
    </style>
 

</head>

<body>


    <nav class="navbar navbar-inverse navbar-fixed-top" >
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">I R A Bank Home Page</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->	
             <form id ="customizeform" name="customizeform" target="_self" method="POST" action="" class="form-inline">
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                   <li><a href="<%=request.getContextPath()%>/Welcome">Login</a></li>
                   
                </ul>
            </div>
            </form>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div class="container">

        <c:if test="${ userName != null}">
             <div class="btn-primary">
                   <div id="status" class="label-primary"><h2> Welcome ${userName}<h2></div>
             </div>
        </c:if>

        <div class="row mt-20 search-bar">
            <div class="col-lg-6">
                <input type="text" class="form-control" id="autocomplete">
            </div>
            <div class="col-lg-2">
                <button id="add_button" type="button" class="btn btn-default add-butt">Search Activity</button>
            </div>
        </div>

      <!-- Bootstrap css -->
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.css" />
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-theme.min.css" />

<!-- Jquery CSS -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.css" media="screen"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-ui.theme.min.css" media="screen"/>

<!-- Jquery JS Files -->  
<script src="<%=request.getContextPath()%>/js/jquery.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"  type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"  type="text/javascript" ></script>

<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
       


    </body>

    </html>

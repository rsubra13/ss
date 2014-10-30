<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>I R A Home Page</title>

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/recommendation.css" rel="stylesheet">
    <link href="css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.10.4.custom.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/custom.js"></script>
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
                   <div id="status" class="label-primary">
                   <h2> Welcome ${userName}</h2></div>
             </div>
        </c:if>
     

           <div style="width: 95%; margin: 0 auto;">
       
                
                    <h1>List Of Issues</h1>
                

                     <br>
                     <table class="table table-condensed">
                        <thead>
                           <tr>
                           	  <th width="12%">Sr. No</th>
                           	 
                              <th width="12%">Issue Type</th>
                              <th width="12%">Description</th>
                              <th width="12%">Status</th>
                              <th width="12%">Priority</th>
                              <th width="12%">Date</th>
                              
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${issuesList}" var="issues" varStatus="loopCounter">
                           <tr>
                               <td><c:out value="${loopCounter.count}" /></td>
                                
                                <td><c:out value="${issues.reqType}" /></td>
                                <td><c:out value="${issues.reqDesc}" /></td>
                                <td><c:out value="${issues.reqStatus}" /></td>
                                <td><c:out value="${issues.reqPriority}" /></td>
                                <td><c:out value="${issues.reqDate}" /></td>
                               

                            </tr>
                            </c:forEach>
                        </tbody>
                     </table>
         </div>



     </div>
       


    </body>

    </html>

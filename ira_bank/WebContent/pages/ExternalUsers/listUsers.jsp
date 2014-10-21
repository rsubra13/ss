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
       
                
                    <h1>List Of Users</h1>
                

                     <br>
                     <table class="table table-condensed">
                        <thead>
                           <tr>
                              <th width="4%">S.No</th>
                              <th width="12%">Username</th>
                              <th width="12%">Email</th>
                              <th width="12%">FirstName</th>
                              <th width="12%">lastName</th>
                              <th width="12%">Address</th>
                              <th width="12%">DOB</th>
                              <th width="12%">Phone</th>
                              <th width="12%">Sec Que1</th>
                              <th width="12%">Sec Ans1</th>
                              <th width="12%">Sec Que2</th>
                              <th width="12%">Sec Ans2</th>
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${usersList}" var="user" varStatus="loopCounter">
                           <tr>
                               <td><c:out value="${loopCounter.count}" /></td>
                               <td><c:out value="${user.userName}" /></td>
                               <td><c:out value="${user.emailId}" /></td>
                               <td><c:out value="${user.firstName}" /></td>
                               <td><c:out value="${user.lastName}" /></td>
                               <td><c:out value="${user.address}" /></td>
                               <td><c:out value="${user.dob}" /></td>
                               <td><c:out value="${user.contactNum}" /></td>
                               <td><c:out value="${user.secQue1}" /></td>
                               <td><c:out value="${user.secAns1}" /></td>
                               <td><c:out value="${user.secQue2}" /></td>
                               <td><c:out value="${user.secAns2}" /></td>

                            </tr>
                            </c:forEach>
                        </tbody>
                     </table>
         </div>



     </div>
       


    </body>

    </html>

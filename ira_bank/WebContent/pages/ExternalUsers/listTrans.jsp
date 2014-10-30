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

    <!-- Add custom CSS here -->

    <style>
        body {
            margin-top: 60px;
        }
    </style>
    <script src="<%=request.getContextPath()%>/js/jquery.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.js"  type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery-ui.min.js"  type="text/javascript" ></script>

    <script src="<%=request.getContextPath()%>/js/userDetails.js"  type="text/javascript" ></script>

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
           
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                   <li><a href="<%=request.getContextPath()%>/Welcome">Login</a></li>
                   
                </ul>
            </div>
        
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
     

           <div id=style="width: 95%; margin: 0 auto;">

           <!-- Include the hidden form ( the modal pops up has details of these.) -->
           
                
                    <h1>List Of Users</h1>
                

                     <br>
                     
                     <table class="table table-condensed">
                        <thead>
                           <tr class="success">
                              <th width="4%">S.No</th>
                              <th width="12%">Request Id</th>
                              <th width="12%">Request User Id</th>
                              <th width="12%">Request Description</th>
                              <th width="12%">Request Status</th>
                              <th width="12%">Request Date</th>
                              <th width="12%">Request Type</th>
                              <th width="12%">Is_Authorized</th>
                              <th width="12%">Request Priority</th>
                              <th width="12%">Request Transaction ID</th>
                             
                           </tr>
                        </thead>
                       
                        <tbody>
                           <c:forEach items="${RequestDetailsList}" var="requestDetails" varStatus="loopCounter">
                           <c:if test="${ requestDetails.getIsApproved() == false}">
                           <tr>
                            <form method = "POST" id="form1">
                               <td><c:out value="${loopCounter.count}" /></td>
                               <td><input form="form1" name="reqId"  type="text" class="form-control"  placeholder="RequestID" maxlength="15" value="<c:out value="${requestDetails.getReqId()}" />" readonly="readonly"/></td>
                               
                             <td><input name="userId" form= "form1" type="text" class="form-control"  placeholder="userId" maxlength="10" value="<c:out value="${requestDetails.getReqUserId().getUserId()}" />" readonly="readonly"/> </td>
                               <td><input name="reqDesc" form="form1"  type="text" class="form-control"  placeholder="reqDesc" maxlength="10" value="<c:out value="${requestDetails.getReqDesc()}" />"  readonly="readonly"/>
                               </td>
                               <td><c:out value="${requestDetails.getReqStatus()}" /></td>
                               <td><c:out value="${requestDetails.getReqDate()}" /></td>
                               <td><c:out value="${requestDetails.getReqType()}" /></td>
                               <td><c:out value="${requestDetails.getIsApproved()}" /></td>
                               
                               <td><c:out value="${requestDetails.getReqPriority()}" /></td>
                               
                               <td><input form="form1" name="transId"  type="text" class="form-control"  placeholder="TransactionId" maxlength="15" value="<c:out value="${requestDetails.getReqTransId().getTransId()}" />" readonly="readonly"/></td>
                                <td>
                     
                       
                             <button form="form1"  name ="${requestDetails.getReqUserId().getUserId()}"type="submit" class="btn btn-default" formaction="/ira_bank/admin/Transaction/Approval">Approve</button>
      
						 

                        
                       
                       		 </form>
                            </tr>
                            </c:if>
                            </c:forEach>
                            
                        </tbody>
                     </table>
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

<!-- bootstap js -->

<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ui.datepicker.js"  type="text/javascript" ></script>


    </body>

    </html>

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

    <script src="<%=request.getContextPath()%>/js/TransactionDetails.js"  type="text/javascript" ></script>

</head>

<body>
<%@include file="../common/navbar.jsp" %>
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
                     <c:if test="${useThis == true}" >
                                 <li><a href="<%=request.getContextPath()%>/admin/ApprovedTransactions">Approved Transactions</a></li>
                     
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
		                      <button onclick="editTrans(${requestDetails.getReqId()});"
		                                class="pure-button pure-button-primary">
		                             <i class="fa fa-pencil"></i> Edit
		                        </button>
                       		 <c:if test="${button== true}" >
                             <button form="form1"  name ="${requestDetails.getReqUserId().getUserId()}"type="submit" class="btn btn-default" formaction="/ira_bank/admin/Transaction/Approval">Approve</button>
     						 </c:if>
						 

                        
                       
                       		 </form>
                            </tr>
                            </c:if>
                            </c:forEach>
                            
                        </tbody>
                     </table>
                     </c:if>
         </div>
         <!-- List of All Approved Transactions -->
         <br>
                     <c:if test="${approved == true}" >
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
                           <c:if test="${ requestDetails.getIsApproved() == true}">
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
                     
                       
      
						 

                        
                       
                       		 </form>
                            </tr>
                            </c:if>
                            </c:forEach>
                            
                        </tbody>
                     </table>
                     </c:if>
         </div>
<div>
<c:if test="${useThis == false}">
<table class="table table-condensed">
<thead>
                           <tr class="success">
                              <th width="4%">S.No</th>
                           
                              <th width="12%">Request Description</th>
                              <th width="12%">Request Date</th>
                              <th width="12%">Request Type</th>
                            
                             
                           </tr>
                        </thead>
<c:forEach items="${RequestDetailsList}" var="requestDetails" varStatus="loopCounter">
<c:if test="${userIdCompare == requestDetails.getReqUserId().getUserId()}">

                        
                       
                        <tbody>
                           
                           
                           <tr>
                            <form method = "POST" id="form1">
                               <td><c:out value="${loopCounter.count}" /></td>
                              <td><input name="reqDesc" form="form1"  type="text" class="form-control"  placeholder="reqDesc" maxlength="10" value="<c:out value="${requestDetails.getReqDesc()}" />"  readonly="readonly"/>
                               </td>
                               <td><c:out value="${requestDetails.getReqDate()}" /></td>
                               <td><c:out value="${requestDetails.getReqType()}" /></td>
                         
                                            
                       		 </form>
                            </tr>

                           
                            
                        </tbody>
                          </c:if>
                      </c:forEach>
                     </table>
                     </c:if>
                   

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

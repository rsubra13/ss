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

    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/recommendation.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/custom.js"></script>
    <!-- Add custom CSS here -->

    <style>
        body {
            margin-top: 60px;
        }
    </style>
 

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
     

           <div style="width: 95%; margin: 0 auto;">
       
                
                    <h1>List Of My Issues</h1>
                

                     <br>
                     <table class="table table-condensed">
                        <thead>
                           <tr>
                           	  <th width="12%">Sr. No</th>
                           	 
                             <th width="12%">User ID</th>
                             <th width="12%">User Name</th>
                              <th width="12%">Issue Type</th>
                              
                              <th width="12%">Description</th>
                              <th width="12%">Status</th>
                              <th width="12%">Priority</th>
                              <th width="12%">DateTime</th>
                              
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${myissuesList}" var="issues" varStatus="loopCounter">
                           <tr>
                           		<c:if test="${issues.reqType!='Transact'}">
                           		
                               <td><c:out value="${loopCounter.count}" /></td>
                                <td><c:out value="${issues.reqUserId.userId}" /></td>
                                <td><c:out value="${issues.reqUserId.userName}" /></td>
                                <td><c:out value="${issues.reqType}" /></td>
                                <td><c:out value="${issues.reqDesc}" /></td>
                                <td><c:out value="${issues.reqStatus}" /></td>
                                <td><c:out value="${issues.reqPriority}" /></td>
                                <td><c:out value="${issues.reqDate}" /></td>
                               
                        </c:if>
								
                            </tr>
                                 <!--  -->           
                           
                            </c:forEach>
                        </tbody>
                     </table>
         </div>



     </div>
       


    </body>

    </html>

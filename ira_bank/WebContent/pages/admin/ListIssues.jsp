<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
   
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
       
                
                    <h1>List Of Issues</h1>
                

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
                           <c:forEach items="${issuesList}" var="issues" varStatus="loopCounter">
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
                               <td><button type="submit" class="btn btn-default">Approve</button>
                               <td><button type="submit" class="btn btn-default">Reject</button>
                        
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

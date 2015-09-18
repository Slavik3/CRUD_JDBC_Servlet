<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="y" uri="/custom.tld"%>

<html>
<head>
	<title>List users</title> 
	<link rel="stylesheet" type="text/css" media="screen" href="style/st4.css"/>
	<script type="text/javascript" src="jquery/jquery.js"></script>
	<script src="jquery/scripts.js" type="text/javascript"></script>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<form action="RefreshEditDelete">		
	<table align="center" class="table" border="1">
		<thead>
			<tr>				
				<td>Name</td>
				<td>Surname</td>
				<td>Email</td>
				<td>Birthday</td>
				<td>Amount of money</td>
				<td>Address</td>
				<td>Select</td>
			</tr>
		</thead>
		<c:forEach var="bean" items="${usersBeanList}">
			<tr>				
				<td>${bean.name}</td>
				<td>${bean.surname}</td>
				<td>${bean.email}</td>	
				<td><fmt:formatDate value="${bean.birthday}" pattern="dd.MM.yyyy" /></td>
				<td>${bean.amountOfMoney}</td>	
				<td>${bean.address}</td>	
				<td><input type="checkbox" name="userId" value="${bean.id}"/></td>
				
			</tr>
		</c:forEach>
	</table>
	<input type="submit" name="action" value="Refresh" class="btn btn-primary btn-mini" />
	<input type="submit" name="action" value="Edit" class="btn btn-primary btn-mini" />
	<input type="submit" name="action" value="Delete" class="btn btn-primary btn-mini" />	
</form>	
<br><br>

<c:if test="${message == 'Please select row to delete'}" >
	<div id="coolmenu" align="center" class="errorMsg">		
		Please select row to delete	
	</div>		
</c:if>	
<c:if test="${message == 'Row was deleted'}" >
	<div id="coolmenu" align="center" class="successMsg">		
		Row was deleted
	</div>		
</c:if>	

<c:if test="${message == 'User was updated'}" >
	<div id="coolmenu" align="center" class="successMsg">		
		User was updated
	</div>		
</c:if>
<c:if test="${message == 'User was added'}" >
	<div id="coolmenu" align="center" class="successMsg">		
		User was added
	</div>		
</c:if>
<c:if test="${message == 'Canceled'}" >
	<div id="coolmenu" align="center" class="successMsg">		
		Canceled
	</div>		
</c:if>										
<br>
<%@ include file="jspf/footer.jspf"%>
</body>
</html>
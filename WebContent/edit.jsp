<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Edit</title>
<link rel="stylesheet" type="text/css" media="screen" href="style/st4.css"/>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
<%@ include file="/js/validation.js"%>
</script>
</head>
<body>
<div class="editForm">
	<form  id="settings_form" action="Edit" name="frm" ONSUBMIT="return validateForm()">
		<input name="id" type="hidden" value="${user.id}" />
		
		<label>Name</label><br />
		<input class="form-control form-control-inline" size="10" name="name" id="name" value="${user.name}"><br />
		
		<label>Surname</label><br />
		<input class="form-control" name="surname" id="surname" value="${user.surname}"><br />
		
		<label>Email</label><br />
		<input class="form-control" name="email" id="email" value="${user.email}"><br />
		
		<label>Birthday</label><br />
		<input type="date" class="form-control" name="birthday" id="birthday" value="${user.birthday}" ><br />
		
		<label>Amount of money</label><br />
		<input class="form-control" name="amountOfMoney" id="amountOfMoney" value="${user.amountOfMoney}" ><br />
		
		<label>Address</label><br />
		<input class="form-control" name="address" id="address" value="${user.address}" ><br />
		<br>
		
		<c:if test="${message != 'Not any row is selected '}" >				
			<input type="submit" name="action" value="Save" class="btn btn-primary btn-mini" />				
		</c:if>
		<input type="submit" name="action" value="Add" class="btn btn-primary btn-mini" />
		<input type="submit" name="action" value="Cancel" class="btn btn-primary btn-mini" />
		

	</form>
</div>
</body>
</html>
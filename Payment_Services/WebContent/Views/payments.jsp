<!--------------------------------------File History------------------------------------------------
----------------------------------------------------------------------------------------------------
	DATE		USER		CHANGE
---------------------------------------------------------------------------------------------------- 
	30/04/20	IT16109254	Created
	30/04/20	IT16109254	Added References
	01/05/20	IT16109254	Added Data table
 ---------------------------------------------------------------------------------------------------
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Styles -->
<link rel="stylesheet" href="Views/bootstrap.min.css">

<!-- Scripts -->
<script src="Components/jquery-3.5.0.min.js"></script>
<script src="Components/payments.js"></script>
<!------------------------------------------------------------------------------------------------>

</head>
<body>
	<div class="jumbotron text-center">
		<h1>Payments</h1>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm">
				<button id="btnNew" type="button" class="btn btn-primary">New</button>
			</div>
		</div>
		<div class="row">
			<div class="col-sm">
				<table class="table" id="tblPayments">
					<thead>
						<tr>
							<th>Payment Id</th>
							<th>User Id</th>
							<th>Appointment Id</th>
							<th>Date</th>
							<th>Type</th>
							<th>Method</th>
							<th>Status</th>
							<th>Amount</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
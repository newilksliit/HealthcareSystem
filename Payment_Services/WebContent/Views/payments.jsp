<!--------------------------------------File History------------------------------------------------
----------------------------------------------------------------------------------------------------
	DATE		USER		CHANGE
---------------------------------------------------------------------------------------------------- 
	30/04/20	IT16109254	Created
	30/04/20	IT16109254	Added References
	01/05/20	IT16109254	Added Data table
	03/05/20	IT16109254	Modified Data table
	05/05/20	IT16109254	Added Insert/Update modal
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
<script src="Components/bootstrap.min.js"></script>
<script src="Components/payments.js"></script>
<!------------------------------------------------------------------------------------------------>

</head>
<body>
	<div class="jumbotron text-center"
		style="background-color: RoyalBlue; color: white">
		<h1>Payments</h1>
	</div>
	<div class="container" style="background-color: Chartreuse;">
		<p>Database Connection:</p>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-1">
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
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody id="tblPaymentsBody"></tbody>
				</table>
			</div>
		</div>
	</div>

	<!-- Button trigger modal >
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">Launch demo modal</button-->

	<!-- Modal New Payment-->
	<div class="modal fade" id="modalPayment" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header"
					style="background-color: blue; color: white;">
					<h5 class="modal-title" id="exampleModalLabel">New Payment</h5>
					<button type="button" class="close" data-dismiss="modal"
						style="color: white;" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="paymentId">Payment ID:</label> <input type="text" readonly="readonly"
								class="form-control" id="paymentId">
							<!--small id="emailHelp" class="form-text text-muted">description</small-->
						</div>
						<div class="form-group">
							<label for="userId">User ID:</label> <input type="text"
								class="form-control" id="userId" placeholder="Enter User ID">
							<!--small id="emailHelp" class="form-text text-muted">description</small-->
						</div>
						<div class="form-group">
							<label for="appointmentId">Appointment Id</label> <input
								type="text" class="form-control" id="appointmentId"
								placeholder="Enter Appointment Id">
						</div>

						<div class="form-group">
							<label for="date">Date</label> <input class="form-control"
								type="date" value="" id="date">
						</div>
						<div class="form-group">
							<label for="type">Type</label> <select
								class="custom-select mb-2 mr-sm-2 mb-sm-0" id="type">
								<option selected>Choose...</option>
								<option value="ONLINE">ONLINE</option>
								<option value="MANUAL">MANUAL</option>
							</select>
						</div>
						<div class="form-group">
							<label for="method">Method</label> <select
								class="custom-select mb-2 mr-sm-2 mb-sm-0" id="method">
								<option selected>Choose...</option>
								<option value="CASH">CASH</option>
								<option value="DEBIT">DEBIT</option>
								<option value="CHEQUE">CHEQUE</option>
							</select>
						</div>
						<div class="form-group">
							<label for="status">Type</label> <select
								class="custom-select mb-2 mr-sm-2 mb-sm-0" id="status">
								<option selected>Choose...</option>
								<option value="PENDING">PENDING</option>
								<option value="PAID">PAID</option>
								<option value="RETURNED">RETURNED</option>
							</select>
						</div>

						<div class="form-group">
							<label for="amount">Amount</label> <input type="number"
								class="form-control" id="amount" placeholder="Enter Amount">
						</div>

						<!-- button type="submit" class="btn btn-primary">Submit</button -->
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="btnSave" type="button" class="btn btn-primary">Save</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
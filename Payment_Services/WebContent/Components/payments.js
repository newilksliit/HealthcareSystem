/*******************************************************************************
 * File History************************************
 * ***************************************************************************************************
 */
// DATE USER CHANGE
// *
// ***************************************************************************************************
// * 30/04/20 IT16109254 Created
// * 01/05/20 IT16109254 Added btnNew click event
// * 03/05/20 IT16109254 Added load_table function
// * 05/05/20 IT16109254 Implemented insert,update functions
// *
// ***************************************************************************************************
$(document).ready(function() {
	$("#btnNew").click(btnNew_click);
	$('.alert-danger').hide();
	$('.alert-success').hide()
	load_table();
});

function btnNew_click() {
	$("#modalPayment").modal();
	$("#btnSave").off("click");
	$("#btnSave").click(newPayment);
	$("#date").val(new Date().toLocaleDateString("en-US"));
}

function btnDelete_click(pId) {
	var paymentObj = {
			"paymentId" : pId,
		};

		$.ajax({
			url : "/Payment_Services/services/paymentAPI",
			method : "DELETE",
			contentType : "application/json",
			data : JSON.stringify(paymentObj)
		}).done(function(data) {
			$('.alert-success p').text(data.responseText);
			$('.alert-success').show();
			console.log('Success:' + data);
		}).fail(function(data) {
			$('.alert-danger p').text(data.responseText);
			$('.alert-danger').show();
			console.log(data.responseText);
		}).always(function() {
			load_table();
		});
}

function btnUpdate_click(pId) {
	$("#modalPayment").modal();
	$("#btnSave").off("click");
	$("#btnSave").click(updatePayment);

	$.getJSON('/Payment_Services/services/paymentAPI', function(data,
			status, jqXHR) {
		p=data.filter(item=>item.paymentId==pId)[0];
		$("#paymentId").val(p.paymentId);
		$("#userId").val(p.userId);
		$("#appointmentId").val(p.appointmentId);
		$("#date").val(new Date(p.date).toLocaleDateString("en-US"));
		$("#type").val(p.type);
		$("#method").val(p.method);
		$("#status").val(p.status);
		$("#amount").val(p.amount);
	});
}

function newPayment() {
	var paymentObj = {
		"userId" : $("#userId").val(),
		"appointmentId" : $("#appointmentId").val(),
		"date" : $("#date").val(),
		"type" : $("#type").val(),
		"method" : $("#method").val(),
		"status" : $("#status").val(),
		"amount" : parseInt($("#amount").val())
	};

	$.ajax({
		url : "/Payment_Services/services/paymentAPI",
		method : "POST",
		contentType : "application/json",
		data : JSON.stringify(paymentObj)
	}).done(function(data) {
		$('.alert-success p').text(data.responseText);
		$('.alert-success').show();
		console.log('Success:' + data);
	}).fail(function(data) {
		$('.alert-danger p').text(data.responseText);
		$('.alert-danger').show();
		console.log(data.responseText);
	}).always(function() {
		load_table();
	});
}

function updatePayment() {
	var paymentObj = {
			"paymentId" : $("#paymentId").val(),
			"userId" : $("#userId").val(),
			"appointmentId" : $("#appointmentId").val(),
			"type" : $("#type").val(),
			"method" : $("#method").val(),
			"status" : $("#status").val(),
			"amount" : parseInt($("#amount").val())
		};

		$.ajax({
			url : "/Payment_Services/services/paymentAPI",
			method : "PUT",
			contentType : "application/json",
			data : JSON.stringify(paymentObj)
		}).done(function(data) {
			$('.alert-success p').text(data.responseText);
			$('.alert-success').show();
			console.log('Success:' + data);
		}).fail(function(data) {
			$('.alert-danger p').text(data.responseText);
			$('.alert-danger').show();
			console.log(data.responseText);
		}).always(function() {
			load_table();
		});
}

function load_table() {
	$
			.getJSON(
					'/Payment_Services/services/paymentAPI',
					function(data, status, jqXHR) {
						console.log(data.filter(item=>item.paymentId==1));
						console.log(status);

						var tBody = $("#tblPaymentsBody");
						var tdata = "";

						$
								.each(
										data,
										function(index, payment) {// iterate
											// through each
											// item of
											// data[] array
											tdata += "<tr>";

											$
													.each(
															payment,
															function(key, value) {// iterate
																// through
																// each
																// attribute of
																// value object
																if (key == "date") {
																	value = new Date(
																			value)
																			.toLocaleDateString("en-US");
																}
																tdata += "<td>";
																tdata += value;
																tdata += "</td>";
															});
											tdata += "<td><button type='button' class='btn btn-secondary' onclick='btnUpdate_click("
													+ payment.paymentId
													+ ")'>Update</button></td>";
											tdata += "<td><button type='button' class='btn btn-danger' onclick='btnDelete_click("
													+ payment.paymentId
													+ ")'>Delete</button></td>";
											tdata += "</tr>";
										});
						tBody.html(tdata);
					});
}
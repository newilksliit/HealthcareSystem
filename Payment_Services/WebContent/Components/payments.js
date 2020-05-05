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
	load_table();
});

function btnNew_click() {
	$("#modalPayment").modal();
	$("#btnSave").off("click");
	$("#btnSave").click(newPayment);
}

function btnDelete_click(pId) {
	alert(pId);
}

function btnUpdate_click(pId) {
	$("#modalPayment").modal();
	$("#btnSave").off("click");
	$("#btnSave").click(updatePayment);
}

function newPayment(){
}

function updatePayment(){
	
}

function load_table() {
	$
			.getJSON(
					'/Payment_Services/services/paymentAPI',
					function(data, status, jqXHR) {
						console.log(data[0]);
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
						tBody.append(tdata);
					});
}
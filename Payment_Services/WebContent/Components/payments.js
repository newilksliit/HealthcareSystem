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
// *
// ***************************************************************************************************

$(document).ready(function() {
	$("#btnNew").click(btnNew_click);
	load_table();
});

function btnNew_click() {
	/*
	 * $("#tblPayments").append( "<tbody>" + "<tr>" + "<td>111</td>" + "</tr>" + "</tbody>");
	 */
}

function load_table() {
	$.getJSON('/Payment_Services/services/payments', function(data, status,
			jqXHR) {
		console.log(data[0]);
		console.log(status);
		var tBody = $("#tblPaymentsBody");
		var tdata = "";

		$.each(data, function(index, payment) {// iterate through each item of
			// data[] array
			tdata += "<tr>";

			$.each(payment, function(key, value) {// iterate through each
				// attribute of value object
				if (key == "date") {
					value = new Date(value).toLocaleDateString("en-US");
				}
				tdata += "<td>";
				tdata += value;
				tdata += "</td>";
			});

			tdata += "</tr>";
		});
		tBody.append(tdata);
	});
}
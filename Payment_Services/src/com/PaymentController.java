////////////////////////		File History			//////////////////
//------------------------------------------------------------------------
//Date		User			Description
//------	-----------		----------------------------------------------
//150420	IT16109254		:Created
//////////////////////////////////////////////////////////////////////////
package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.Payment.Method;
import com.Payment.Status;
import com.Payment.Type;

public class PaymentController {

	/* Database connection */
	private static String url = "127.0.0.1:3306/healthcare";
	private static String username = "root";
	private static String password = "root";

	private static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://" + url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static List<Payment> readItems() {

		List<Payment> output = new ArrayList<Payment>();

		try {
			Connection con = connect();
			if (con == null) {
				con.close();
				throw new Exception("Error connecting to database");
			}

			String query = "select * from tblPayment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				Payment item = new Payment();

				item.paymentId = rs.getInt("payment_id");
				item.userId = rs.getString("user_id");
				item.appointmentId = rs.getString("appointment_id");
				item.date = rs.getDate("date");
				item.type = ((rs.getString("type").equals("ONLINE")) ? Type.ONLINE : Type.MANUAL);
				item.method = (rs.getString("method").equals("CASH")) ? Method.CASH
						: ((rs.getString("method").equals("CHEQUE") ? Method.CHEQUE : Method.DEBIT));
				item.status = (rs.getString("status").equals("PENDING") ? Status.PENDING
						: ((rs.getString("status")).equals("PAID") ? Status.PAID : Status.RETURNED));
				item.amount = rs.getDouble("amount");
				// Add into the list
				output.add(item);
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return output;
	}

	public static Response insertItem(Payment p) {
		Response response;
		try {
			Connection con = connect();
			if (con == null) {
				return Response.serverError().entity("Error while connecting to the database for inserting").build();
			}
			// create a prepared statement
			String query = "INSERT INTO `tblpayment` (`user_id`, `appointment_id`, `type`, `method`, `status`, `amount` ) VALUES (?,?,?,?,?,?);";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, p.userId);
			preparedStmt.setString(2, p.appointmentId);
			preparedStmt.setString(3, p.type.toString());
			preparedStmt.setString(4, p.method.toString());
			preparedStmt.setString(5, p.status.toString());
			preparedStmt.setDouble(6, p.amount);

			// execute the statement
			preparedStmt.execute();
			con.close();
			response = Response.ok().entity("Payment inserted sucessfully").build();
		} catch (Exception e) {
			response = Response.serverError().entity(e).build();
			System.err.println(e.getMessage());
		}
		return response;
	}

	public static Response updateItem(Payment p) {
		Response response;
		try {
			Connection con = connect();
			if (con == null) {
				return Response.serverError().entity("Error while connecting to the database for updating").build();
			}
			// create a prepared statement
			String query = "UPDATE `tblpayment` SET `user_id` = ?, `appointment_id` = ?, `type` = ?, `method` = ?, `status` = ?, `amount` = ? WHERE (`payment_id` = ?);";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setString(1, p.userId);
			preparedStmt.setString(2, p.appointmentId);
			preparedStmt.setString(3, p.type.toString());
			preparedStmt.setString(4, p.method.toString());
			preparedStmt.setString(5, p.status.toString());
			preparedStmt.setDouble(6, p.amount);

			preparedStmt.setInt(7, p.paymentId);
			// execute the statement
			preparedStmt.execute();
			con.close();
			response = Response.ok().entity("Updated successfully").build();
		} catch (Exception e) {
			response = Response.serverError().entity(e).build();
			System.err.println(e.getMessage());
		}
		return response;
	}

	public static Response deleteItem(Payment p) {
		Response output;
		try {
			Connection con = connect();
			if (con == null) {
				return Response.serverError().entity("Error while connecting to the database for deleting").build();
			}
			// create a prepared statement
			String query = "delete from `tblpayment` where `payment_id` = ?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, p.paymentId);
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = Response.ok().entity("Deleted successfully").build();
		} catch (Exception e) {
			output = Response.serverError().entity(e).build();
			System.err.println(e.getMessage());
		}
		return output;
	}
}

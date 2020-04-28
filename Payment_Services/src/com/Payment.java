////////////////////////		File History			//////////////////
//------------------------------------------------------------------------
//Date		User			Description
//------	-----------		----------------------------------------------
//150420	IT16109254		:Created
//150420	IT16109254		:Added attributes
//////////////////////////////////////////////////////////////////////////
package com;

import java.sql.Date;

public class Payment {

	//////////// enums /////////////
	public enum Type {
		ONLINE, MANUAL
	}

	public enum Method {
		CASH, DEBIT, CHEQUE
	}

	public enum Status {
		PENDING, PAID, RETURNED
	}
	/////////// end /////////////

	//////////// attributes /////
	public int paymentId;
	public String userId;
	public String appointmentId;
	public Date date;
	public Type type;
	public Method method;
	public Status status;
	public double amount;
	//////////// end//////////////////////

	/////////// getters setters ///////

	///////////// end///////////////////////

}
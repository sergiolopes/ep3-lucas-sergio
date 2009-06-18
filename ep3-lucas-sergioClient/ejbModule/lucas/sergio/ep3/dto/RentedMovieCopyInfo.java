package lucas.sergio.ep3.dto;

import java.io.Serializable;
import java.util.Date;

public class RentedMovieCopyInfo implements Serializable {

	private static final long serialVersionUID = -2923083183675904347L;

	private long movieCopyId;
	private long customerId;
	private String customerName;
	private String customerPhone;
	private Date returnDate;

	public long getMovieCopyId() {
		return movieCopyId;
	}

	public void setMovieCopyId(long movieCopyId) {
		this.movieCopyId = movieCopyId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getCustomerId() {
		return customerId;
	}

}

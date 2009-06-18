package lucas.sergio.ep3.web.customer;

import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

import lucas.sergio.ep3.bean.CustomerBeanRemote;
import lucas.sergio.ep3.dto.CustomerDTO;

public class CustomerHandler {

	private CustomerDTO customer = new CustomerDTO();

	@EJB
	private CustomerBeanRemote customerBean;
	
	public void register(ActionEvent event) {
		this.customerBean.registerCustomer(customer);
		this.customer = new CustomerDTO();
	}
	
	public CustomerDTO getCustomer() {
		return customer;
	}
}

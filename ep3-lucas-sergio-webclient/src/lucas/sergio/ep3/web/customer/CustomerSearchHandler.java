package lucas.sergio.ep3.web.customer;

import java.util.List;

import javax.ejb.EJB;

import lucas.sergio.ep3.bean.CustomerBeanRemote;
import lucas.sergio.ep3.dto.CustomerDTO;

public class CustomerSearchHandler {

	@EJB
	private CustomerBeanRemote customerBean;
	
	private String search = "";
	private CustomerSearch searchType = CustomerSearch.NAME;
	
	public List<CustomerDTO> getCustomers() {
		return searchType.search(customerBean, search);
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchType() {
		return searchType.toString();
	}

	public void setSearchType(String searchType) {
		this.searchType = CustomerSearch.valueOf(searchType);
	}
	
	
}

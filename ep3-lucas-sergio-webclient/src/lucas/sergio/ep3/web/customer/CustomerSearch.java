package lucas.sergio.ep3.web.customer;

import java.util.Arrays;
import java.util.List;

import lucas.sergio.ep3.bean.CustomerBeanRemote;
import lucas.sergio.ep3.dto.CustomerDTO;

/**
 * Estrategias de busca de Customers
 * @see GoF#Strategy
 */
public enum CustomerSearch {
	ID {
		public List<CustomerDTO> search(CustomerBeanRemote bean, String value) {
			return Arrays.asList(bean.searchById(Long.parseLong(value)));
		}
	}, 
	NAME {
		public List<CustomerDTO> search(CustomerBeanRemote bean, String value) {
			return bean.searchByName(value);
		}
	}, 
	PHONE {
		public List<CustomerDTO> search(CustomerBeanRemote bean, String value) {
			return bean.searchByPhone(value);
		}
	};
	
	public abstract List<CustomerDTO> search(CustomerBeanRemote bean, String value);
}

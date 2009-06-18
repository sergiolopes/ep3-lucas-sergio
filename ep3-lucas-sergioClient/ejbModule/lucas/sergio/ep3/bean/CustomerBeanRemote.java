package lucas.sergio.ep3.bean;
import java.util.List;

import javax.ejb.Remote;

import lucas.sergio.ep3.dto.CustomerDTO;

@Remote
public interface CustomerBeanRemote {

	void registerCustomer(CustomerDTO customer);

	CustomerDTO searchById(Long id);

	List<CustomerDTO> searchByName(String name);

	List<CustomerDTO> searchByPhone(String phone);

}

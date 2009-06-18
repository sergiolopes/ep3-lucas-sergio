package lucas.sergio.ep3.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lucas.sergio.ep3.dto.CustomerDTO;
import lucas.sergio.ep3.model.Customer;

/**
 * Session Bean implementation class CustomerBean
 */
@Stateless
public class CustomerBean implements CustomerBeanRemote {

	@PersistenceContext
	private EntityManager manager;

	public void registerCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setName(customerDTO.getName());
		customer.setPhone(customerDTO.getPhone());
		manager.persist(customer);
	}

	public CustomerDTO searchById(Long id) {
		return createDTO(manager.find(Customer.class, id));
	}

	private CustomerDTO createDTO(Customer customer) {
		CustomerDTO dto = new CustomerDTO();
		dto.setId(customer.getId());
		dto.setName(customer.getName());
		dto.setPhone(customer.getPhone());
		return dto;
	}

	public List<CustomerDTO> searchByName(String name) {
		return transformList(manager.createQuery(
				"select c from Customer c where c.name like :name").setParameter(
				"name", "%" + name + "%").getResultList());
	}

	public List<CustomerDTO> searchByPhone(String phone) {
		return transformList(manager.createQuery(
				"select c from Customer c where c.phone = :phone")
				.setParameter("phone", phone).getResultList());

	}

	private List<CustomerDTO> transformList(List<Customer> list) {
		List<CustomerDTO> result = new ArrayList<CustomerDTO>();
		for (Customer customer : list) {
			result.add(createDTO(customer));
		}
		return result;
	}

}

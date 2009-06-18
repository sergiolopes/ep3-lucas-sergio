package lucas.sergio.ep3.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1188630388229014817L;
	
	private Long id;
	private String name;
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}

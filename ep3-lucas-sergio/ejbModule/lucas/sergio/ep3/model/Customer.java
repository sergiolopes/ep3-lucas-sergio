package lucas.sergio.ep3.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
public class Customer implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String phone;
	@OneToMany(mappedBy = "taker")
	private Set<MovieCopy> takenMovieCopies;
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
	public Set<MovieCopy> getTakenMovieCopies() {
		return takenMovieCopies;
	}
	public void setTakenMovieCopies(Set<MovieCopy> takenMovieCopies) {
		this.takenMovieCopies = takenMovieCopies;
	}
}

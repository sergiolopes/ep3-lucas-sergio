package lucas.sergio.ep3.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionOfElements;

/**
 * Entity implementation class for Entity: Movie
 *
 */
@Entity
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String director;
	@CollectionOfElements
	private List<String> genre;
	@CollectionOfElements
	private List<String> cast;
	private Short year;
	private Short duration;

	@OneToMany(mappedBy = "movie")
	private Set<MovieCopy> copies;

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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	public Short getYear() {
		return year;
	}

	public void setYear(Short year) {
		this.year = year;
	}

	public Short getDuration() {
		return duration;
	}

	public void setDuration(Short duration) {
		this.duration = duration;
	}

	public Set<MovieCopy> getCopies() {
		return copies;
	}

	public void setCopies(Set<MovieCopy> copies) {
		this.copies = copies;
	}
}

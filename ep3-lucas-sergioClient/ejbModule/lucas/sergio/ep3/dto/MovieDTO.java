package lucas.sergio.ep3.dto;

import java.io.Serializable;
import java.util.List;

public class MovieDTO implements Serializable {

	private static final long serialVersionUID = 7772704559895629726L;

	private long id;
	private String name;
	private String director;
	private List<String> genre;
	private List<String> cast;
	private short year;
	private short duration;
	private List<Long> inStoreCopies; // ids dos exemplares disponíveis
	private List<RentedMovieCopyInfo> rentedCopies;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public List<Long> getInStoreCopies() {
		return inStoreCopies;
	}

	public void setInStoreCopies(List<Long> inStoreCopies) {
		this.inStoreCopies = inStoreCopies;
	}

	public List<RentedMovieCopyInfo> getRentedCopies() {
		return rentedCopies;
	}

	public void setRentedCopies(List<RentedMovieCopyInfo> rentedCopies) {
		this.rentedCopies = rentedCopies;
	}

}

package lucas.sergio.ep3.bean;
import java.util.List;

import javax.ejb.Remote;

import lucas.sergio.ep3.dto.MovieDTO;

@Remote
public interface MovieBeanRemote {

	void registerMovie(MovieDTO movie);

	MovieDTO searchById(Long id);

	List<MovieDTO> searchByName(String name);

	List<MovieDTO> searchByDirector(String director);

	List<MovieDTO> searchByGenreAndYear(String genre, short year);

}

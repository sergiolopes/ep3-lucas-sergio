package lucas.sergio.ep3.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lucas.sergio.ep3.dto.MovieDTO;
import lucas.sergio.ep3.model.Movie;

/**
 * Session Bean implementation class MovieBean
 */
@Stateless
public class MovieBean implements MovieBeanRemote {

	@PersistenceContext
	private EntityManager manager;

	public void registerMovie(MovieDTO movieDTO) {
		Movie movie = new Movie();
		movie.setCast(movieDTO.getCast());
		movie.setDirector(movieDTO.getDirector());
		movie.setDuration(movieDTO.getDuration());
		movie.setGenre(movieDTO.getGenre());
		movie.setName(movieDTO.getName());
		movie.setYear(movieDTO.getYear());
		manager.persist(movie);
	}

	@Override
	public List<MovieDTO> searchByDirector(String director) {
		return transformList(manager.createQuery("select m from Movie m where m.director like :director")
			.setParameter("director", "%"+director+"%").getResultList());
	}

	@Override
	public List<MovieDTO> searchByGenreAndYear(String genre, short year) {
		return transformList(manager.createQuery("select m from Movie m where " +
				":genre in elements(m.genre) and m.year = :year")
			.setParameter("genre", genre)
			.setParameter("year", year).getResultList());
	}

	@Override
	public MovieDTO searchById(Long id) {
		return createDTO(manager.find(Movie.class, id));
	}

	@Override
	public List<MovieDTO> searchByName(String name) {
		return transformList(manager.createQuery("select m from Movie m where m.name like :name")
		.setParameter("name", "%"+name+"%").getResultList());
	}

	private MovieDTO createDTO(Movie movie) {
		MovieDTO dto = new MovieDTO();
		dto.setCast(movie.getCast());
		movie.getCast().toString();
		dto.setDirector(movie.getDirector());
		dto.setDuration(movie.getDuration());
		dto.setGenre(movie.getGenre());
		movie.getGenre().toString();
		dto.setId(movie.getId());
		dto.setName(movie.getName());
		dto.setYear(movie.getYear());
		return dto;
	}
	private List<MovieDTO> transformList(List<Movie> movies) {
		List<MovieDTO> result = new ArrayList<MovieDTO>();
		for (Movie movie : movies) {
			result.add(createDTO(movie));
		}
		return result;
	}
}

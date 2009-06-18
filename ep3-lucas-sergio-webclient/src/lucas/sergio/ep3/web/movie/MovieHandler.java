package lucas.sergio.ep3.web.movie;

import java.util.Arrays;

import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

import lucas.sergio.ep3.bean.MovieBeanRemote;
import lucas.sergio.ep3.dto.MovieDTO;

public class MovieHandler {

	private MovieDTO movie = new MovieDTO();
	private String genres = "";
	private String cast = "";
	
	@EJB
	private MovieBeanRemote movieBean;
	
	public void register(ActionEvent event) {
		movie.setGenre(Arrays.asList(genres.split("\n|\r\n")));
		movie.setCast(Arrays.asList(cast.split("\n|\r\n")));
		
		movieBean.registerMovie(movie);
		
		movie = new MovieDTO();
		genres = "";
		cast = "";	
	}
	
	public MovieDTO getMovie() {
		return movie;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}
}

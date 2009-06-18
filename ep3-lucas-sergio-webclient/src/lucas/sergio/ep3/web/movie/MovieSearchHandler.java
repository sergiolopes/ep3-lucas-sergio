package lucas.sergio.ep3.web.movie;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.model.SelectItem;

import lucas.sergio.ep3.bean.MovieBeanRemote;
import lucas.sergio.ep3.dto.MovieDTO;

public class MovieSearchHandler {

	@EJB
	private MovieBeanRemote movieBean;
	
	private String search = "";
	private MovieSearch searchType = MovieSearch.NAME;
	
	public List<MovieDTO> getMovies() {
		return searchType.search(movieBean, search);
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchType() {
		return searchType.toString();
	}

	public void setSearchType(String searchType) {
		this.searchType = MovieSearch.valueOf(searchType);
	}
	
	public List<SelectItem> getMovieItems() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		
		for (MovieDTO movie : getMovies()) {
			list.add(new SelectItem(movie.getId(), movie.getName()));
		}
		
		return list;
	}
	
}

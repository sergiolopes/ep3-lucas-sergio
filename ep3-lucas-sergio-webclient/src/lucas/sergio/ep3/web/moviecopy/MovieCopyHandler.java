package lucas.sergio.ep3.web.moviecopy;

import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

import lucas.sergio.ep3.bean.MovieCopyBeanRemote;
import lucas.sergio.ep3.dto.MovieCopyDTO;

public class MovieCopyHandler {

	@EJB
	private MovieCopyBeanRemote bean;
	
	private MovieCopyDTO movieCopy = new MovieCopyDTO();
	public boolean cadastrado = false;
	
	public void register(ActionEvent event) {
		bean.registerMovieCopy(movieCopy);
		this.movieCopy = new MovieCopyDTO();
		cadastrado = true;
	}
	
	public MovieCopyDTO getMovieCopy() {
		return movieCopy;
	}
	
	public boolean isCadastrado() {
		return cadastrado;
	}
}

package lucas.sergio.ep3.web.rent;

import javax.ejb.EJB;
import javax.faces.event.ActionEvent;

import lucas.sergio.ep3.bean.MovieCopyBeanRemote;
import lucas.sergio.ep3.dto.RentedMovieCopyInfo;

public class RentHandler {

	@EJB
	private MovieCopyBeanRemote movieCopyBean;
	
	private RentedMovieCopyInfo rentedMovieCopyInfo = new RentedMovieCopyInfo();
	
	public void rentMovieCopy(ActionEvent event) {
		
	}

	public void returnMovieCopy(ActionEvent event) {
		
	}

}

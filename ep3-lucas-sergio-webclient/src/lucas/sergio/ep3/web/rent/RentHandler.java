package lucas.sergio.ep3.web.rent;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import lucas.sergio.ep3.bean.MovieCopyBeanRemote;
import lucas.sergio.ep3.dto.AvailableMovieCopyInfo;
import lucas.sergio.ep3.dto.RentedMovieCopyInfo;

public class RentHandler {

	@EJB
	private MovieCopyBeanRemote movieCopyBean;
	
	private RentedMovieCopyInfo rentedMovieCopy = new RentedMovieCopyInfo();
	
	public List<AvailableMovieCopyInfo> getAvailableMovieCopies() {
		return movieCopyBean.getAvailableMovieCopies();
	}

	public List<RentedMovieCopyInfo> getRentedMovieCopies() {
		return movieCopyBean.getRentedMovieCopies();
	}

	public RentedMovieCopyInfo getRentedMovieCopy() {
		return rentedMovieCopy;
	}
	
	public void rentMovieCopy(ActionEvent event) {
		UIParameter param = (UIParameter) event.getComponent().findComponent("movieCopyInfo");
		AvailableMovieCopyInfo movieCopy = (AvailableMovieCopyInfo) param.getValue();
		
		rentedMovieCopy.setMovieCopyId(movieCopy.getMovieCopyId());
		rentedMovieCopy.setMovieName(movieCopy.getMovieName());
		rentedMovieCopy.setReturnDate(new Date(new Date().getTime() + 24 * 60 * 60 * 1000));
		
		movieCopyBean.rent(rentedMovieCopy);
		
		this.rentedMovieCopy = new RentedMovieCopyInfo();
	}
	
	public void returnMovieCopy(ActionEvent event) {
		UIParameter param = (UIParameter) event.getComponent().findComponent("movieCopyInfo");
		RentedMovieCopyInfo movieCopy = (RentedMovieCopyInfo) param.getValue();
		
		movieCopyBean.returnCopy(movieCopy);
	}

}

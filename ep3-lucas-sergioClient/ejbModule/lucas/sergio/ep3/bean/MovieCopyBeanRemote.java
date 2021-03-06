package lucas.sergio.ep3.bean;
import java.util.List;

import javax.ejb.Remote;

import lucas.sergio.ep3.dto.AvailableMovieCopyInfo;
import lucas.sergio.ep3.dto.MovieCopyDTO;
import lucas.sergio.ep3.dto.RentedMovieCopyInfo;

@Remote
public interface MovieCopyBeanRemote {

	void registerMovieCopy(MovieCopyDTO movieCopy);

	void rent(RentedMovieCopyInfo movieCopy);

	void returnCopy(RentedMovieCopyInfo movieCopy);
	
	List<AvailableMovieCopyInfo> getAvailableMovieCopies();
	
	List<RentedMovieCopyInfo> getRentedMovieCopies();
}

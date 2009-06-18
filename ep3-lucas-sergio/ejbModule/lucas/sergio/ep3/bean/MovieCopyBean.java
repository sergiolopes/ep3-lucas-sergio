package lucas.sergio.ep3.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lucas.sergio.ep3.dto.MovieCopyDTO;
import lucas.sergio.ep3.dto.RentedMovieCopyInfo;
import lucas.sergio.ep3.model.Customer;
import lucas.sergio.ep3.model.Movie;
import lucas.sergio.ep3.model.MovieCopy;
import lucas.sergio.ep3.model.MovieCopy.MediaType;

/**
 * Session Bean implementation class MovieCopyBean
 */
@Stateless
public class MovieCopyBean implements MovieCopyBeanRemote {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void registerMovieCopy(MovieCopyDTO movieCopy) {
		MovieCopy copy = new MovieCopy();
		copy.setMediaType(MediaType.values()[movieCopy.getMediaType()]);
		copy.setMovie(manager.find(Movie.class, movieCopy.getMovieId()));
		manager.persist(copy);
	}

	@Override
	public void rent(RentedMovieCopyInfo movieCopy) {
		MovieCopy copy = manager.find(MovieCopy.class, movieCopy.getMovieCopyId());
		copy.setTaker(manager.find(Customer.class, movieCopy.getCustomerId()));
		copy.setRented(true);
		copy.setReturnDate(movieCopy.getReturnDate());
		manager.merge(copy);
	}

	@Override
	public void returnCopy(RentedMovieCopyInfo movieCopy) {
		MovieCopy copy = manager.find(MovieCopy.class, movieCopy.getMovieCopyId());
		copy.setTaker(null);
		copy.setRented(false);
		manager.merge(copy);
	}

}

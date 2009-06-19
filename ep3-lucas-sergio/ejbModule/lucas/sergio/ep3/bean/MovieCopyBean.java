package lucas.sergio.ep3.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lucas.sergio.ep3.dto.AvailableMovieCopyInfo;
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

	@Override
	public List<AvailableMovieCopyInfo> getAvailableMovieCopies() {
		@SuppressWarnings("unchecked")
		List<MovieCopy> copies = manager
		     .createQuery("select m from MovieCopy m join fetch m.movie where m.rented = null or m.rented = false")
		     .getResultList();
		
		List<AvailableMovieCopyInfo> availables = new ArrayList<AvailableMovieCopyInfo>();

		for (MovieCopy movieCopy : copies) {
			AvailableMovieCopyInfo movieCopyInfo = new AvailableMovieCopyInfo();
			movieCopyInfo.setMovieCopyId(movieCopy.getId());
			movieCopyInfo.setMovieCopyType((short) movieCopy.getMediaType().ordinal());
			movieCopyInfo.setMovieName(movieCopy.getMovie().getName());
			availables.add(movieCopyInfo);
		}
		
		return availables;
	}

	@Override
	public List<RentedMovieCopyInfo> getRentedMovieCopies() {
		@SuppressWarnings("unchecked")
		List<MovieCopy> copies = manager
		     .createQuery("select m from MovieCopy m join fetch m.movie join fetch m.customer where m.rented = true")
		     .getResultList();
		
		List<RentedMovieCopyInfo> rented = new ArrayList<RentedMovieCopyInfo>();

		for (MovieCopy movieCopy : copies) {
			RentedMovieCopyInfo movieCopyInfo = new RentedMovieCopyInfo();
			
			movieCopyInfo.setMovieCopyId(movieCopy.getId());
			movieCopyInfo.setMovieName(movieCopy.getMovie().getName());
			movieCopyInfo.setReturnDate(movieCopy.getReturnDate());
			
			movieCopyInfo.setCustomerId(movieCopy.getTaker().getId());
			movieCopyInfo.setCustomerName(movieCopy.getTaker().getName());
			movieCopyInfo.setCustomerPhone(movieCopy.getTaker().getPhone());
			
			rented.add(movieCopyInfo);
		}
		
		return rented;
	}

}

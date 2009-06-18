package lucas.sergio.ep3.web.movie;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lucas.sergio.ep3.bean.MovieBeanRemote;
import lucas.sergio.ep3.dto.MovieDTO;

/**
 * Estrategias de busca de Movies 
 */
public enum MovieSearch {
	ID {
		public List<MovieDTO> search(MovieBeanRemote bean, String value) {
			return Arrays.asList(bean.searchById(Long.parseLong(value)));
		}
	}, 
	NAME {
		public List<MovieDTO> search(MovieBeanRemote bean, String value) {
			return bean.searchByName(value);
		}
	}, 
	DIRECTOR {
		public List<MovieDTO> search(MovieBeanRemote bean, String value) {
			return bean.searchByDirector(value);
		}
	}, 
	GENRE_AND_YEAR {
		public List<MovieDTO> search(MovieBeanRemote bean, String value) {
			Matcher matcher = Pattern.compile("\\d{4}").matcher(value);
			
			short ano = 0;
			if (matcher.find()) {
				ano = Short.parseShort(matcher.group());
			}
			
			String genre = value.replaceFirst(""+ano, "").trim();
			return bean.searchByGenreAndYear(genre, ano);
		}
	};
	
	public abstract List<MovieDTO> search(MovieBeanRemote bean, String value);
}

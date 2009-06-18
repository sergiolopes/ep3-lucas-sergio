package lucas.sergio.ep3.dto;

import java.io.Serializable;

public class MovieCopyDTO implements Serializable {

	private static final long serialVersionUID = -4168044791631926677L;
	
	private Long copyId;
	private Long movieId;
	private Short mediaType;

	public Long getCopyId() {
		return copyId;
	}

	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Short getMediaType() {
		return mediaType;
	}

	public void setMediaType(Short mediaType) {
		this.mediaType = mediaType;
	}
}

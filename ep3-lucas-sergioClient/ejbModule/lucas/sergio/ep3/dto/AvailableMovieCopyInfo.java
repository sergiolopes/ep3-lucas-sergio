package lucas.sergio.ep3.dto;

import java.io.Serializable;

public class AvailableMovieCopyInfo implements Serializable {

	private static final long serialVersionUID = 1961962915326598559L;
	
	private long movieCopyId;
	private String movieName;
	private short movieCopyType;

	public short getMovieCopyType() {
		return movieCopyType;
	}

	public void setMovieCopyType(short movieCopyType) {
		this.movieCopyType = movieCopyType;
	}

	public long getMovieCopyId() {
		return movieCopyId;
	}

	public void setMovieCopyId(long movieCopyId) {
		this.movieCopyId = movieCopyId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}

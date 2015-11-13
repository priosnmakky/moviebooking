package cbsd.lab11.service;

import java.util.List;

import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Movie;

public interface DateOfMovieService {
	 public void addDateOfMovie(DateOfMovie dateOfMovie);
	    public DateOfMovie getDateOfMovieById(long id);
	    public List<DateOfMovie> getAllDateOfMovie();

	    public List<DateOfMovie> getDateOfMovieBykey(String keyword);
	    public void deleteDateOfMovie(DateOfMovie dateOfMovie);
	    public List<DateOfMovie> selectMovies(Movie movie);
}

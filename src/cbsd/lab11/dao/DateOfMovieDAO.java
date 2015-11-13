package cbsd.lab11.dao;

import java.util.List;


import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Movie;

public interface DateOfMovieDAO {

	
	 void addDateOfMovie(DateOfMovie dateOfMovie);
	 public DateOfMovie getDateOfMovieById(long id);
	    public List<DateOfMovie> getAllDateOfMovie();

	    public List<DateOfMovie> getDateOfMovieBykey(String keyword);
	    public void deleteDateOfMovie(DateOfMovie dateOfMovie);
	    public List<DateOfMovie>selectMovie(Movie movie);
}

package cbsd.lab11.service;

import java.util.List;


import cbsd.lab11.entity.Movie;



public interface MovieService {
	 public void addMovie(Movie movie);
	    public Movie getMovieById(long id);
	    public List<Movie> getAllMovie();

	    public List<Movie> getMovieBykey(String keyword);
	    public void deleteMovie(Movie movie);

}

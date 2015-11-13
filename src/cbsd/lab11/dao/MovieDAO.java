package cbsd.lab11.dao;

import java.util.List;

import org.springframework.stereotype.Repository;


import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.User;
@Repository
public interface MovieDAO {
	 void addMovie(Movie movie);
	 public Movie getMovieById(long id);
	    public List<Movie> getAllMovie();

	    public List<Movie> getMovieBykey(String keyword);
	    public void deleteMovie(Movie movie);

}

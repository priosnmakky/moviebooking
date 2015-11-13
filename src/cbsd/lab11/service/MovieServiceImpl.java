package cbsd.lab11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cbsd.lab11.dao.MovieDAO;
import cbsd.lab11.entity.Movie;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
    MovieDAO movieDAO;
  
    
	@Override
	  @Transactional
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieDAO.addMovie(movie);
		
	}


	@Override
	@Transactional
	public Movie getMovieById(long id) {
		// TODO Auto-generated method stub
		Movie movie=movieDAO.getMovieById(id);
		
		return movie;
	}


	@Override
	@Transactional
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return movieDAO.getAllMovie();
	}


	@Override
	@Transactional
	public List<Movie> getMovieBykey(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public void deleteMovie(Movie movie) {
		 movieDAO.deleteMovie(movie);;
		
	}

	

}

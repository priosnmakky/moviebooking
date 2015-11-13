package cbsd.lab11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cbsd.lab11.dao.BranchDAO;
import cbsd.lab11.dao.DateOfMovieDAO;
import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Movie;
@Service
public class DateOfMovieServiceImpl implements DateOfMovieService{

	@Autowired
    DateOfMovieDAO dateOfMovieDAO;
	@Override
	@Transactional
	public void addDateOfMovie(DateOfMovie dateOfMovie) {
		// TODO Auto-generated method stub
		
		 dateOfMovieDAO.addDateOfMovie(dateOfMovie);
	}

	@Override
	@Transactional
	public DateOfMovie getDateOfMovieById(long id) {
		// TODO Auto-generated method stub
		return  dateOfMovieDAO.getDateOfMovieById(id);
	}

	@Override
	@Transactional
	public List<DateOfMovie> getAllDateOfMovie() {
		// TODO Auto-generated method stub
		return  dateOfMovieDAO.getAllDateOfMovie();
	}

	@Override
	@Transactional
	public List<DateOfMovie> getDateOfMovieBykey(String keyword) {
		// TODO Auto-generated method stub
		return  dateOfMovieDAO.getDateOfMovieBykey(keyword);
	}

	@Override
	@Transactional
	public void deleteDateOfMovie(DateOfMovie dateOfMovie) {
		// TODO Auto-generated method stub
		dateOfMovieDAO.deleteDateOfMovie(dateOfMovie);
		
	}

	@Override
	@Transactional
	public List<DateOfMovie> selectMovies(Movie movie) {
		// TODO Auto-generated method stub
	//	dateOfMovieDAO.seachMovie(dateOfMovie);
		return dateOfMovieDAO.selectMovie(movie);
	}


	
}

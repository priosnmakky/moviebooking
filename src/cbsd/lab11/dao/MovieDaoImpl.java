package cbsd.lab11.dao;


import cbsd.lab11.entity.Movie;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MovieDaoImpl implements MovieDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addMovie(Movie movie) {
		sessionFactory.getCurrentSession().saveOrUpdate(movie);
		
	}

	@Override
	public Movie getMovieById(long id) {
		// TODO Auto-generated method stub
		  Movie movie = (Movie) sessionFactory.getCurrentSession().createQuery ("from Movie m where m.id =" + id +"").uniqueResult();

		return movie;
	}

	@Override
	public List<Movie> getAllMovie() {
		   List movieList = sessionFactory.getCurrentSession().createQuery("from Movie").list();



	        return movieList;

	}

	@Override
	public List<Movie> getMovieBykey(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMovie(Movie movie) {
		sessionFactory.getCurrentSession().delete(movie);
		
	}
	
	

}

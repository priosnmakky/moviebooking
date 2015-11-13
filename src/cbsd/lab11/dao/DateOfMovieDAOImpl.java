package cbsd.lab11.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Movie;

@Repository
public class DateOfMovieDAOImpl implements DateOfMovieDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addDateOfMovie(DateOfMovie dateOfMovie) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(dateOfMovie);
		
	}

	@Override
	public DateOfMovie getDateOfMovieById(long id) {
		// TODO Auto-generated method stub
		DateOfMovie dateOfMovie = (DateOfMovie) sessionFactory.getCurrentSession().createQuery ("from DateOfMovie d where d.id =" + id +"").uniqueResult();
		return  dateOfMovie ;
		
	}

	@Override
	public List<DateOfMovie> getAllDateOfMovie() {
		// TODO Auto-generated method stub
		
		 List dateOfMovieList = sessionFactory.getCurrentSession().createQuery("from DateOfMovie").list();

			return dateOfMovieList;
		
		
	}

	@Override
	public List<DateOfMovie> getDateOfMovieBykey(String keyword) {
		// TODO Auto-generated method stub
		//List<DateOfMovie> dateOfMovies = new ArrayList<DateOfMovie>();
        //List resulttitle = sessionFactory.getCurrentSession().createQuery("from DateOfMovie d where lower(d.showtime) like '%"+ keyword.toLowerCase() +"%'").list();
        //dateOfMovies .addAll(resulttitle);
		List<DateOfMovie> dateOfMovies = new ArrayList<DateOfMovie>();
        try{
        	int key = Integer.valueOf(keyword);
            List resulttitle = sessionFactory.getCurrentSession().createQuery("from DateOfMovie d where d.showtime like '%"+ key +"%'").list();
            dateOfMovies .addAll(resulttitle);
            List resultime = sessionFactory.getCurrentSession().createQuery("from DateOfMovie d where d.endtime like '%"+ key+"%'").list();
            dateOfMovies .addAll(resultime);
//            long key = Long.parseLong(keyword);
//            List resultid   = sessionFactory.getCurrentSession().createQuery("from DateOfMovie m where m.endtime = "+ key +"").list();
//         // = sessionFactory.getCurrentSession().createQuery("from Media m where lower(m.id) like '%" + key + "%'").list();
//            dateOfMovies.addAll(resultid);
        }
        catch (Exception e){

        	 ///return dateOfMovies;

        }
        return dateOfMovies;
		
	}

	@Override
	public void deleteDateOfMovie(DateOfMovie dateOfMovie) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(dateOfMovie);
		
	}

	@Override
	public List<DateOfMovie> selectMovie(Movie movie) {
		// 
		List<DateOfMovie> dateOfMovies = sessionFactory.getCurrentSession().createQuery ("from DateOfMovie d where d.movie.id= " +movie.getId() +"").list();
		return  dateOfMovies ;
	}

	


}

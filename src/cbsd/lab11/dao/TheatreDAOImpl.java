package cbsd.lab11.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.Theatre;
@Repository
public class TheatreDAOImpl implements TheatreDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(theatre);
		
	}

	@Override
	public Theatre getTheatreById(long id) {
		// TODO Auto-generated method stub
		Theatre theatre = (Theatre) sessionFactory.getCurrentSession().createQuery ("from Theatre t where t.id =" + id +"").uniqueResult();
		return theatre;
	
	}

	@Override
	public List<Theatre> getAllTheatre() {
		// TODO Auto-generated method stub
		 List theatreList = sessionFactory.getCurrentSession().createQuery("from Theatre").list();
		return theatreList;
	}

	@Override
	public List<Theatre> getTheatreBykey(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(theatre);
		
	}

	
}

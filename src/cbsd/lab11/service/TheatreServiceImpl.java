package cbsd.lab11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cbsd.lab11.dao.TheatreDAO;
import cbsd.lab11.entity.Theatre;
@Service
public class TheatreServiceImpl implements  TheatreService{
	@Autowired
	TheatreDAO theatreDAO;
	@Override
	@Transactional
	public void addTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		theatreDAO.addTheatre(theatre);
		
	}

	@Override
	@Transactional
	public Theatre getTheatreById(long id) {
		// TODO Auto-generated method stub
	return	theatreDAO.getTheatreById(id);
		
	}

	@Override
	@Transactional
	public List<Theatre> getAllTheatre() {
		// TODO Auto-generated method stub
		return theatreDAO.getAllTheatre();
	}

	@Override
	@Transactional
	public List<Theatre> getTheatreBykey(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteTheatre(Theatre theatre) {
		// TODO Auto-generated method stub
		theatreDAO.deleteTheatre(theatre);
		
	}

}

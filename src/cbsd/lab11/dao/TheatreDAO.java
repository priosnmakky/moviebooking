package cbsd.lab11.dao;

import java.util.List;

import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.Theatre;

public interface TheatreDAO {

	void addTheatre(Theatre theatre);
	 public Theatre getTheatreById(long id);
	    public List<Theatre> getAllTheatre();

	    public List<Theatre> getTheatreBykey(String keyword);
	    public void deleteTheatre(Theatre theatre);

}

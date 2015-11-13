package cbsd.lab11.service;

import java.util.List;

import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.Theatre;

public interface TheatreService {
	 public void addTheatre(Theatre theatre);
	    public Theatre getTheatreById(long id);
	    public List<Theatre> getAllTheatre();

	    public List<Theatre> getTheatreBykey(String keyword);
	    public void deleteTheatre(Theatre theatre);
}

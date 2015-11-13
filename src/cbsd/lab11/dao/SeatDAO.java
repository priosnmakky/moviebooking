package cbsd.lab11.dao;

import java.util.List;

import cbsd.lab11.entity.Seat;
import cbsd.lab11.entity.Theatre;

public interface SeatDAO {
	void addSeat(Seat seat);
	 public Seat getSeatById(long id);
	    public List<Seat> getAllSeat();

	    public List<Seat> getSeatBykey(String keyword);
	    public void deleteSeat(Seat seat);

}

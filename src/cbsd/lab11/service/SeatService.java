package cbsd.lab11.service;

import java.util.List;

import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.Seat;

public interface SeatService {
	 public void addSeat(Seat seat);
	    public Seat getSeatById(long id);
	    public List<Seat> getAllSeat();

	    public List<Seat> getSeatBykey(String keyword);
	    public void deleteSeat(Seat seat);
}

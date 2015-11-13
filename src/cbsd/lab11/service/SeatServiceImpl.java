package cbsd.lab11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cbsd.lab11.dao.MovieDAO;
import cbsd.lab11.dao.SeatDAO;
import cbsd.lab11.entity.Seat;
@Service
public class SeatServiceImpl implements SeatDAO{
	@Autowired
    SeatDAO seatDAO;
	@Override
	@Transactional
	public void addSeat(Seat seat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Seat getSeatById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Seat> getAllSeat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Seat> getSeatBykey(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteSeat(Seat seat) {
		// TODO Auto-generated method stub
		
	}

}

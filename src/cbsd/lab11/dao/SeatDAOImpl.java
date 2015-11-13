package cbsd.lab11.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cbsd.lab11.entity.Seat;
@Repository
public class SeatDAOImpl implements SeatDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addSeat(Seat seat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seat getSeatById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> getAllSeat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seat> getSeatBykey(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSeat(Seat seat) {
		// TODO Auto-generated method stub
		
	}

}

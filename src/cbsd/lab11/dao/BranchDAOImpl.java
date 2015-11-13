package cbsd.lab11.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.Movie;
@Repository
public class BranchDAOImpl implements  BranchDAO{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addBranch(Branch branch) {
		// TODO Auto-generated method stubsessionFactory.getCurrentSession().saveOrUpdate(movie);
		sessionFactory.getCurrentSession().saveOrUpdate(branch);
	}

	@Override
	public Branch getBranchById(long id) {
		Branch branch = (Branch) sessionFactory.getCurrentSession().createQuery ("from Branch b where b.id =" + id +"").uniqueResult();
		return branch;
	}

	@Override
	public List<Branch> getAllBranch() {
		 List branchList = sessionFactory.getCurrentSession().createQuery("from Branch").list();

		return branchList;
	}

	@Override
	public List<Branch> getBranchBykey(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBranch(Branch branch) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(branch);
		
	}

}

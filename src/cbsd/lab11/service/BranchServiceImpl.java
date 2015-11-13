package cbsd.lab11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cbsd.lab11.dao.BranchDAO;
import cbsd.lab11.dao.MovieDAO;
import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.Movie;
@Service
public class BranchServiceImpl implements  BranchService {
	@Autowired
    BranchDAO branchDAO;
	@Override
	@Transactional
	public void addBranch(Branch branch) {
		// TODO Auto-generated method stub
		
		branchDAO.addBranch(branch);
	}

	@Override
	@Transactional
	public Branch getBranchById(long id) {
		// TODO Auto-generated method stub
	
		return branchDAO.getBranchById(id);
	}

	@Override
	@Transactional
	public List<Branch> getAllBranch() {
		// TODO Auto-generated method stub
		
		return branchDAO.getAllBranch();
	}

	@Override
	@Transactional
	public List<Branch> getBranchBykey(String keyword) {
		// TODO Auto-generated method stub
		return branchDAO.getBranchBykey(keyword);
	}

	@Override
	@Transactional
	public void deleteBranch(Branch branch) {
		// TODO Auto-generated method stub
		branchDAO.deleteBranch(branch);;
		
	}

}

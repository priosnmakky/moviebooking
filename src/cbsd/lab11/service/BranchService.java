package cbsd.lab11.service;

import java.util.List;

import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.Movie;

public interface BranchService {
	 public void addBranch(Branch branch);
	    public Branch getBranchById(long id);
	    public List<Branch> getAllBranch();

	    public List<Branch> getBranchBykey(String keyword);
	    public void deleteBranch(Branch branch);

}

package cbsd.lab11.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.Image;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.Theatre;
import cbsd.lab11.service.BranchService;
import cbsd.lab11.service.ImageService;
import cbsd.lab11.service.MovieService;
import cbsd.lab11.service.security.UserDetailsServiceImpl;

@Controller
@RequestMapping("branch")
public class BranchController {
   

    @Autowired
    BranchService branchService;
	
 
	
	  @RequestMapping(value = "list")
	    public String cList(ModelMap modelMap){

	        modelMap.addAttribute("branch", branchService.getAllBranch());
	        return "branchList";
	    }

	
	

   
	  @RequestMapping("addBranch")
	    public String calladdMoviePage(Model model){
	        model.addAttribute("branch",new Branch());
	        return "addbranch";
	    }
	    @RequestMapping(value = "addValidBranch",method = RequestMethod.POST)
	    public String addValidCustomer(HttpServletRequest request,@Valid Branch branch){
	    	Branch branch1 = new  Branch();
	    	branch1.setName(branch.getName());
	    	branch1.setLocation(branch.getLocation());
	    	List<Theatre> theatres = new ArrayList<Theatre>();
	    	branch1.setTheatres(theatres);
	    	branchService.addBranch(branch1);

	        return "redirect:/branch/list";
	    }
	    
	    @RequestMapping("select/{id}")
	    public String setSelete(@PathVariable("id") Long id,Model model,HttpServletRequest request){
	      Branch branch = branchService.getBranchById(id);
	      request.getSession().setAttribute("branch", branch);
	    	///request.getSession().setAttribute("branch",branch);
	       return "redirect:/theatre/list/"+id;
	    }
	    
	    @RequestMapping(value = "update/{id}")
	    public String updateStudent(@PathVariable("id") Long id,Model model){
	    	Branch branch = branchService.getBranchById(id);
	    	
	    	//Movie movie = movieService.getMovieById(id);
	       model.addAttribute("branch", branch);
	        return "addbranch";
	    }
	    @RequestMapping(value = "delete/{id}")
	    public String deleteStudent(@PathVariable("id") Long id,Model model){
	    	//Movie movie = movieService.getMovieById(id);
	    	Branch branch = branchService.getBranchById(id);
	    //	movieService.deleteMovie(movie);
	    	branchService.deleteBranch(branch);
	        ///model.addAttribute("movie", movie);
	        return "redirect:/branch/list";
	    }

	   




}


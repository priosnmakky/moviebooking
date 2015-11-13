package cbsd.lab11.controller.security;
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
import cbsd.lab11.service.TheatreService;
import cbsd.lab11.service.security.UserDetailsServiceImpl;

@Controller
@RequestMapping("theatre")
public class TheatreController {
   

    @Autowired
    TheatreService theatreService;
	
    @Autowired
    BranchService branchService;
	
	  @RequestMapping(value = "list/{id}")
	    public String cList(@PathVariable("id") Long id,HttpServletRequest request,ModelMap modelMap){
		  Branch branch = branchService.getBranchById(id);
		  //Branch breanch =(Branch) request.getAttribute("branch");
		  //if(breanch!=null){
			  
			//  modelMap.addAttribute("theatre", breanch.getTheatres());
		  //}
		  //else{
			  
			  modelMap.addAttribute("theatre", branch.getTheatres());
		//  }
	      //  modelMap.addAttribute("theatre", breanch.getTheatres());
	        return "theatreList";
	    }

	
	
	@RequestMapping(value = "addMovie111",method = RequestMethod.POST)
    public String addMovie(@Valid Movie movie,BindingResult bindingResult,Model model,@RequestParam("file")MultipartFile file){

//Customer customer = new Customer();
        long id=1;

        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
        UserDetails userDetails =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (bindingResult.hasErrors()){
            return "addMedia";
        }
        try {
            Image image = new Image();
            image.setFileName(file.getName());
            image.setContentType(file.getContentType());
            image.setContent(file.getBytes());
           ///movie.setImage(image);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:";
    }

   
	  @RequestMapping("addtheatre")
	    public String calladdMoviePage(Model model){
	        model.addAttribute("theatre",new Theatre());
	        return "addtheatre";
	    }
	    @RequestMapping(value = "addValidTheatre",method = RequestMethod.POST)
	    public String addValidCustomer(HttpServletRequest request,@Valid Theatre theatre){
	    	Theatre theatre1 = new  Theatre();
	    	theatre1.setNumber(1);
	    	List<Theatre> theatres = new ArrayList<Theatre>();
	    	//Branch breanch =(Branch) request.getAttribute("branch");
	    	/// Branch branch = branchService.getBranchById(id);
	    	///theatres.addAll(breanch.getTheatres());
	    	//theatres.add(theatre1);
	    	
	    	//theatreService.addTheatre(theatre1);
	    	 //breanch.setTheatres(theatres);
	    	    ///branchService.addBranch(breanch);
	    	

	        return "redirect:/theatre/list";
	    }
	    
	    @RequestMapping("select/{id}")
	    public String setSelete(@PathVariable("id") Long id,Model model,HttpServletRequest request){
	    	Theatre theatre = theatreService.getTheatreById(id);
	    	request.getSession().setAttribute("theatre",theatre);
	       return "";
	    }
	    
	    @RequestMapping(value = "update/{id}")
	    public String updateStudent(@PathVariable("id") Long id,Model model){
	    	Theatre theatre = theatreService.getTheatreById(id);
	    	
	    	//Movie movie = movieService.getMovieById(id);
	       model.addAttribute("theatre", theatre);
	        return "addtheatre";
	    }
	    @RequestMapping(value = "delete/{id}")
	    public String deleteStudent(@PathVariable("id") Long id,Model model){
	    	//Movie movie = movieService.getMovieById(id);
	    	Theatre theatre = theatreService.getTheatreById(id);
	    //	movieService.deleteMovie(movie);
	    	theatreService.deleteTheatre(theatre);
	        ///model.addAttribute("movie", movie);
	        return "redirect:/theatre/list";
	    }

	   




}


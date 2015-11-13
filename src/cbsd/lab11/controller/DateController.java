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

import cbsd.lab11.dao.UserDAO;
import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Image;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.User;
import cbsd.lab11.service.CustomerService;
import cbsd.lab11.service.DateOfMovieService;
import cbsd.lab11.service.ImageService;
import cbsd.lab11.service.MovieService;
import cbsd.lab11.service.security.UserDetailsServiceImpl;

@Controller
@RequestMapping("date")
public class DateController {
   
	
    @Autowired
    ImageService imageService;

    @Autowired
    DateOfMovieService dateService;
    @Autowired
    MovieService movieService;
    @Autowired
    UserDAO userDAO;
    @Autowired
    CustomerService customerService;
	public User getAuthoritie(){
		UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
        UserDetails userDetails =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if(userDetails.getAuthorities().size()>1){
    	   User user = new User();
   	    		user.setUsername(userDetails.getUsername());	
   	    		user.setPassword(userDetails.getPassword());
   	    		user.setRole(1);
   	    	  /// modelMap.addAttribute("user",userDetails.getAuthorities().size() );
   	    	   return user;
   	       }
       else{
    	   
    	   User user = new User();
	    		user.setUsername(userDetails.getUsername());	
	    		user.setPassword(userDetails.getPassword());
	    		user.setRole(2);
	    	  /// modelMap.addAttribute("user",userDetails.getAuthorities().size() );
	    	   return user;
    	   
    	   
       }
		
	}
	  @RequestMapping(value = "list")
	    public String cList(ModelMap modelMap){
		 /// Movie movie = movieService.getMovieById(id);
		 List<DateOfMovie> dateOfMovies = dateService.getAllDateOfMovie();
	     modelMap.addAttribute("date", dateService.getAllDateOfMovie());
	        return "movieofdateList";
	    }

	
	
	
   
	  @RequestMapping("addDate")
	    public String calladdMoviePage(Model model){
	        model.addAttribute("date",new  DateOfMovie());
	        return "addmovieofdate";
	    }
	  
	  
	    @RequestMapping(value = "addValidDate",method = RequestMethod.POST)
	    public String addValidCustomer(@Valid DateOfMovie date,BindingResult bindingResult,Model model){
	    	///Movie movie2 = movieService.getMovieById(movie.getId());
	   
	    	 if (bindingResult.hasErrors()){
	             return "addmovieofdate";
	         }	
	    	 List<DateOfMovie> dateOfMovies  =dateService.getAllDateOfMovie();
	         double showtime =  Double.valueOf(date.getShowtime());
	    	 double endtime= Double.valueOf(date.getEndtime());
	    	 double sum =showtime+ (endtime -showtime);
	    	/// Integer.valueOf(dateOfMovies.get(i).getEndtime();
	    	 for(int i =0;i<dateOfMovies.size();i++){
	            	
	            if((endtime>Double.valueOf(dateOfMovies.get(i).getShowtime())&&endtime<Double.valueOf(dateOfMovies.get(i).getEndtime()))||(showtime>Double.valueOf(dateOfMovies.get(i).getShowtime())&&showtime<Double.valueOf(dateOfMovies.get(i).getEndtime()))){
	            ///	dateService.addDateOfMovie(date);
	            	model.addAttribute("date",new  DateOfMovie());
	            	model.addAttribute("error","Time is same");
	            	return "addmovieofdate";
	            	}
	         
	            	
	            }
	    	 //Movie movie = new Movie();
	    	 //movieService.addMovie(movie);
	    	 //date.setMovie(movie);
	            dateService.addDateOfMovie(date);
	       

	        return "redirect:/date/list";
	    }
	    
	    @RequestMapping(value = "update/{id}")
	    public String updateStudent(@PathVariable("id") Long id,Model model){
	    	DateOfMovie dateOfMovie = dateService.getDateOfMovieById(id);
	        model.addAttribute("date", dateOfMovie);
	        return "addmovieofdate";
	    }
	    
	    @RequestMapping("findBykey")
	    public String findBykey(@Valid String keyword,ModelMap modelMap){
	    	
	        modelMap.addAttribute("date",  dateService.getDateOfMovieBykey(keyword));
	        return "movieofdateList";
	    }
	    
	    @RequestMapping(value = "delete/{id}")
	    public String deleteStudent(@PathVariable("id") Long id,Model model){
	    	DateOfMovie dateOfMovie = dateService.getDateOfMovieById(id);
	    	dateService.deleteDateOfMovie(dateOfMovie);
	        ///model.addAttribute("movie", movie);
	        return "redirect:/date/list";
	    }

	    
	    
	    @RequestMapping("select/{id}")
	    public String setSelete(@PathVariable("id") Long id,Model model,HttpServletRequest request){
	    	DateOfMovie dateOfMovie = dateService.getDateOfMovieById(id);
	    request.getSession().setAttribute("id", id);
	    	///request.getSession().setAttribute("branch",branch);
	       return "redirect:/movie/list";
	    }
	    
	    @RequestMapping(value = "image/{id}")
	    public String showImage(@PathVariable("id") Integer id,Model model,HttpServletResponse response){
	        try {
	            Image image = imageService.get(id);
	            if (image!=null){
	                OutputStream outputStream = response.getOutputStream();
	                response.setContentType(image.getContentType());
	                // IOUtils.copy(new ByteArrayInputStream(image.getContent()),outputStream);
	                ByteArrayInputStream bis = new ByteArrayInputStream(image.getContent());
	                ImageIO.setUseCache(false);
	                BufferedImage myImage = ImageIO.read(bis);
	                int rectangleSize = 300;
	                BufferedImage bi = Scalr.resize(myImage, rectangleSize);
	                ImageIO.write(bi, getContentType(image.getContentType()),outputStream);
	                outputStream.flush();
	                outputStream.close();
	            }
	        }catch (IOException e){
	            e.printStackTrace();
	        }
	        return null;
	    }


	    private String getContentType(String contentType){
	        if (contentType.contains("jpg")){
	            return "jpg";
	        }else if (contentType.contains("png")){
	            return "png";
	        }else if (contentType.contains("gif")){
	            return "gif";
	        }else{
	            return "jpg";
	        }

	    }

}
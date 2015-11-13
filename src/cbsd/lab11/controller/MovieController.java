package cbsd.lab11.controller;

import java.awt.image.BufferedImage;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cbsd.lab11.dao.UserDAO;
import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Image;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.User;
import cbsd.lab11.service.DateOfMovieService;
import cbsd.lab11.service.ImageService;
import cbsd.lab11.service.MovieService;
import cbsd.lab11.service.security.UserDetailsServiceImpl;


@Controller
@RequestMapping("movie")
public class MovieController {
   

    @Autowired
    MovieService movieService;
	
    @Autowired
    ImageService imageService;
    @Autowired
    DateOfMovieService dateOfMovieService;
    @Autowired
    UserDAO userDAO;
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
	    public String cList(ModelMap modelMap,HttpServletRequest request){
		  
		  long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
		  DateOfMovie dateOfMovie =dateOfMovieService.getDateOfMovieById(a);
		  if(dateOfMovie.getMovie()==null){
			  modelMap.addAttribute("user",getAuthoritie());
			  
			  return "redirect:/movie/addMovie"; 
			  
		  }
		  else{
			  if(dateOfMovie.getMovie().getImage()!=null){
			 	List<Movie> movies = new  ArrayList<Movie>();
			 	movies.add(dateOfMovie.getMovie());
			 	modelMap.addAttribute("user",getAuthoritie());
		        modelMap.addAttribute("movie",movies);
		        return "movieList"; 
			  }
			  return "redirect:/movie/addMovie";
		  }
		  
	    }

	
	
	
	  @RequestMapping("addMovie")
	    public String calladdMoviePage(Model model){
	     
	        
		//  DateOfMovie dateOfMovie =dateOfMovieService.getDateOfMovieById(id);
		  model.addAttribute("movie",new Movie());
		  //model.addAttribute("id",id);
		  return "addmovie";
	    }
	    @RequestMapping(value = "addValidMovie",method = RequestMethod.POST)
	    public String addValidCustomer(@Valid Movie movie,BindingResult bindingResult,Model model,@RequestParam("file")MultipartFile file,HttpServletRequest request){
	    	///Movie movie2 = movieService.getMovieById(movie.getId());
	    	if (bindingResult.hasErrors()){
	            return "addmovie";
	        }
	        try {
	        	Movie movie1 = new Movie();
	            Image image = new Image();
	            image.setFileName(file.getName());
	            image.setContentType(file.getContentType());
	            image.setContent(file.getBytes());
	           
	            movie1.setId(movie.getId());
	    
	            movie1.setName(movie.getName());
	            movie1.setAntor(movie.getAntor());
	            movie1.setDirector(movie.getDirector());
	            movie1.setGenres(movie.getGenres());
	            movie1.setReleaseDate(movie.getReleaseDate());
	            movie1.setSynopsis(movie.getSynopsis());

	            if(movie.getId()!=null&&(file.getBytes().length==0)){
	        
	            	Movie movie2 = movieService.getMovieById(movie.getId());
	            	movie1.setImage(movie2.getImage());

	            	long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
	            	DateOfMovie	dateOfMovie	= dateOfMovieService.getDateOfMovieById(a);
	            	dateOfMovie.setMovie(movie1);
	            	dateOfMovieService.addDateOfMovie(dateOfMovie);

	           
	            	
	            }
	            else{
	           // Movie movie2 = movieService.getMovieById(movie.getId());
	            	movie1.setImage(image);
	            	//movieService.addMovie(movie1);
	            	long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
	            	DateOfMovie	dateOfMovie	= dateOfMovieService.getDateOfMovieById(a);
	            	dateOfMovie.setMovie(movie1);
	            	dateOfMovieService.addDateOfMovie(dateOfMovie);
	            	
	            }
	            	
	            	
	            


	        }catch (IOException e){
	            e.printStackTrace();
	        }
	    	long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
	    	DateOfMovie	dateOfMovie	= dateOfMovieService.getDateOfMovieById(a);
	        
			return "redirect:/movie/list/";
	    }
	    
	    @RequestMapping(value = "update/{id}")
	    public String updateStudent(@PathVariable("id") Long id,Model model){
	         Movie movie = movieService.getMovieById(id);
	        model.addAttribute("movie", movie);
	        return "addmovie";
	    }
	    @RequestMapping(value = "delete/{id}")
	    public String deleteStudent(@PathVariable("id") Long id,Model model,HttpServletRequest request){
	    	long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
		    	DateOfMovie	dateOfMovie	= dateOfMovieService.getDateOfMovieById(a);
		    	dateOfMovie.setMovie(null);
		    	dateOfMovieService.addDateOfMovie(dateOfMovie);
	    	//Movie movie = movieService.getMovieById(id);
	    	//movieService.deleteMovie(movie);
	        ///model.addAttribute("movie", movie);
	        return "redirect:/movie/list";
	    }

	    
	    @RequestMapping("select/{id}")
	    public String setSelete(@PathVariable("id") Long id,Model model,HttpServletRequest request){
	    	DateOfMovie dateOfMovie = dateOfMovieService.getDateOfMovieById(id);
	    
	    	/// request.getSession().setAttribute("id", id);
	    	//// request.getSession().setAttribute("moive", movie);
	    	///request.getSession().setAttribute("branch",branch);
	       return "redirect:/seat/list";
	    }
	//    @RequestMapping("select/{id}")
	 //   public String setSelete(@PathVariable("id") Long id,Model model,HttpServletRequest request){
	   //   Movie movie = movieService.getMovieById(id);
	     // request.getSession().setAttribute("moive", movie);
	    	///request.getSession().setAttribute("branch",branch);
	    //   return "redirect://list/"+id;
	    ///}
	    
	    
	    
	    
	    @RequestMapping(value = "image/{id}")
	    public String showImage(@PathVariable("id") Integer id,Model model,HttpServletResponse response){
	        try {
	            Image image = imageService.get(id);
	            if (image!=null){
	                OutputStream outputStream = response.getOutputStream();
	                response.setContentType(image.getContentType());
	                ///IOUtils.copy(new ByteArrayInputStream(image.getContent()),outputStream);
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

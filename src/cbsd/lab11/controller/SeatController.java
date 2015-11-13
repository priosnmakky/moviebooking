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

import cbsd.lab11.entity.Branch;
import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Image;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.Seat;
import cbsd.lab11.service.DateOfMovieService;
import cbsd.lab11.service.ImageService;
import cbsd.lab11.service.MovieService;
import cbsd.lab11.service.security.UserDetailsServiceImpl;


@Controller
@RequestMapping("seat")
public class SeatController {
   

    @Autowired
    MovieService movieService;
	
    @Autowired
    ImageService imageService;
    @Autowired
    MovieService MovieService;
    @Autowired
    DateOfMovieService dateOfMovieService;
	
	
	  @RequestMapping(value = "list")
	    public String cList(ModelMap modelMap,HttpServletRequest request){
		 
			long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
	    	DateOfMovie	dateOfMovie	= dateOfMovieService.getDateOfMovieById(a);
	    	modelMap.addAttribute("seat",dateOfMovie.getMovie().getSeats());
		  return "seatList";
		 
		  
	    }

	
	
	
	  @RequestMapping("addSeat")
	    public String calladdMoviePage(Model model){
	     
	        
		//  DateOfMovie dateOfMovie =dateOfMovieService.getDateOfMovieById(id);
		  model.addAttribute("seat",new Seat());
		  //model.addAttribute("id",id);
		  return "addseat";
	    }
	    @RequestMapping(value = "addValidSeat",method = RequestMethod.POST)
	    public String addValidCustomer(@Valid Seat seat,BindingResult bindingResult,Model model,HttpServletRequest request){
	    	///Movie movie2 = movieService.getMovieById(movie.getId());
	    	if (bindingResult.hasErrors()){
	    		
	            return "addseat";
	            
	            
	            
	        }
	    		
	    	
	    	
	    	long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
	    	DateOfMovie	dateOfMovie	= dateOfMovieService.getDateOfMovieById(a);
	    List<Seat> seats=	dateOfMovie.getMovie().getSeats();
	    seat.setStatus(1);
	    seats.add(seat);
	   dateOfMovie.getMovie().setSeats(seats);
	    dateOfMovieService.addDateOfMovie(dateOfMovie);
	    
	        		
	    	
	        
			return "redirect:/seat/list/";
	    }
	    
	    @RequestMapping(value = "update/{id}")
	    public String updateStudent(@PathVariable("id") Long id,Model model,HttpServletRequest request){
	        // Movie movie = movieService.getMovieById(id);
	       // model.addAttribute("movie", movie);
	    	long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
	    	DateOfMovie	dateOfMovie	= dateOfMovieService.getDateOfMovieById(a);
	    	 
	    	 int i;
	    		List<Seat> seats = dateOfMovie.getMovie().getSeats();
	    		Seat seat = new Seat();  
	    	 for(i=0;i<seats.size();i++){
		    		if(seats.get(i).getId()== id){
		    			seat  = seats.get(i);
		    			seats.remove(i);
		    			
		    		}
		    		
		    		
		    	}	
	    	 
	    	 model.addAttribute("seat",seat);
	    	 
	    	 
	        return "addseat";
	    }
	    @RequestMapping(value = "delete/{id}")
	    public String deleteStudent(@PathVariable("id") Long id,Model model,HttpServletRequest request){
	    	//Movie movie = movieService.getMovieById(id);
	    	//movieService.deleteMovie(movie);
	    	
	    	long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
	    	DateOfMovie	dateOfMovie	= dateOfMovieService.getDateOfMovieById(a);
	    	List<Seat> seats = dateOfMovie.getMovie().getSeats();
	    
	    	for(int i=0;i<seats.size();i++){
	    		if(seats.get(i).getId()== id){
	    			seats.remove(i);
	    			
	    		}
	    		
	    		
	    	}	
	    		
	    	dateOfMovie.getMovie().setSeats(seats);
	    	dateOfMovieService.addDateOfMovie(dateOfMovie);
	    	
	        ///model.addAttribute("movie", movie);
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

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

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Image;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.Seat;
import cbsd.lab11.entity.User;
import cbsd.lab11.service.BranchService;
import cbsd.lab11.service.DateOfMovieService;
import cbsd.lab11.service.ImageService;
import cbsd.lab11.service.MovieService;
import cbsd.lab11.service.security.UserDetailsServiceImpl;

@Controller
@RequestMapping("booking")
public class BookingController {
    @Autowired
    ImageService imageService;
    @Autowired
    DateOfMovieService dateService;
    @Autowired
    MovieService movieService;
    
    @RequestMapping(value = "list")
    public String cList(ModelMap modelMap){
	///  long a=  1;
	  List<Movie> movies  = movieService.getAllMovie();
			  
   modelMap.addAttribute("movie",movies);
	  return "movieList";
    }
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
    @RequestMapping("select/{id}")
    public String setSelete(@PathVariable("id") Long id,Model model,HttpServletRequest request){
    	Movie movie = movieService.getMovieById(id);
    	List<DateOfMovie> dateOfMovies = dateService.selectMovies(movie);
    	model.addAttribute("date",dateOfMovies);
    	model.addAttribute("user",getAuthoritie());
    	///DateOfMovie dateOfMovie = dateService.selectMovies(movie);
     //// request.getSession().setAttribute("moive", movie);
    	///request.getSession().setAttribute("branch",branch);
       return "bookingdate";
    }
    
    @RequestMapping("showseat/{id}")
    public String setSeat(@PathVariable("id") Long id,Model model,HttpServletRequest request){
    	//Movie movie = movieService.getMovieById(id);
    	//List<DateOfMovie> dateOfMovies = dateService.selectMovies(movie);
    	 request.getSession().setAttribute("id", id);
    	DateOfMovie dateOfMovies= dateService.getDateOfMovieById(id);
    	model.addAttribute("seat",dateOfMovies.getMovie().getSeats());
    	model.addAttribute("user",getAuthoritie());
    	
    	///DateOfMovie dateOfMovie = dateService.selectMovies(movie);
     //// request.getSession().setAttribute("moive", movie);
    	///request.getSession().setAttribute("branch",branch);
       return "bookingseat";
    }
    
    
    @RequestMapping("check")
    public String setCheck(@RequestParam("check") List<String> bid,Model model,HttpServletRequest request){
    	//Movie movie = movieService.getMovieById(id);
    	//List<DateOfMovie> dateOfMovies = dateService.selectMovies(movie);
    	
    	
    	List<Seat> seats = new ArrayList<Seat>();
    	long a=  Long.valueOf(request.getSession().getAttribute("id").toString());
    	//bid.get(x);
    	boolean c =true;
    	double total = 0;
    	DateOfMovie dateOfMovies= dateService.getDateOfMovieById(a);
    	for(int i=0;i<dateOfMovies.getMovie().getSeats().size();i++){
    		c=true;
    		///dateOfMovies.getMovie().getSeats().remove(0);
    	///	Seat seat =dateOfMovies.getMovie().getSeats().get(i);
    ////	System.out.println(seat.getName());
    		//dateOfMovies.getMovie().getSeats().remove(i);
    		
    		for(int x=0;x<bid.size();x++){
    			if(dateOfMovies.getMovie().getSeats().get(i).getId()==Long.valueOf(bid.get(x))){
    			
    			
    			Seat seat =dateOfMovies.getMovie().getSeats().get(i);
    			total = total +seat.getPrice();
    			seat.setStatus(2);
    			seats.add(seat);
    			dateOfMovies.getMovie().getSeats().set(i,seat );
    			c=false;
    					
    			}
    			
    		
//    				Seat seat =dateOfMovies.getMovie().getSeats().get(i);
//    				seats.add(seat);
//    				dateOfMovies.getMovie().getSeats().set(i,seat );
    			
    		///	bid.get(x);
//    		System.out.println(seat.getName());
//    		if(dateOfMovies.getMovie().getSeats().get(i).getId()==Long.valueOf(bid.get(x))){
//    			seat.setStatus(2);
//    			seats.add(seat);
//    			//Seat seat = dateOfMovies.getMovie().getSeats().get(i);
//    			//seat
//    		}
    		
    		}
if(c){
			Seat seat =dateOfMovies.getMovie().getSeats().get(i);
			seats.add(seat);
			dateOfMovies.getMovie().getSeats().set(i,seat );
}
    		//seats.add(seat);
    		///dateOfMovies.getMovie().getSeats().remove(i);
    	}
    	
    	dateOfMovies.getMovie().setSeats(seats);
    	dateService.addDateOfMovie(dateOfMovies);
    	////model.addAttribute("seat",dateOfMovies.getMovie().getSeats());
//    	double total = 0;
//    	for(int i=0;i<seats.size();i++){
//    	
//    			if(seats.get(i).getStatus()==2){
//    				
//    				total =total+ seats.get(i).getPrice();
//    			}
//    		
//    		}
    		
    	
    	model.addAttribute("date",dateOfMovies);
    	model.addAttribute("user",getAuthoritie());
    	model.addAttribute("total",total);
    	///DateOfMovie dateOfMovie = dateService.selectMovies(movie);
     //// request.getSession().setAttribute("moive", movie);
    	///request.getSession().setAttribute("branch",branch);
       return "ticket";
    }
    
    
    
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

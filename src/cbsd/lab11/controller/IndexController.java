package cbsd.lab11.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cbsd.lab11.entity.Customer;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.User;
import cbsd.lab11.service.security.UserDetailsServiceImpl;

@Controller
@RequestMapping("index")
public class IndexController {
	
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
	
	@RequestMapping("user")
    public String calladdMoviePage(Model model){
     
	     User user = getAuthoritie();
	      if(user.getRole()==1){
	    	  return "redirect:/date/list";
	      }
	      else{
	    	return "redirect:/booking/list";
	    	  
	      }
	
    }
}

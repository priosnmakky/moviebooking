package cbsd.lab11.controller;

import cbsd.lab11.dao.UserDAO;


import cbsd.lab11.entity.Customer;
import cbsd.lab11.entity.DateOfMovie;
import cbsd.lab11.entity.Image;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.entity.User;
import cbsd.lab11.service.CustomerService;
import cbsd.lab11.service.ImageService;
import cbsd.lab11.service.security.UserDetailsServiceImpl;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by narongrit on 2/27/14.
 */
@Controller
@RequestMapping("Customer")
public class CustomerController {
    @Autowired
    ImageService imageService;
    @Autowired
    CustomerService customerService;
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
    public String cList(ModelMap modelMap){

        modelMap.addAttribute("customer", customerService.getAllCustomer());
        return "customerList";
    }

    @RequestMapping("register")
    public String callRegisterPage(Model model){
        model.addAttribute("customer",new Customer());
        return "customerRegist";
    }
    @RequestMapping("addCustomer")
    public String addStudent(@ModelAttribute Customer customer,BindingResult bindingResult,Model model){
        customerService.register(customer);
        return "redirect:/student/list";
    }







    @RequestMapping(value = "addValidCustomer",method = RequestMethod.POST)
    public String addValidCustomer(@Valid Customer customer,BindingResult bindingResult,Model model,@RequestParam("file")MultipartFile file){
        if (bindingResult.hasErrors()){
            return "customerRegist";
        }
        
        if(customerService.getCustomerByUsername(customer.getUsername())!=null){
       	model.addAttribute("same","username is already used");
        	 return "customerRegist";
        	
        }
        try {
            
            Image image = new Image();
            image.setFileName(file.getName());
            image.setContentType(file.getContentType());
            image.setContent(file.getBytes());
            customer.setImage(image);

         //   cart.setId( customer.getId());
           // cartService.addCart(cart);
            model.addAttribute("userSession",customerService.getCustomerByUsername(customer.getUsername()));
            customerService.register(customer);
            

          //  model.addAttribute("userSession",customerService.getCustomerByUsername(customer.getUsername()));
          
            
   


        }catch (IOException e){
            e.printStackTrace();
        }


        return "redirect:/auth/customer";
    }


    @RequestMapping(value = "addValidCustomerup",method = RequestMethod.POST)
    public String addValidCustomerup(@Valid Customer customer,BindingResult bindingResult,Model model,@RequestParam("file")MultipartFile file){
        if (bindingResult.hasErrors()){
            return "customerupdate";
        }
        
       
        try {
            
            Image image = new Image();
            image.setFileName(file.getName());
            image.setContentType(file.getContentType());
            image.setContent(file.getBytes());
            ///customer.setImage(image);

         //   cart.setId( customer.getId());
           // cartService.addCart(cart);
          User user = getAuthoritie();
          Customer customer1= customerService.getCustomerByUsername(user.getUsername());
            customer1.setPassword(customer.getPassword());
            customer1.setFname(customer.getFname());
            customer1.setLname(customer.getLname());
            customer1.setEmail(customer.getEmail());
            customer1.setAddress(customer.getAddress());
            
            if(file.getBytes().length>0){
            	
            	
            	//customer.setImage(image);
            	customer1.setImage(image);
            }
            else{
            	
                 
            	
           
            }
            
            
            
            
            customerService.updateCustomer(customer1);
            

            model.addAttribute("userSession",customerService.getCustomerByUsername(customer.getUsername()));
          
            
   


        }catch (IOException e){
        	
        	
        	
            e.printStackTrace();
        }


        return "redirect:/auth/customer";
    }


//UserController userController = new UserController();


    //String username= userController.getUserSession().getName();
    //Customer customer= customerService.getCustomerByUsername(username);
    //model.addAttribute("customer",customer);

    @RequestMapping("update")
    public String callupdatePage(Model model){

        UserController userController = new UserController();


        User user = getAuthoritie();
        Customer customer= customerService.getCustomerByUsername(user.getUsername());
       /// model.addAttribute("customer",customer);

        model.addAttribute("customer",customer);
        return "customerupdate";
    }


    @RequestMapping(value = "updateValidCustmer",method = RequestMethod.POST)
    public String updateCustomer(@Valid Customer customer,BindingResult bindingResult,Model model,@RequestParam("file")MultipartFile file){



        if (bindingResult.hasErrors()){
            return "updateCustomer";
        }
        try {
            //   Cart cart = new Cart();
            UserDetails userDetails =
                    (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Customer customer1 = customerService.getCustomerByUsername(userDetails.getUsername());
               customer.setId(customer1.getId());
            Image image = new Image();
            image.setFileName(file.getName());
            image.setContentType(file.getContentType());
            image.setContent(file.getBytes());
            customer.setImage(image);

            //  cart.setId( customer.getId());
            //  cartService.addCart(cart);
            customerService.register(customer);

        }catch (IOException e){
            e.printStackTrace();
        }


        return "redirect:/Customer/list";
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

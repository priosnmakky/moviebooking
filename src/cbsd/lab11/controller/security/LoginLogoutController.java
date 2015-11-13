package cbsd.lab11.controller.security;

import cbsd.lab11.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/11/13
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/auth")
public class LoginLogoutController {


    boolean role;

    /**
     * Handles and retrieves the login JSP page
     *
     * @return the name of the JSP page
     */
    @ModelAttribute("userSession")
    public User getUserSession( ){


        return new User();
    }

    @ModelAttribute("date")
    public Date getUserDate()
    {
        return Calendar.getInstance().getTime();
    }



    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(value="error", required=false) boolean error,
                               ModelMap model) {

        // Add an error message to the model if login is unsuccessful
        // The 'error' parameter is set to true based on the when the authentication has failed.
        // We declared this under the authentication-failure-url attribute inside the spring-security.xml
  /* See below:
   <form-login
    login-page="/auth/login"
    authentication-failure-url="/auth/login?error=true"
    default-target-url="/lecturer/list"/>*/
        if (error == true) {
            // Assign an error message
            model.put("error", "You have entered an invalid username or password!");
        } else {
            model.put("error", "");
        }
        role=false;
     // This will resolve to /WEB-INF/view/security/login.jsp
       return "security/login";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public String getLoginPage1(@RequestParam(value="error", required=false) boolean error, ModelMap model) {
//
//        // Add an error message to the model if login is unsuccessful
//        // The 'error' parameter is set to true based on the when the authentication has failed.
//        // We declared this under the authentication-failure-url attribute inside the spring-security.xml
//  /* See below:
//   <form-login
//    login-page="/auth/login"
//    authentication-failure-url="/auth/login?error=true"
//    default-target-url="/lecturer/list"/>*/
//
//
//        // This will resolve to /WEB-INF/view/security/login.jsp
//
//        if (error == true) {
//            // Assign an error message
//            model.put("error", "You have entered an invalid username or password!");
//        } else {
//            model.put("error", "");
//        }
//        role=true;
//        // This will resolve to /WEB-INF/view/security/login.jsp
//        return "security/login";
//    }






    /**
     * Handles and retrieves the denied JSP page. This is shown whenever a regular user
     * tries to access an admin only page.
     *
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String getDeniedPage() {


        // This will resolve to /WEB-INF/view/security/deniedpage.jsp
        return "security/deniedpage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage2(@RequestParam(value="error", required=false) boolean error, ModelMap model) {


        if(error ==true){
           
                model.put("error", "You have entered an invalid username or password!");
             

        }
            
            else {
               
            	/// model.put("error", "You have entered an invalid username or password!");
            	 model.put("error", "");
            	
            
            	//return "redirect:/index/user";

            	}
   	   return "security/login";
        }






    





/*
    if(error =true){
        if(role==false){
            return "auth/customer";


        }
        else {

            return "auth/admin";

        }



    }


    if(role==false){
        return "media/list";


    }
    else {

        return "media/register";

    }
*/

}



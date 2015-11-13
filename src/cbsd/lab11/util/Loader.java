package cbsd.lab11.util;



import cbsd.lab11.dao.CustomerDAO;
import cbsd.lab11.dao.UserDAO;
import cbsd.lab11.entity.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 1/26/13
 * Time: 7:51 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
    CustomerDAO customerDAO;

    @Autowired
    UserDAO userDAO;

    boolean isLoad = false;
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //To change body of implemented methods use File | Settings | File Templates.
        if (!isLoad){
            //To change body of implemented methods use File | Settings | File Templates.
            if (!isLoad){

                isLoad = true;

                // add the login data

                User user = new User();
                user.setUsername("newnok6");
                // Actual password: user
                user.setPassword("ee11cbb19052e40b07aac0ca060c23ee");
                user.setRole(1);
                userDAO.saveUser(user);
                
              
                
               
                for(int i=0;i<customerDAO.getAllCustomer().size();i++){
                	User user1 = new User();
                    user1.setUsername(customerDAO.getAllCustomer().get(i).getUsername());
                    try {
						user1.setPassword(convertToMd5(customerDAO.getAllCustomer().get(i).getPassword()));
					} catch (UnsupportedEncodingException e) {						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                   user1.setRole(2);
                   userDAO.saveUser(user);
                   
                }



            }
        }
    }
    

    public  String convertToMd5( String md5) throws UnsupportedEncodingException {
        StringBuffer sb=null;
        try {
            final java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            final byte[] array = md.digest(md5.getBytes("UTF-8"));
            sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (final java.security.NoSuchAlgorithmException e) {
        }
        return sb.toString();
    }

     

    
    	
    	
    
}

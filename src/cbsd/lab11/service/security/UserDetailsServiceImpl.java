package cbsd.lab11.service.security;

import cbsd.lab11.dao.UserDAO;
import cbsd.lab11.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/10/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDAO userDAO;
    @Override
    @Transactional(readOnly = true)

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = null;
        try{
            User appUser = userDAO.findByName(s);

            user = new org.springframework.security.core.userdetails.User(
                    appUser.getUsername().toLowerCase(),appUser.getPassword().toLowerCase(),
                    true,true,true,true,getAuthorities(new Integer(appUser.getRole())));



        } catch (Exception e) {

            throw new UsernameNotFoundException("Error in retrieving user");
        }
        return user;
    }



    public Collection<GrantedAuthority> getAuthorities(Integer access) {
        // Create a list of grants for this user
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        // All users are granted with ROLE_USER access
        // Therefore this user gets a ROLE_USER by default

        authList.add(new SimpleGrantedAuthority("ROLE_USER"));

        // Check if this user has admin access
        // We interpret Integer(1) as an admin user
        if ( access.compareTo(1) == 0) {
            // User has admin access
            authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        // Return list of granted authorities
        return authList;
    }
    
    
    
    
}
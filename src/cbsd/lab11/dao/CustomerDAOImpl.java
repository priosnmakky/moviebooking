
package cbsd.lab11.dao;


import cbsd.lab11.entity.Customer;
import cbsd.lab11.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by narongrit on 2/26/14.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    UserDAO userDAO;
    @Autowired
    private SessionFactory sessionFactory;
  
    @Override
    public void addCustomer(Customer customer) {

        User user = new User();
        
       
        SecurityMD5 md5  = new SecurityMD5();
        user.setUsername(customer.getUsername());
        try {
        	
			user.setPassword(md5.convertToMd5(customer.getPassword()));
        	
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        user.setRole(2);
        
        
        userDAO.saveUser(user);
      
      sessionFactory.getCurrentSession().saveOrUpdate(customer);

    }

    @Override
    public List<Customer> getAllCustomer() {
        List    customerlist = sessionFactory.getCurrentSession().createQuery("from Customer").list();
        return customerlist;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Customer customer =(Customer) sessionFactory.getCurrentSession().createQuery("from Customer c where c.username='"+username+"'").uniqueResult();
      //  User user =(User) sessionFactory.getCurrentSession().createQuery("from User u where u.username='"+username+"'").uniqueResult();
 
        return customer;

    }



    @Override
    public void updateCustomer(Customer customer) {
    	SecurityMD5 md5  = new SecurityMD5();
        User user = userDAO.findByName(customer.getUsername());

        user.setUsername(customer.getUsername());
        try {
			user.setPassword(md5.convertToMd5(customer.getPassword()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        user.setRole(2);
        userDAO.saveUser(user);
        sessionFactory.getCurrentSession().saveOrUpdate(customer);


    }

    @Override
    public List<Customer> getCustomerBykey(String key) {
        //Customer customer = (Student) sessionFactory.getCurrentSession().createQuery
        //  (from Page as p where p.SiteId = :site and p.Path like :folder% and p.Path not like :folder%/%order by p.Name  )
        return null;
    }




}

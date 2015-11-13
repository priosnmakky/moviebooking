package cbsd.lab11.service;

import cbsd.lab11.entity.Customer;
import cbsd.lab11.entity.Image;

import java.util.List;

/**
 * Created by narongrit on 2/27/14.
 */
public interface CustomerService {
    public void register(Customer customer);
    public boolean checkCustomer(String username) ;
    public  Customer getCustomerByUsername(String username);
    public List<Customer> getAllCustomer();


    public boolean checkFormName(String username) ;
    public boolean checkFormUsername(String username) ;
    public boolean checkFormPassword(String password) ;
    public boolean checkFormPicture(Image image);
    public  void updateCustomer(Customer customer);


}

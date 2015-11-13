package cbsd.lab11.dao;

import cbsd.lab11.entity.Customer;

import java.util.List;

/**
 * Created by narongrit on 2/26/14.
 */
public interface CustomerDAO {
    public void addCustomer(Customer customer);
    public List<Customer> getAllCustomer();
    public  Customer getCustomerByUsername(String username);
    public  void updateCustomer(Customer customer);
    public List<Customer> getCustomerBykey(String key);

}

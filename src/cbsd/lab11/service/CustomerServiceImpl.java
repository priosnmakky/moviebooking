package cbsd.lab11.service;

import cbsd.lab11.dao.CustomerDAO;
import cbsd.lab11.entity.Customer;
import cbsd.lab11.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by narongrit on 2/27/14.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDAO customerDAO;


    @Override
    @Transactional
    public void register(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    @Transactional
    public boolean checkCustomer(String username) {
		return false;
    	//customerDAO.
    }

    @Override
    @Transactional
    public Customer getCustomerByUsername(String username) {
        return customerDAO.getCustomerByUsername(username);
    }

    @Override
    @Transactional
    public List<Customer> getAllCustomer() {
        return customerDAO.getAllCustomer();
    }



    @Override
    @Transactional
    public boolean checkFormName(String username) {
        return false;
    }

    @Override
    @Transactional
    public boolean checkFormUsername(String username) {
        return false;
    }

    @Override
    @Transactional
    public boolean checkFormPassword(String password) {
        return false;
    }

    @Override
    @Transactional
    public boolean checkFormPicture(Image image) {
        return false;
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        customerDAO.updateCustomer(customer);
    }
}

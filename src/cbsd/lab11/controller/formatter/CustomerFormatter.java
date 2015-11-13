package cbsd.lab11.controller.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import cbsd.lab11.entity.Customer;
import cbsd.lab11.entity.Movie;
import cbsd.lab11.service.CustomerService;
import cbsd.lab11.service.MovieService;



@Component
public class CustomerFormatter implements Formatter<Customer> {
    @Autowired
    CustomerService customerService;
    @Override
    public Customer parse(String s, Locale locale) throws ParseException {

       // return movieService.getMovieById(Integer.valueOf(s));
   return customerService.getCustomerByUsername(s);
    }

    @Override
    public String print(Customer customer, Locale locale) {

        return customer.getFname();
    }

	
}

package cbsd.lab11.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by narongrit on 2/26/14.
 */
@Entity

public class Customer  {
    public Customer(String email, String address, String lname, String fname) {

        this.email = email;
        this.address = address;
        this.lname = lname;
        this.fname = fname;
    }

    public Customer(String username, String lname, String fname, String address, String email, Image image) {
        this.id = id;
        this.username = username;
        this.lname = lname;
        this.fname = fname;
        this.address = address;
        this.email = email;
        this.image = image;
    }

    @Id

    @GeneratedValue
  Long id;
    @NotEmpty(message = "Please Enter username")

    String username;
    @NotEmpty(message = "Please Enter password")

    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "Please Enter last Name")

    String lname;
    @NotEmpty(message = "Please Enter first Name")

    String fname;

  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Customer() {

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @NotEmpty(message = "Please address Name")

    String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @NotEmpty(message = "Please Email ")

    String email;

    @Cascade({CascadeType.ALL})
    @OneToOne
    Image image;

}

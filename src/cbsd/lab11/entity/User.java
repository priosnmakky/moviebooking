package cbsd.lab11.entity;

import


        javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/3/13
 * Time: 1:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue
    Long id;
     String username;
    String password;
 
    int role;
    
   

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
  


}

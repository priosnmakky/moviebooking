package cbsd.lab11.dao;

import cbsd.lab11.entity.Customer;
import cbsd.lab11.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User findByName(String username) {
    	   User user =(User) sessionFactory.getCurrentSession().createQuery("from User u where u.username='"+username+"'").uniqueResult();
    	
    	//  return (User)sessionFactory.getCurrentSession().createQuery("from User u where u.username like :username")
       //         .setString("username", username).uniqueResult();
    	return user;
    }

    @Override
    public void saveUser(User user) {
       sessionFactory.getCurrentSession().saveOrUpdate(user);
    //return null;
    }
}

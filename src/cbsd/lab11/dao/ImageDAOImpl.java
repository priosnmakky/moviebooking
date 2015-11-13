package cbsd.lab11.dao;

import cbsd.lab11.entity.Image;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/10/13
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ImageDAOImpl implements ImageDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
      public Image get(Integer id) {
        return (Image) sessionFactory.getCurrentSession().get(Image.class,id);
    }
}

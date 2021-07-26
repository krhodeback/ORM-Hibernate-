package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Component
public class UserDaoImp implements UserDao {


    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User ");
        return query.getResultList();
    }

    public User getUserByCar(Car car) {
        Query query = null;
        query = sessionFactory.openSession()
                .createQuery("from User user LEFT OUTER JOIN FETCH user.car WHERE model =:model AND series = :series");
        query.setParameter("model", car.getModel());
        query.setParameter("series", car.getSeries());
        return (User) query.getSingleResult();

    }

}

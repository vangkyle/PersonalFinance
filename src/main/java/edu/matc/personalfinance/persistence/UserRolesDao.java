package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.User;
import edu.matc.personalfinance.entity.UserRoles;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvang on 3/25/17.
 */
public class UserRolesDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<UserRoles> getAllUserRoles() {
        List<UserRoles> userRoles = new ArrayList<UserRoles>();
        Session session = null;
        try {
            session = openSession();
            userRoles = session.createCriteria(UserRoles.class).list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userRoles;

    }

    public void saveUserRole() {
        UserRoles userRoles = new UserRoles();
        User user = new User();
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            session.save(userRoles);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

}

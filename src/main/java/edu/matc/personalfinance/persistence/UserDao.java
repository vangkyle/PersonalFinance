package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvang on 2/12/17.
 */
public class UserDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Returnt a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = openSession();
            users = session.createCriteria(User.class).list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    /** Get a single user for the given id
     *
     * @param id user's id
     * @return User
     */
    public User getUser(int id) {
        User user = null;
        Session session = null;
        try {
            session = openSession();
            user = (User) session.get(User.class, id);
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    /** Retrieve users by lastname
     *
     * @param lastName User's last name which is the search criteria
     * @return User
     */
    public List<User> getUsersByLastName(String lastName) {
        List<User> users = new ArrayList<User>();
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("lastName", lastName));
            users = criteria.list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }

    /** save or update user
     * @param user
     * @return id of the inserted user
     */

    public int add(User user) {
        int id = 0;
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(user);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public int deleteUserById(int id) {
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(id);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }


    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}

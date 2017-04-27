package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.UserRoles;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by kvang on 3/25/17.
 */
public class UserRolesDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<UserRoles> getAllUserRoles() {
        List<UserRoles> userRoles = null;
        Session session = null;

        try {
            session = openSession();
            userRoles = session.createCriteria(UserRoles.class).list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in getAllUserRoles(): " + he);
        } catch (Exception e) {
            logger.error("Exception in getAllUserRoles(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userRoles;

    }

    public UserRoles getUserRole(int id) {
        Session session = null;
        UserRoles userRole = null;

        try {
            session = openSession();
            userRole = (UserRoles) session.get(UserRoles.class, id);
        } catch (HibernateException e) {
            logger.error("Hibernate Exception", e);
        } catch (Exception e) {
            logger.error("Exception in getUserRole(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return userRole;
    }

    public int addRole(UserRoles userRole) {
        int id = 0;
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(userRole);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in addRole(): " + he);
        } catch (Exception e) {
            logger.error("Exception in addRole(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public void deleteRole(int id) {
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            UserRoles userRole = (UserRoles) session.get(UserRoles.class, id);
            session.delete(userRole);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in deleteRole(): " + he);
        } catch (Exception e) {
            logger.error("Exception in deleteRole(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateRole(UserRoles userRole) {
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            session.update(userRole);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in updateRole(): " + he);
        } catch (Exception e) {
            logger.error("Exception in updateRole(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public UserRoles getRoleByUserName(String user) {
        Session session = null;
        UserRoles role = null;

        try {
            session = openSession();
            role = (UserRoles) session.createQuery("from edu.matc.personalfinance.entity.UserRoles U where U.user_name = :username")
                    .setString("username", user)
                    .uniqueResult();
            logger.info("role return is: " + role);
            return role;
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in getRoleByUserName(): " + he);
        } catch (Exception e) {
            logger.error("Exception in getRoleByUserName(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return role;
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

}

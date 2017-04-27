package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.Subcategory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by kvang on 4/26/17.
 */
public class SubcategoryDao {

    private final Logger logger = Logger.getLogger(this.getClass());


    public List<Subcategory> getAllSubcategory() {
        List<Subcategory> subcategories = null;
        Session session = null;
        try {
            session = openSession();
            subcategories = session.createCriteria(Subcategory.class).list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in getAllSubcategory: " + he);
        } catch (Exception e) {
            logger.error("Exception in getAllSubcategory: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return subcategories;
    }

    public Subcategory getSubcategory(int id) {
        Subcategory subcategory = null;
        Session session = null;

        try {
            session = openSession();
            subcategory = (Subcategory) session.get(Subcategory.class, id);
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in getSubcategory(): " + he);
        } catch (Exception e) {
            logger.error("Exception in getSubcategory(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return subcategory;
    }


    public int addSubcategory(Subcategory subcategory) {
        int id = 0;
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(subcategory);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in addSubcategory(): " + he);
        } catch (Exception e) {
            logger.error("Exception in addSubcategory(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public void deleteSubcategory(int id) {
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            Subcategory subcategory = (Subcategory) session.get(Subcategory.class, id);
            session.delete(subcategory);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in deleteSubcategory(): " + he);
        } catch (Exception e) {
            logger.error("Exception in deleteSubcategory(): " + e);
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

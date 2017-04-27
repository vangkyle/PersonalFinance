package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.Category;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by kvang on 4/26/17.
 */
public class CategoryDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<Category> getAllCategory() {
        List<Category> categories = null;
        Session session = null;

        try {
            session = openSession();
            categories = session.createCriteria(Category.class).list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in getAllCategory(): " + he);
        } catch (Exception e) {
            logger.error("Exception in getAllCategory(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return categories;
    }

    public Category getCategory(int id) {
        Category category = null;
        Session session = null;

        try {
            session = openSession();
            category = (Category) session.get(Category.class, id);
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in getCategory(): " + he);
        } catch (Exception e) {
            logger.error("Exception in getCategory(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return category;
    }


    public int addCategory(Category category) {
        int id = 0;
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(category);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in addCategory(): " + he);
        } catch (Exception e) {
            logger.error("Exception in addCategory(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public void deleteCategory(int id) {
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            Category category = (Category) session.get(Category.class, id);
            session.delete(category);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in deleteCategory(): " + he);
        } catch (Exception e) {
            logger.error("Exception in deleteCategory(): " + e);
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

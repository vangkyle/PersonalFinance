package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.TransactionRecord;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by kvang on 2/20/17.
 */
public class TransactionRecordDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<TransactionRecord> getAllTransactionRecord() {
        List<TransactionRecord> transactionRecords = null;
        Session session = null;
        try {
            session = openSession();
            transactionRecords = session.createCriteria(TransactionRecord.class).list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in getAllTransactionRecord(): " + he);
        } catch (Exception e) {
            logger.error("Exception in getAllTransactionRecord(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return transactionRecords;
    }


    public TransactionRecord getTransactionById(int id) {
        TransactionRecord transactionRecord = null;
        Session session = null;
        try {
            session = openSession();
            transactionRecord = (TransactionRecord) session.get(TransactionRecord.class, id);
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in getTransactionById(): " + he);
        } catch (Exception e) {
            logger.error("Exception in getTransactionById(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return transactionRecord;
    }


    public int addTransactionRecord(TransactionRecord transactionRecord) {
        int id = 0;
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(transactionRecord);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in addTransactionRecord(): " + he);
        } catch (Exception e) {
            logger.error("Exception in addTransactionRecord(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        logger.info("returned id: " + id);
        return id;

    }

    public void deleteTransactionRecord(int id) {
        Session session = null;

        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            TransactionRecord transactionRecord = (TransactionRecord) session.get(TransactionRecord.class, id);
            session.delete(transactionRecord);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception in deleteTransactionRecord(): " + he);
        } catch (Exception e) {
            logger.error("Exception in deleteTransactionRecord(): " + e);
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

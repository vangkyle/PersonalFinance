package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.TransactionRecord;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvang on 2/20/17.
 */
public class TransactionRecordDao {

    private final Logger logger = Logger.getLogger(this.getClass());

    public List<TransactionRecord> getAllTransactionRecord() {
        List<TransactionRecord> transactionRecords = new ArrayList<TransactionRecord>();
        Session session = null;
        try {
            session = openSession();
            transactionRecords = session.createCriteria(TransactionRecord.class).list();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return transactionRecords;
    }

    /**
     * save or update transactionRecord
     *
     * @param transactionRecord
     * @return id of the transaction record
     */

    public void addTransactionRecord(TransactionRecord transactionRecord) {
        int id = 0;
        Session session = null;
        try {
            session = openSession();
            Transaction transaction = session.beginTransaction();
            id = (int) session.save(transactionRecord);
            transaction.commit();
        } catch (HibernateException he) {
            logger.error("Hibernate Exception: " + he);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        }

    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

}

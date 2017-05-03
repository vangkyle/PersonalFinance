package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.Category;
import edu.matc.personalfinance.entity.TransactionRecord;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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


    public TransactionRecord getTransaction(int id) {
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
        Transaction tx = null;
        try {
            session = openSession();
            tx = session.beginTransaction();
            id = (int) session.save(transactionRecord);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception in addTransactionRecord(): " + he);
        } catch (Exception e) {
            logger.error("Exception in addTransactionRecord(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public int addFromExpenseEntry(Date date, double amount, Category category) {
        int id = 0;
        int newCat = 0;
        Session session = null;
        Transaction tx = null;

        try {
            session = openSession();
            tx = session.beginTransaction();

            TransactionRecord transactionRecord = new TransactionRecord();
            transactionRecord.setDate(date);
            transactionRecord.setAmount(amount);
            transactionRecord.setCategory(category);
            id = (int) session.save(transactionRecord);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception in addFromExpenseEntry(): " + he);
        } catch (Exception e) {
            logger.error("Exception in addFromExpenseEntry(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public void deleteTransactionRecord(int id) {
        Session session = null;
        Transaction tx = null;

        try {
            session = openSession();
            tx = session.beginTransaction();
            TransactionRecord transactionRecord = (TransactionRecord) session.get(TransactionRecord.class, id);
            session.delete(transactionRecord);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception in deleteTransactionRecord(): " + he);
        } catch (Exception e) {
            logger.error("Exception in deleteTransactionRecord(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateTransactionRecord(TransactionRecord transactionRecord) {
        Session session = null;
        Transaction tx = null;

        try {
            session = openSession();
            tx = session.beginTransaction();
            session.update(transactionRecord);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            logger.error("Hibernate Exception in updateTransactionRecord(): " + he);
        } catch (Exception e) {
            logger.error("Exception in deleteTransactionRecord(): " + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private LocalDate getLocalDate(String inputDate) {
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(inputDate, DATE_FORMAT);
    }


    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

}

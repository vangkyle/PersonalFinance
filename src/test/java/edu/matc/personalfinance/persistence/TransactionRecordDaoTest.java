package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.Category;
import edu.matc.personalfinance.entity.TransactionRecord;
import edu.matc.personalfinance.entity.User;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 2/20/17.
 */
public class TransactionRecordDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    // TransactionRecord
    TransactionRecordDao transactionRecordDao;
    TransactionRecord transactionRecord;
    int newTransaction = 0;

    // User
    UserDao dao;
    User user;
    int newUser1 = 0;


    // Category
    CategoryDao categoryDao;
    Category category;
    int newCat = 0;
    int newCat2 = 0;

    @Before
    public void setUp() throws Exception {

        dao = new UserDao();
        user = new User();
        user.setFirstName("Tom");
        user.setLastName("Johnson");
        user.setEmail("tj@mail.com");
        user.setUserName("TomJ");
        user.setUserPass("JohnsonTom");
        newUser1 = dao.addUser(user);

        categoryDao = new CategoryDao();
        category = new Category();
        category.setCat_description("Family");
        newCat = categoryDao.addCategory(category);

        transactionRecordDao = new TransactionRecordDao();
        transactionRecord = new TransactionRecord();
        transactionRecord.setDate(getDateFormatted("10-02-2017"));
        transactionRecord.setAmount(100000);
        transactionRecord.setUser(user);
        transactionRecord.setCategory(category);

    }

    @Test
    public void getAllTransactionRecord() throws Exception {
        newTransaction = transactionRecordDao.addTransactionRecord(transactionRecord);
        List<TransactionRecord> transactionRecords = transactionRecordDao.getAllTransactionRecord();
        assertTrue(transactionRecords.size() > 0);
    }

    @Test
    public void getTransaction() throws Exception {
        newTransaction = transactionRecordDao.addTransactionRecord(transactionRecord);

        assertEquals("double", 12, 12.00, 0);

        assertNotNull("no transaction returned", transactionRecordDao.getTransaction(newTransaction));
        assertEquals("date not returned correctly", transactionRecord.getDate(), transactionRecordDao.getTransaction(newTransaction).getDate());
        assertEquals("amount not returned correctly", transactionRecord.getAmount(), transactionRecordDao.getTransaction(newTransaction).getAmount(), 0);
        assertEquals("User not returned", transactionRecord.getUser().getUserid(), transactionRecordDao.getTransaction(newTransaction).getUser().getUserid());
        assertEquals("Category not returned", transactionRecord.getCategory().getCategory_id(), transactionRecordDao.getTransaction(newTransaction).getCategory().getCategory_id());
    }


    @Test
    public void addTransactionRecord() throws Exception {
        newTransaction = transactionRecordDao.addTransactionRecord(transactionRecord);
        assertNotEquals("no transaction added", 0, transactionRecordDao.getTransaction(newTransaction));
        assertEquals("date no added", transactionRecord.getDate(), transactionRecordDao.getTransaction(newTransaction).getDate());
        assertEquals("amount not added ", transactionRecord.getAmount(), transactionRecordDao.getTransaction(newTransaction).getAmount(), 0);
        assertEquals("User not added", transactionRecord.getUser().getUserid(), transactionRecordDao.getTransaction(newTransaction).getUser().getUserid());
        assertEquals("Category not added", transactionRecord.getCategory().getCategory_id(), transactionRecordDao.getTransaction(newTransaction).getCategory().getCategory_id());


    }

    @Test
    public void addFromExpenseEntry() throws Exception {
        newTransaction = transactionRecordDao.addTransactionRecord(transactionRecord);

        assertNotEquals("no user added from signup", 0, newTransaction);
        assertEquals("transaction Id not returned correctly", transactionRecord.getTransid(), transactionRecordDao.getTransaction(newTransaction).getTransid());
        assertEquals("date not returned correctly", transactionRecord.getDate(), transactionRecordDao.getTransaction(newTransaction).getDate());
        assertEquals("amount not returned correctly", transactionRecord.getAmount(), transactionRecordDao.getTransaction(newTransaction).getAmount(), 0);
        assertEquals("category not returned correctly", transactionRecord.getCategory().getCategory_id(), transactionRecordDao.getTransaction(newTransaction).getCategory().getCategory_id());

    }

    @Test
    public void deleteTransactionRecord() throws Exception {
        transactionRecordDao.addTransactionRecord(transactionRecord);
        transactionRecordDao.deleteTransactionRecord(8);
        //assertNull("transaction not deleted", transactionRecordDao.getTransaction(transactionRecord.getTransid()));
    }

    @Test
    public void updateTransactionRecord() throws Exception {
        newTransaction = transactionRecordDao.addTransactionRecord(transactionRecord);

        Category category2 = new Category();
        category2.setCat_description("New Category");
        newCat2 = categoryDao.addCategory(category2);

        transactionRecord.setDate(getDateFormatted("12-12-2016"));
        transactionRecord.setAmount(910.89);
        transactionRecord.setUser(user);
        transactionRecord.setCategory(category);

        transactionRecordDao.updateTransactionRecord(transactionRecord);
        assertEquals("date not updated", transactionRecord.getDate(), transactionRecordDao.getTransaction(newTransaction).getDate());
        assertEquals("amount not updated", transactionRecord.getAmount(), transactionRecordDao.getTransaction(newTransaction).getAmount(), 0);
        assertEquals("user id not updated", transactionRecord.getUser().getUserid(), transactionRecordDao.getTransaction(newTransaction).getUser().getUserid());
        assertEquals("category not updated", transactionRecord.getCategory().getCat_description(), transactionRecordDao.getTransaction(newTransaction).getCategory().getCat_description());

    }

    @After
    public void cleanup() {
        if (newUser1 != 0) {
            dao.deleteUser(newUser1);
        }

        if (newCat != 0) {
            categoryDao.deleteCategory(newCat);
        }

        if (newTransaction != 0) {
            transactionRecordDao.deleteTransactionRecord(newTransaction);
        }
    }

    private Date getDateFormatted(String inputDate2) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(inputDate2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private LocalDate getLocalDate(String inputDate) {
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(inputDate, DATE_FORMAT);
    }
}

package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.Category;
import edu.matc.personalfinance.entity.Subcategory;
import edu.matc.personalfinance.entity.TransactionRecord;
import edu.matc.personalfinance.entity.User;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 2/20/17.
 */
public class TransactionRecordDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    // TransactionRecord
    TransactionRecordDao trd;
    TransactionRecord tr;

    int newTransactionId = 0;

    // User
    UserDao dao;
    User user;

    int newUser = 0;
    String newFirst = "Frances";
    String newLast = "Lo";
    String newEmail = "flo@mail.com";
    String newUserName = "flo";
    String newUserPass = "flo1";

    // Category

    CategoryDao categoryDao;
    Category category;

    int newCat3 = 0;
    String newCatDesc = "Hello";

    // Subcategory
    SubcategoryDao subcategoryDao;
    Subcategory subcategory;

    int newSubcat3 = 0;
    String newSubcatDesc = "World";


    @Before
    public void setUp() throws Exception {
        trd = new TransactionRecordDao();
        tr = new TransactionRecord();

        tr.setDate(getLocalDate("30-02-2017"));
        tr.setType("expense");
        tr.setAmount(new BigDecimal(12.99));
        //tr.setUser();
        tr.setCategory(category);
        tr.setSubcategory(subcategory);



    }

    @Test
    public void getAllTransactionRecord() throws Exception {
        newTransactionId = trd.addTransactionRecord(tr);
        List<TransactionRecord> transactionRecords = trd.getAllTransactionRecord();
        assertTrue(transactionRecords.size() > 0);
    }

    @Test
    public void getTransactionById() throws Exception {
        newTransactionId = trd.addTransactionRecord(tr);

        assertNotNull("no transaction returned", trd.getTransactionById(newTransactionId));
        assertEquals("trans_id not return correctly", tr.getTransid(), trd.getTransactionById(newTransactionId).getTransid());
        assertEquals("date not returned correctly", tr.getDate(), trd.getTransactionById(newTransactionId).getDate());
        assertEquals("type not return correctly", tr.getType(), trd.getTransactionById(newTransactionId).getType());
        assertEquals("amount not return correctly", tr.getAmount(), trd.getTransactionById(newTransactionId).getAmount());

    }


    @Test
    public void addTransactionRecord() throws Exception {
        newTransactionId = trd.addTransactionRecord(tr);
        assertNull(tr.getCategory());
        assertNotEquals("no transaction added", 0, newTransactionId);
        assertEquals("trans id not returned correctly", tr.getTransid(), trd.getTransactionById(newTransactionId).getTransid());
        assertEquals("date not returned correctly", tr.getDate(), trd.getTransactionById(newTransactionId).getDate());
        assertEquals("type not return correctly", tr.getType(), trd.getTransactionById(newTransactionId).getType());
        assertEquals("amount not return correctly", tr.getAmount(), trd.getTransactionById(newTransactionId).getAmount());
    }

    @Test
    public void deleteTransactionRecord() throws Exception {
        trd.addTransactionRecord(tr);
        trd.deleteTransactionRecord(tr.getTransid());
        assertNull("transaction not deleted", trd.getTransactionById(tr.getTransid()));
    }

    private LocalDate getLocalDate(String inputDate) {
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(inputDate, DATE_FORMAT);
    }
}

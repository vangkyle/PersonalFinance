/*package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.TransactionRecord;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.*;
*/
/**
 * Created by kvang on 2/20/17.
 */
/*public class TransactionRecordDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    TransactionRecordDao trd;
    TransactionRecord transactionRecord;

    @Before
    public void setUp() throws Exception {
        trd = new TransactionRecordDao();
        transactionRecord = new TransactionRecord();
    }

    @Test
    public void getAllTransactionRecord() throws Exception {
        List<TransactionRecord> transactionRecords = trd.getAllTransactionRecord();
        assertNotNull(transactionRecords);
        assertTrue(transactionRecords.size() > 0);
    }

    //TODO finish add trans record, need join table
    @Test
    public void addTransactionRecord() throws Exception {
        transactionRecord = new TransactionRecord();
        int id = trd.addTransactionRecord(transactionRecord);
        logger.debug(transactionRecord);
        logger.debug(trd);
        logger.debug(trd.addTransactionRecord(transactionRecord));

        assertNotEquals(0, id);
        assertNotNull(transactionRecord);
        assertNotNull(trd);

        TransactionRecord insertTransaction = trd.getTransaction(id);
        assertEquals(transactionRecord.getDate(), insertTransaction.getDate());
        assertEquals(transactionRecord.getType(), insertTransaction.getType());
        assertEquals(transactionRecord.getAmount(), insertTransaction.getAmount());
        assertEquals(transactionRecord.getUser_id(), insertTransaction.getUser_id());
        assertEquals(transactionRecord.getCategory_id(), insertTransaction.getCategory_id());
        assertEquals(transactionRecord.getSubcategory_id(), insertTransaction.getSubcategory_id());
    }

    private LocalDate getLocalDate(String inputDate) {
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(inputDate, DATE_FORMAT);
    }
}
*/
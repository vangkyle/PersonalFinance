package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.TransactionRecord;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 2/20/17.
 */
public class TransactionRecordDaoTest {

    TransactionRecordDao trd;

    @Before
    public void setUp() throws Exception {
        trd = new TransactionRecordDao();
    }

    @Test
    public void getAllTransactionRecord() throws Exception {
        //List<TransactionRecord> transactionRecords = trd.getAllTransactionRecord();
        //assertTrue(transactionRecords.size() > 0);
    }

    @Test
    public void addTransactionRecord() throws Exception {
        //TransactionRecord transactionRecord = new TransactionRecord("01-01-2000", "typeTest", "categoryTest", "descriptionTest", 1.99);
    }

}
package edu.matc.personalfinance.entity;

import edu.matc.personalfinance.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by kvang on 2/14/17.
 */
@Entity
@Table(name = "transaction", catalog = "financetracker")
public class TransactionRecord implements java.io.Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "trans_id")
    private int transid;

    @Column(name = "date")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate date;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private BigDecimal amount;

    public TransactionRecord() {
    }

    public TransactionRecord(LocalDate date, String type, BigDecimal amount) {
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public int getTransid() {
        return transid;
    }

    public void setTransid(int transid) {
        this.transid = transid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionRecord{" +
                "transid=" + transid +
                ", date=" + date +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}

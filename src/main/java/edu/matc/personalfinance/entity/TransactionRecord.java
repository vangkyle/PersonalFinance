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
@Table(name = "transaction", catalog = "financetracker", uniqueConstraints = {
        @UniqueConstraint(columnNames = "date")
})
public class TransactionRecord implements java.io.Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "trans_id")
    private int transid;

    @Column(name = "date")
    @Converter(converter = LocalDateAttributeConverter.class)
    private LocalDate date;

    @Column(name = "type")
    private String type;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private BigDecimal amount;

    public TransactionRecord() {
    }

    public TransactionRecord(int transid, LocalDate date, String type, String category, String description, BigDecimal amount) {
        this.transid = transid;
        this.date = date;
        this.type = type;
        this.category = category;
        this.description = description;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}

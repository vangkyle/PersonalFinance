package edu.matc.personalfinance.entity;

import edu.matc.personalfinance.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by kvang on 2/14/17.
 */
@Entity
@Table(name = "transaction")
public class TransactionRecord implements Serializable {

    private int transid;
    private LocalDate date;
    private String type;
    private BigDecimal amount;
    private User user;
    private Category category;
    private Subcategory subcategory;

    public TransactionRecord() {
    }


    public TransactionRecord(int transid, LocalDate date, String type, BigDecimal amount) {
        this.transid = transid;
        this.date = date;
        this.type = type;
        this.amount = amount;
    }


    public TransactionRecord(int transid, LocalDate date, String type, BigDecimal amount, User user, Category category, Subcategory subcategory) {
        this.transid = transid;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.user = user;
        this.category = category;
        this.subcategory = subcategory;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "trans_id")
    public int getTransid() {
        return transid;
    }

    public void setTransid(int transid) {
        this.transid = transid;
    }

    @Column(name = "date")
    @Convert(converter = LocalDateAttributeConverter.class)
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }


}

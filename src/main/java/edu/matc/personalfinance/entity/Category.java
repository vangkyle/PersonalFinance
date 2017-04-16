package edu.matc.personalfinance.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kvang on 3/7/17.
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    private int category_id;
    private String cat_description;
    private TransactionRecord transactionRecord;
    private Subcategory subcategory;

    public Category() {
    }

    public Category(int category_id, String cat_description) {
        this.category_id = category_id;
        this.cat_description = cat_description;
    }

    public Category(int category_id, String cat_description, TransactionRecord transactionRecord, Subcategory subcategory) {
        this.category_id = category_id;
        this.cat_description = cat_description;
        this.transactionRecord = transactionRecord;
        this.subcategory = subcategory;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "category_id")
    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Column(name = "cat_description")
    public String getCat_description() {
        return cat_description;
    }

    public void setCat_description(String cat_description) {
        this.cat_description = cat_description;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trans_id")
    public TransactionRecord getTransactionRecord() {
        return transactionRecord;
    }

    public void setTransactionRecord(TransactionRecord transactionRecord) {
        this.transactionRecord = transactionRecord;
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

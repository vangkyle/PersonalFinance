package edu.matc.personalfinance.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kvang on 3/7/17.
 */
@Entity
@Table(name = "subcategory")
public class Subcategory implements Serializable {

    private int subcategory_id;
    private String subcat_description;
    private Category category2;
    private Set<TransactionRecord> transactionRecordSet = new HashSet<TransactionRecord>(0);

    public Subcategory() {
    }

    public Subcategory(int subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public Subcategory(int subcategory_id, String subcat_description) {
        this.subcategory_id = subcategory_id;
        this.subcat_description = subcat_description;
    }

    public Subcategory(String subcat_description) {
        this.subcat_description = subcat_description;
    }

    public Subcategory(int subcategory_id, String subcat_description, Category category2) {
        this.subcategory_id = subcategory_id;
        this.subcat_description = subcat_description;
        this.category2 = category2;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "subcategory_id")
    public int getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(int subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    @Column(name = "subcat_description")
    public String getSubcat_description() {
        return subcat_description;
    }

    public void setSubcat_description(String subcat_description) {
        this.subcat_description = subcat_description;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    public Category getCategory2() {
        return category2;
    }

    public void setCategory2(Category category2) {
        this.category2 = category2;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subcategory")
    public Set<TransactionRecord> getTransactionRecordSet() {
        return transactionRecordSet;
    }

    public void setTransactionRecordSet(Set<TransactionRecord> transactionRecordSet) {
        this.transactionRecordSet = transactionRecordSet;
    }
}

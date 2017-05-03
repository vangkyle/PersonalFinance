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
@Table(name = "category")
public class Category implements Serializable {

    private int category_id;
    private String cat_description;
    private Set<TransactionRecord> recordSet = new HashSet<TransactionRecord>(0);

    public Category() {
    }

    public Category(String cat_description) {
        this.cat_description = cat_description;
    }

    public Category(int category_id, String cat_description) {
        this.category_id = category_id;
        this.cat_description = cat_description;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    public Set<TransactionRecord> getRecordSet() {
        return recordSet;
    }

    public void setRecordSet(Set<TransactionRecord> recordSet) {
        this.recordSet = recordSet;
    }

}

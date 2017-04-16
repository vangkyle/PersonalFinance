package edu.matc.personalfinance.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by kvang on 3/7/17.
 */
@Entity
@Table(name = "subcategory", catalog = "financetracker")
public class Subcategory implements Serializable {

    private int subcategory_id;
    private String subcat_description;
    private Category category_id;

    public Subcategory() {
    }

    public Subcategory(int subcategory_id, String subcat_description) {
        this.subcategory_id = subcategory_id;
        this.subcat_description = subcat_description;
    }

    public Subcategory(int subcategory_id, String subcat_description, Category category_id) {
        this.subcategory_id = subcategory_id;
        this.subcat_description = subcat_description;
        this.category_id = category_id;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

}

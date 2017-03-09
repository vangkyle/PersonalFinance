package edu.matc.personalfinance.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by kvang on 3/7/17.
 */
@Entity
@Table(name = "category", catalog ="financetracker")
public class Category implements java.io.Serializable {

    private int category_id;
    private String description;
    private Set<TransactionRecord> transactionRecords = new HashSet<TransactionRecord>(0);

    /**
     * Instantiates a new Category.
     */
    public Category() {
    }

    /**
     * Instantiates a new Category.
     *
     * @param category_id the category id
     * @param description the description
     */
    public Category(int category_id, String description) {
        this.category_id = category_id;
        this.description = description;
    }

    /**
     * Instantiates a new Category.
     *
     * @param category_id        the category id
     * @param description        the description
     * @param transactionRecords the transaction records
     */
    public Category(int category_id, String description, Set<TransactionRecord> transactionRecords) {
        this.category_id = category_id;
        this.description = description;
        this.transactionRecords = transactionRecords;
    }

    /**
     * Gets category id.
     *
     * @return the category id
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "category_id", unique = true, nullable = false)
    public int getCategory_id() {
        return category_id;
    }

    /**
     * Sets category id.
     *
     * @param category_id the category id
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets transaction records.
     *
     * @return the transaction records
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category", cascade = CascadeType.ALL)
    public Set<TransactionRecord> getTransactionRecords() {
        return transactionRecords;
    }

    /**
     * Sets transaction records.
     *
     * @param transactionRecords the transaction records
     */
    public void setTransactionRecords(Set<TransactionRecord> transactionRecords) {
        this.transactionRecords = transactionRecords;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", description='" + description + '\'' +
                ", transactionRecords=" + transactionRecords +
                '}';
    }
}

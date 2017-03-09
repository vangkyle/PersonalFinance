package edu.matc.personalfinance.entity;

import edu.matc.personalfinance.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by kvang on 2/14/17.
 */
@Entity
@Table(name = "transaction", catalog = "financetracker")
@AssociationOverrides({
        @AssociationOverride(name = "pk.user",
            joinColumns = @JoinColumn(name = "user_id")),
        @AssociationOverride(name = "pk.category",
            joinColumns = @JoinColumn(name = "category_id"))
})
public class TransactionRecord implements java.io.Serializable {

    private int transid;
    private LocalDate date;
    private String type;
    private BigDecimal amount;
    private String cat_description;
    private String subcat_description;

    /**
     * Instantiates a new Transaction record.
     */
    public TransactionRecord() {
    }

    /**
     * Instantiates a new Transaction record.
     *
     * @param date   the date
     * @param type   the type
     * @param amount the amount
     */
    public TransactionRecord(LocalDate date, String type, BigDecimal amount) {
        this.date = date;
        this.type = type;
        this.amount = amount;
    }

    public TransactionRecord(int transid, LocalDate date, String type, BigDecimal amount, String cat_description, String subcat_description) {
        this.transid = transid;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.cat_description = cat_description;
        this.subcat_description = subcat_description;
    }

    /**
     * Gets transid.
     *
     * @return the transid
     */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "trans_id", unique = true, nullable = false)
    public int getTransid() {
        return transid;
    }

    /**
     * Sets transid.
     *
     * @param transid the transid
     */
    public void setTransid(int transid) {
        this.transid = transid;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    @Column(name = "date", nullable = false)
    @Convert(converter = LocalDateAttributeConverter.class)
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    @Column(name = "amount", nullable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
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

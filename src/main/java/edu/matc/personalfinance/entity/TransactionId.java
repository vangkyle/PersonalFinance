/*package edu.matc.personalfinance.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
*/

/**
 * Created by kvang on 3/7/17.
 */
/*@Embeddable
public class TransactionId implements java.io.Serializable {

    private User user;
    private Category category;
    private Subcategory subcategory;

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne
    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o = null || getClass() != o.getClass()) return false;

        TransactionId that = (TransactionId) o;

        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (subcategory != null ? !subcategory.equals(that.subcategory) : that.subcategory != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (user != null ? user.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (subcategory != null ? subcategory.hashCode() : 0);

        return result;
    }
}
*/
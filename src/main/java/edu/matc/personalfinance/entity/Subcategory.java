package edu.matc.personalfinance.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kvang on 3/7/17.
 */
@Entity
@Table(name = "subcategory", catalog = "financetracker")
public class Subcategory {

    private int subcategory_id;
    private String description;
}

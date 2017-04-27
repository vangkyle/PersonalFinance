package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.Category;
import edu.matc.personalfinance.entity.Subcategory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 4/26/17.
 */
public class SubcategoryDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    SubcategoryDao subcategoryDao;
    Subcategory subcat;

    CategoryDao categoryDao;
    Category category;

    int newSubcat1 = 0;
    int newCat2 = 0;
    String newCatString = "Cattest";


    @Before
    public void setUp() throws Exception {
        subcategoryDao = new SubcategoryDao();
        subcat = new Subcategory();

        subcat.setSubcat_description("Test SubCat");
        subcat.setCategory2(new Category(newCat2, newCatString));


    }

    @Test
    public void getAllSubcategory() throws Exception {
        newSubcat1 = subcategoryDao.addSubcategory(subcat);
        List<Subcategory> subcategories = subcategoryDao.getAllSubcategory();
        assertTrue(subcategories.size() > 0);
    }

    @Test
    public void getsubcategory() throws Exception {
        newSubcat1 = subcategoryDao.addSubcategory(subcat);

        assertNotNull("no subcategory returned", subcategoryDao.getSubcategory(newSubcat1));
        assertEquals("subcategory id not returned correctly", subcat.getSubcategory_id(), subcategoryDao.getSubcategory(newSubcat1).getSubcategory_id());
        assertEquals("subcategory description not returned correctly", subcat.getSubcat_description(), subcategoryDao.getSubcategory(newSubcat1).getSubcat_description());

        //assertEquals("cat id and description not returned correctly", subcat.getCategory2(), subcategoryDao.getSubcategory(newSubcat1).getCategory2());

        //assertEquals("category id not returned correctly", category.getCategory_id(), categoryDao.getCategory(newCat2).getCategory_id());
        //assertEquals("category description not returned correctly", category.getCat_description(), categoryDao.getCategory(newCat2).getCat_description());
    }

    @Test
    public void addSubcategory() throws Exception {
        newSubcat1 = subcategoryDao.addSubcategory(subcat);

        assertNotEquals("no subcategory added", 0, newSubcat1);

        assertEquals("subcategory id not returned correctly", subcat.getSubcategory_id(), subcategoryDao.getSubcategory(newSubcat1).getSubcategory_id());
        assertEquals("subcategory description not returned correctly", subcat.getSubcat_description(), subcategoryDao.getSubcategory(newSubcat1).getSubcat_description());
    }

    @Test
    public void deleteSubcategory() throws Exception {
        subcategoryDao.addSubcategory(subcat);
        subcategoryDao.deleteSubcategory(subcat.getSubcategory_id());
        assertNull("subcategory not deleted", subcategoryDao.getSubcategory(subcat.getSubcategory_id()));
    }

}
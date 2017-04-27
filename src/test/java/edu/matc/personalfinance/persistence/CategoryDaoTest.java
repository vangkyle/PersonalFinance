package edu.matc.personalfinance.persistence;

import edu.matc.personalfinance.entity.Category;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kvang on 4/26/17.
 */
public class CategoryDaoTest {

    private final Logger logger = Logger.getLogger(this.getClass());
    CategoryDao categoryDao;
    Category cat;

    int newCat1 = 0;


    @Before
    public void setUp() throws Exception {
        categoryDao = new CategoryDao();
        cat = new Category();

        cat.setCat_description("Computer");
    }

    @Test
    public void getAllCategory() throws Exception {
        newCat1 = categoryDao.addCategory(cat);
        List<Category> categories = categoryDao.getAllCategory();
        assertTrue(categories.size() > 0);
    }

    @Test
    public void getCategory() throws Exception {
        newCat1 = categoryDao.addCategory(cat);

        assertNotNull("no category returned", categoryDao.getCategory(newCat1));
        assertEquals("category id not returned correctly", cat.getCategory_id(), categoryDao.getCategory(newCat1).getCategory_id());
        assertEquals("Category description not returned correctly", cat.getCat_description(), categoryDao.getCategory(newCat1).getCat_description());
    }

    @Test
    public void addCategory() throws Exception {
        newCat1 = categoryDao.addCategory(cat);

        assertNotEquals("no category added", 0, newCat1);

        assertEquals("category id not returned correctly", cat.getCategory_id(), categoryDao.getCategory(newCat1).getCategory_id());
        assertEquals("category description not returned correctly", cat.getCat_description(), categoryDao.getCategory(newCat1).getCat_description());
    }

    @Test
    public void deleteCategory() throws Exception {
        categoryDao.addCategory(cat);
        categoryDao.deleteCategory(cat.getCategory_id());
        assertNull("category not deleted", categoryDao.getCategory(cat.getCategory_id()));

    }

}
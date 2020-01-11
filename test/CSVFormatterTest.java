/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asif Meem
 */
public class CSVFormatterTest {
    
    public CSVFormatterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getCSVArrayList method, of class CSVFormatter.
     */
    @Test
    public void testGetCSVArrayList() {
        System.out.println("getCSVArrayList");
        CSVFormatter instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getCSVArrayList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFileName method, of class CSVFormatter.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        CSVFormatter instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getFileName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeader method, of class CSVFormatter.
     */
    @Test
    public void testGetHeader() {
        System.out.println("getHeader");
        CSVFormatter instance = null;
        String expResult = "";
        String result = instance.getHeader();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFooter method, of class CSVFormatter.
     */
    @Test
    public void testGetFooter() {
        System.out.println("getFooter");
        CSVFormatter instance = null;
        String expResult = "";
        String result = instance.getFooter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

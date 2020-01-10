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
public class CSVGeneratorTest {
    
    
    ArrayList test = new ArrayList();
    CSVGenerator csv;
    
    public CSVGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @Before
    public void setUp() {
        test.add("sl_no");
        test.add(",");
        test.add("book name");
        test.add(",");
        test.add("category");
        test.add("\r\n");
        test.add("1");
        test.add(",");
        test.add("book name 1");
        test.add(",");
        test.add("category 1");
        test.add("\r\n");
        test.add("2");
        test.add(",");
        test.add("book name 2");
        test.add(",");
        test.add("category 2");
        test.add("\r\n");
        csv = new CSVGenerator(test, "test2");
        
    }

    /**
     * Test of generateCSV method, of class CSVGenerator.
     */
    @Test
    public void testGenerateCSV() {
        System.out.println("generateCSV");
        CSVGenerator instance = csv;
        instance.generateCSV();
        boolean expResult = true;
        boolean result = csv.isProcessed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileName method, of class CSVGenerator.
     */
    @Test
    public void testGetFileName() {
        setUp();
        CSVGenerator instance = csv;
        String expResult = "test2";
        String result = instance.getFileName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPathString method, of class CSVGenerator.
     */
    @Test
    public void testGetPathString() {
        setUp();
        CSVGenerator instance = csv;
        String expResult = "C:\\Users\\User\\Documents\\NetBeansProjects\\Processed\\";
        String result = instance.getPathString();
        assertEquals(expResult, result);
    }

    /**
     * Test of isProcessed method, of class CSVGenerator.
     */
    @Test
    public void testIsProcessed() {
        setUp();
        csv.generateCSV();
        CSVGenerator instance = csv;
        boolean expResult = true;
        boolean result = instance.isProcessed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProcessString method, of class CSVGenerator.
     */
    @Test
    public void testGetProcessString() {
        setUp();
        CSVGenerator instance = csv;
        ArrayList expResult = test;
        ArrayList result = instance.getProcessString();
        assertEquals(expResult, result);
    }
    
}

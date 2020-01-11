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
    
    
    StringBuilder test = new StringBuilder();
    CSVGenerator csv;
    
    public CSVGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @Before
    public void setUp() {
        test.append("sl_no");
        test.append(",");
        test.append("book name");
        test.append(",");
        test.append("category");
        test.append("\r\n");
        test.append("1");
        test.append(",");
        test.append("book name 1");
        test.append(",");
        test.append("category 1");
        test.append("\r\n");
        test.append("2");
        test.append(",");
        test.append("book name 2");
        test.append(",");
        test.append("category 2");
        test.append("\r\n");
        csv = new CSVGenerator(test.toString(), "test2", "C:\\Users\\User\\Documents\\NetBeansProjects\\Processed\\");
        
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
        String expResult = test.toString();
        String result = instance.getProcessString();
        assertEquals(expResult, result);
    }
    
}

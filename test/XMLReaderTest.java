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
public class XMLReaderTest {
    
    String inputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Input\\testfile.xml";
    String extractionElement = "CSVIntervalData";
    XMLReader xml = new XMLReader(inputFilePath, extractionElement);
    
    public XMLReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getFilePathString method, of class XMLReader.
     */
    @Test
    public void testGetFilePathString() {
        XMLReader instance = xml;
        String expResult = "C:\\Users\\User\\Documents\\NetBeansProjects\\Input\\testfile.xml";
        String result = instance.getFilePathString();
        assertEquals(expResult, result);
    }


    /**
     * Test of isProcessed method, of class XMLReader.
     */
    @Test
    public void testIsProcessed() {
        XMLReader instance = xml;
        boolean expResult = true;
        boolean result = instance.isProcessed();
        assertEquals(expResult, result);
    }
    
}

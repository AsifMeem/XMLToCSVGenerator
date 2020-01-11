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
    
    ArrayList<String> testArrayList = new ArrayList<>();
    ArrayList<String> resultArrayList = new ArrayList<>();
    CSVFormatter csv;
    
    public CSVFormatterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
        testArrayList.add("100,NEM12,201801211010,MYENRGY,URENRGY");
        testArrayList.add("200,12345678901,E1,E1,E1,N1,HGLMET501,KWH,30");
        testArrayList.add("300,20180115,5.000,3.000,3.008,3.000,4.000,3.000,2.96,3.6,4.212,1.992,2.132,2.532,6.192,5.396,5.616,6.012,5.544,7.436,7.472,5.888,4.316,4.66,5.368,5.644,5.392,6.612,5.8,6.636,6.572,6.36,10.992,9.52,10.268,9.704,9.616,9.308,13.1,20.36,16.456,11.144,9.712,6.076,6.064,5.324,7.18,6.228,5.628,5.94,A,,,20180120032031");
        testArrayList.add("900");
        csv = new CSVFormatter(testArrayList);
        resultArrayList = csv.getCSVArrayList();
    }

    /**
     * Test of getCSVArrayList method, of class CSVFormatter.
     */
    @Test
    public void testGetCSVArrayList() {
        CSVFormatter instance = csv;
        String expResult = "100,NEM12,201801211010,MYENRGY,URENRGY"+"200,12345678901,E1,E1,E1,N1,HGLMET501,KWH,30"+
                "300,20180115,5.000,3.000,3.008,3.000,4.000,3.000,2.96,3.6,4.212,1.992,2.132,2.532,6.192,5.396,5.616,6.012,5.544,7.436,7.472,5.888,4.316,4.66,5.368,5.644,5.392,6.612,5.8,6.636,6.572,6.36,10.992,9.52,10.268,9.704,9.616,9.308,13.1,20.36,16.456,11.144,9.712,6.076,6.064,5.324,7.18,6.228,5.628,5.94,A,,,20180120032031"
                + "900";
        ArrayList<String> resultArr = instance.getCSVArrayList();
        String result = resultArr.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileName method, of class CSVFormatter.
     */
    @Test
    public void testGetFileName() {
        CSVFormatter instance = csv;
        String expResult = "12345678901";
        ArrayList<String> resultArr = instance.getFileName();
        String result = resultArr.get(0);
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeader method, of class CSVFormatter.
     */
    @Test
    public void testGetHeader() {
        CSVFormatter instance = csv;
        String expResult = "100,NEM12,201801211010,MYENRGY,URENRGY";
        String result = instance.getHeader();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFooter method, of class CSVFormatter.
     */
    @Test
    public void testGetFooter() {
        CSVFormatter instance = csv;
        String expResult = "900";
        String result = instance.getFooter();
        assertEquals(expResult, result);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Asif Meem
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({XMLReaderTest.class, XMLToCSVConverterMainTest.class, CSVGeneratorTest.class, CSVFormatterTest.class})
public class RootSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }
    
}

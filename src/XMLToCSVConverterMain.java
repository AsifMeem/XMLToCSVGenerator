
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asif Meem
 */
public class XMLToCSVConverterMain {

    /**
     * @param args the command line arguments
     */
    private final static String inputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Input\\testfile.xml";
    private final static String outputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Processed\\";
    private final static String extractionElement = "CSVIntervalData";
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        XMLReader xml = new XMLReader(inputFilePath, extractionElement);
        ArrayList<String> xmlArr = new ArrayList(xml.getXmlArrayList());
        
        for (String element : xmlArr){
            System.out.println(element);
        }
    }
    
}

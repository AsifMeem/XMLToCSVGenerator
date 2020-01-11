
import java.util.ArrayList;
import java.util.Arrays;

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
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        XMLReader xml = new XMLReader(inputFilePath, extractionElement);
        ArrayList<String> xmlArr = new ArrayList(xml.getXmlArrayList());
        CSVFormatter csv = new CSVFormatter(xmlArr);
        ArrayList<String> csvArr = new ArrayList<>(csv.getCSVArrayList());
        ArrayList<String> fileNameArr = new ArrayList<>(csv.getFileName());
        int fileNameIndex = 0;
        for(String element: csvArr){
            
            CSVGenerator csvGen = new CSVGenerator(element,fileNameArr.get(fileNameIndex));
            csvGen.generateCSV();
            fileNameIndex++ ;
        }
        
    }
    
    
    
}

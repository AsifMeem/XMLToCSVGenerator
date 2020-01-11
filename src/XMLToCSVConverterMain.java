
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * The main method that takes user input and processes input file according to
 *  the user's input
 */

/**
 *
 * @author Asif Meem
 */
public class XMLToCSVConverterMain {

    /**
     * @param args the command line arguments
     */
    private static String inputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Input\\";
    private static String outputFilePath = "C:\\Users\\User\\Documents\\NetBeansProjects\\Processed\\";
    private final static String extractionElement = "CSVIntervalData";
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----XML to CSV Converter App----\n");
        System.out.println("The default input file path is: " + inputFilePath + "\n");
        System.out.println("The default output file path is: " + outputFilePath + "\n");
        boolean takeInput = true;
        int input;
        
        while(takeInput){
            System.out.println("Please select an option and hit enter to proceed:\n\n");
            System.out.println("1 - Generate CSV \n\n");
            System.out.println("2 - Change Input Path \n\n");
            System.out.println("3 - Change Output Path \n\n");
            System.out.println("4 - Quit \n\n:");
            input = sc.nextInt();
            
            switch(input){
                case 1:
                    System.out.println("Please enter the name of the xml file that is to be processed: ");
                    Scanner fileNameScanner = new Scanner(System.in);
                    inputFilePath += fileNameScanner.next();
                    //gets ArrayList from xml file
                    XMLReader xml = new XMLReader(inputFilePath, extractionElement);
                    ArrayList<String> xmlArr = new ArrayList(xml.getXmlArrayList());
                    //formats the arrayList into strings for csv generation
                    CSVFormatter csvFormat = new CSVFormatter(xmlArr);
                    //gets csv arraylist
                    ArrayList<String> csvArr = new ArrayList<>(csvFormat.getCSVArrayList());
                    //gets the output file names
                    ArrayList<String> fileNameArr = new ArrayList<>(csvFormat.getFileName());
                    int fileNameIndex = 0;
                    //Generates the csv files
                    for(String element: csvArr){

                        CSVGenerator csvGen = new CSVGenerator(element,fileNameArr.get(fileNameIndex), outputFilePath);
                        csvGen.generateCSV();
                        fileNameIndex++ ;
                        }
                    for(String file: fileNameArr){
                        System.out.println("File: " + file + ".csv saved to " + outputFilePath);
                    }
                    takeInput = false;
                    break;
                    
                case 2:
                    System.out.println("Please enter desired Input file Path:\n");
                    Scanner inputPathScanner = new Scanner(System.in);
                    String scInput = inputPathScanner.nextLine();
                    if(scInput.trim().isEmpty()){
                        System.out.println("File path cannot be empty.");
                    }
                    else{
                        inputFilePath = scInput;
                        System.out.println("File path set to: " + inputFilePath);
                    }
                    break;
                    
                case 3: 
                    System.out.println("Please enter desired output file Path:\n");
                    Scanner outputPathScanner = new Scanner(System.in);
                    String scInput2 = outputPathScanner.nextLine();
                    if(scInput2.trim().isEmpty()){
                        System.out.println("File path cannot be empty.");
                    }
                    else{
                        outputFilePath = scInput2;
                        System.out.println("File path set to: " + outputFilePath);
                    }
                    break;
                    
                case 4:
                    System.out.println("Exiting Application\n");
                    takeInput = false;
                    break;
                    
                default:
                    System.out.println("Nothing selected. \n");
            }
        }
        
        
    }
    
    
}

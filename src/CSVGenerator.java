
import java.io.File;
import java.io.PrintWriter;
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
public class CSVGenerator {
    
    private final String processString;
    private boolean processed;
    private final String pathString, fileName;

    /**
     * Initializes CSVGenerator object 
     * @param inputString input string that contains all the data for 
     *                       the CSV
     * @param fileName The name that the file will be stored as
     */
    public CSVGenerator(String inputString, String fileName) {
        
        processString = inputString;
        setProcessed(false);
        this.fileName = fileName;
        this.pathString = "C:\\Users\\User\\Documents\\NetBeansProjects\\Processed\\";
        
    }
    
    /**
     *  Creates the CSV according to the parameters defined 
     *  in the constructor
     */
    public void generateCSV (){
        try{
            PrintWriter printWriter = new PrintWriter(new File(getPathString()+ getFileName()+".csv"));
            
            
            printWriter.write(processString);
            printWriter.close();
            setProcessed(true);
            
        }
        catch (Exception e){
            System.err.println("Could not generate CSV: " + e);
            
        }
     }

    /**
     *
     * @return This is the file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     *
     * @return This is the Path of the folder where the file will be saved
     */
    public String getPathString() {
        return pathString;
    }

    private void setProcessed(boolean processed) {
        this.processed = processed;
    }

    /**
     * Returns true/false depending on whether the generation of CSV was 
     * successful
     * @return This is the status 
     */
    public boolean isProcessed() {
        return processed;
    }

    /**
     * Returns the arrayList of input strings that is to be converted into CSV
     * @return This is the String of Arrays that was passed as 
     *  constructor parameters
     */
    public String getProcessString() {
        return processString;
    }
    
}


import java.util.ArrayList;

/*
 * Formats ArrayList according to CSV file generation
 */

/**
 *
 * @author Asif Meem
 */
public class CSVFormatter {
    
    private final ArrayList<String> inputArrayList;
    private String header, footer;
    private final ArrayList<String> csvOutputArrayList, fileNameArrayList;
    private StringBuilder dataString;
    private int deleteIndexCount;
   
    /**
     *
     * @param inputArrayList input arraylist that is to be processed
     */
    public CSVFormatter(ArrayList inputArrayList) {
        this.inputArrayList = inputArrayList;
        this.fileNameArrayList = new ArrayList<>();
        this.dataString = new StringBuilder();
        csvOutputArrayList = new ArrayList<>();
        setHeader();
        setFooter();
    }
    
    /**
     *
     * @return This is the processed Arraylist ready for csv generation
     */
    public ArrayList<String> getCSVArrayList(){
        
        while (!inputArrayList.isEmpty()){
            setDataString();
            csvOutputArrayList.add(dataString.toString());
            shrinkInputArray(deleteIndexCount);
            this.deleteIndexCount = 0;
            this.dataString = new StringBuilder();
        }
        
        return this.csvOutputArrayList;
    }
    
    /**
     *
     * @return This is the Arraylist containing the name of all the csv files 
     * that are to be generated
     */
    public ArrayList<String> getFileName(){
        
        
        return this.fileNameArrayList;
    }
    
    /**
     * 
     * @param index for outlining how many elements to delete from input array 
     */
    private void shrinkInputArray (int index){
        
        for (int i = 0; i < index; i++){
            this.inputArrayList.remove(0);
        }
    }
    
    /**
     *  Sets the header for the csv file
     */
    private void setHeader(){
        this.header = inputArrayList.get(0);
        this.inputArrayList.remove(0);
    }
    
    /**
     * Sets the footer for the csv file
     */
    private void setFooter(){
        int lastIndex = inputArrayList.size() - 1;
        this.footer = inputArrayList.get(lastIndex);
        this.inputArrayList.remove(lastIndex);
    }
    
    /**
     * Builds the csv file as a string according to requirements
     */
    private void setDataString(){
        this.dataString = new StringBuilder();
        this.dataString.append(getHeader());
        int eofCount = 0;
        boolean exitLoopFlag = false;
        for (String element : inputArrayList) {
            String switchParameter = element.substring(0, 3);
            switch (switchParameter) {
                case "200":
                    if(eofCount > 0){
                        exitLoopFlag = true;
                        break;
                    }
                    String[] myStrings = element.split(",");
                    fileNameArrayList.add(myStrings[1]);
                    dataString.append(element);
                    eofCount++ ;
                    deleteIndexCount++;
                    break;
                case "300":
                    dataString.append(element);
                    deleteIndexCount++;
                    break;
                default:
            }
            if (exitLoopFlag){
                break;
            }
        }
        dataString.append(getFooter());
    }
    
    /**
     *
     * @return This is the header of the csv file
     */
    public String getHeader(){
        return this.header;
    }
    
    /**
     *
     * @return This is the footer of the csv file
     */
    public String getFooter(){
        return this.footer;
    }
    
    
}

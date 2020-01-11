
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
public class CSVFormatter {
    
    private final ArrayList<String> inputArrayList;
    private String header, footer, fileName;
    private ArrayList<String> csvOutputArrayList, fileNameArrayList;
    private StringBuilder dataString;
    private int deleteIndexCount;
   
    /**
     *
     * @param inputArrayList
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
     * @return
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
     * @return
     */
    public ArrayList<String> getFileName(){
        
        
        return this.fileNameArrayList;
    }
    
    
    private void shrinkInputArray (int index){
        
        for (int i = 0; i < index; i++){
            this.inputArrayList.remove(0);
        }
    }
    
    private void setHeader(){
        this.header = inputArrayList.get(0);
        this.inputArrayList.remove(0);
    }
    
    private void setFooter(){
        int lastIndex = inputArrayList.size() - 1;
        this.footer = inputArrayList.get(lastIndex);
        this.inputArrayList.remove(lastIndex);
    }
    
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
     * @return
     */
    public String getHeader(){
        return this.header;
    }
    
    /**
     *
     * @return
     */
    public String getFooter(){
        return this.footer;
    }
    
    
}

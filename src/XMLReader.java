
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Class for taking XML file as input and parsing into Array based on the
 * extraction element provided
 */

/**
 *
 * @author Asif Meem
 */
public class XMLReader {
    
    private final String filePathString, extractionElement;
    private String data;
    private ArrayList<String> xmlArrayList;
    private boolean processed;
    
    /**
     *Constructor for initializing XMLReader object. 
     * @param filePathString Path of the input XML file
     * @param extractionElement XML Element to get data from
     */
    public XMLReader(String filePathString, String extractionElement) {
        this.filePathString = filePathString;
        this.xmlArrayList = new ArrayList();
        this.processed = false;
        this.extractionElement = extractionElement;
        generateXMLArrayList();
    }
    
    /**
     *  Private method that contains the logic for reading the XML and 
     *  splitting the data into an ArrayList using new lines as delimeter
     */
    private void generateXMLArrayList(){
        
        try {
            //Open file
            File xmlFile = new File(filePathString);
            
            //Build document
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            
            //Get the data from extraction element
            NodeList nodeList = document.getElementsByTagName(extractionElement);
            Node node = nodeList.item(0);

            if(node.getNodeType() == Node.ELEMENT_NODE){

                Element element = (Element) node;
                data = element.getTextContent();
             
            }
            
            //Split string using new line as delimeter
            String formattedData [] = data.split("\\r?\\n");

            for(int i = 1; i < formattedData.length - 1; i++) {
                xmlArrayList.add(formattedData[i]);
            }
            
            xmlArrayList = cleanData(xmlArrayList);
            setProcessed(true);
            
        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
            System.err.println("Could not generate XML: " + e);
            System.exit(1);
        } 
    }
    
    private ArrayList cleanData(ArrayList<String> inputArrayList){
        ArrayList<String> formattedArrayList = new ArrayList<>();
        
        for (String element : inputArrayList){
            //removes spaces, tabs and new lines
            element = element.replaceAll("[\\n\\t ]", ""); 
            //adds new lines at the end of each element for CSV formatting
            element = element.replaceAll(",$", ""); 
            //adds new lines at the end of each element for CSV formatting
            element = element.concat("\r\n"); 
            formattedArrayList.add(element);
        }
        
        return formattedArrayList;
    }
    

    /**
     * 
     * @param processed  sets the boolean value of processed
     */
    private void setProcessed(boolean processed) {
        this.processed = processed;
    }
    
    /**
     *
     * @return This is the path of the input file
     */
    public String getFilePathString() {
        return filePathString;
    }

    /**
     *
     * @return This is the processed ArrayList
     */
    public ArrayList getXmlArrayList() {
        return xmlArrayList;
    }

    /**
     *
     * @return This is the status flag for successful parsing: true/false
     */
    public boolean isProcessed() {
        return processed;
    }
    
}

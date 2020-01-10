
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asif Meem
 */
public class XMLReader {
    
    private final String filePathString, extractionElement;
    private final ArrayList<String> xmlArrayList;
    private final boolean processed;
    
    public XMLReader(String filePathString, String extractionElement) {
        this.filePathString = filePathString;
        this.xmlArrayList = new ArrayList();
        this.processed = false;
        this.extractionElement = extractionElement;
        generateXMLArrayList();
    }
    
    private void generateXMLArrayList(){
        
        try {
            File xmlFile = new File(filePathString);
            
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            
            NodeList nodeList = document.getElementsByTagName(extractionElement);
            
                
            Node node = nodeList.item(0);

            if(node.getNodeType() == Node.ELEMENT_NODE){

                Element element = (Element) node;

                xmlArrayList.add(element.getTextContent());
            }
                
         
            
            
        } catch (Exception e) {
            System.err.println("Could not generate XML: " + e);
        } 
    }
    

    public String getFilePathString() {
        return filePathString;
    }

    public ArrayList getXmlArrayList() {
        return xmlArrayList;
    }

    public boolean isProcessed() {
        return processed;
    }
    
}

package com.securitywhitepapers.xxe;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class DocumentBuilderFactoryPoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//        TO MAKE IT SAFE
//        docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
//        docBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
//        docBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//        docBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        
        docBuilderFactory.newDocumentBuilder().parse(new File("payload.xml"));
    }

}

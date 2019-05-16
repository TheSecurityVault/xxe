package com.securitywhitepapers.xxe;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class SaxBuilder {
    public static void main(String[] args) {
         
       
        try {
            
            
            String fileContent = new String(Files.readAllBytes(Paths.get("payload.xml")));
            
            SAXBuilder builder = new SAXBuilder();
//          HOW TO MAKE IT SAFE:
//            builder.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
//            builder.setFeature("http://xml.org/sax/features/external-general-entities", false);
//            builder.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//            builder.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            
            final InputStream stream = new ByteArrayInputStream(fileContent.getBytes());
            final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            
            final DocumentBuilder docBuilder = dbf.newDocumentBuilder();
            final Document document = docBuilder.parse(stream);

            
            
        } catch (IOException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(SaxBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package com.securitywhitepapers.xxe;

import java.io.File;
import java.io.IOException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

public class SaxReader {

    public static void main(String[] args) throws IOException, JDOMException, DocumentException, SAXException {
       
        SAXReader reader=new SAXReader();
        
//        TO MAKE IT SAFE
//        reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
//        reader.setFeature("http://xml.org/sax/features/external-general-entities", false);
//        reader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//        reader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        
        Document doc=null;
        doc=reader.read(new File("payload.xml"));
        System.out.println(doc.asXML());
        
    }
    
}

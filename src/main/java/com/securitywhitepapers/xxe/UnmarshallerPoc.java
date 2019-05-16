package com.securitywhitepapers.xxe;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallerPoc {

    public static void main(String[] args){
        
        try {

//        SAFE IMPLEMENTATION FOR OLDER VERSIONS         
//        SAXParserFactory spf = SAXParserFactory.newInstance();
//        spf.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
//
//        String fileContent = new String(Files.readAllBytes(Paths.get("payload.xml")));
//
//        Source xmlSource = new SAXSource(spf.newSAXParser().getXMLReader(), new InputSource(new StringReader(fileContent)));
//        JAXBContext jc = JAXBContext.newInstance(Contact.class);
//        Unmarshaller um = jc.createUnmarshaller();
//        um.unmarshal(xmlSource);
//


            //From java 8 and above this is safe.
            //on older versions by default JAXBContext allows external entities
            JAXBContext jaxbContext = JAXBContext.newInstance(Contact.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File("payload.xml")); 
            
            
            
        } catch (JAXBException ex) {
            Logger.getLogger(UnmarshallerPoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

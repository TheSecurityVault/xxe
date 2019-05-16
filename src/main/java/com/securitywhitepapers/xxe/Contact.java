package com.securitywhitepapers.xxe;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contact {
    
    public Contact(){}
    
    public Contact(String name){
        this.name = name;
    }
    
    @XmlElement
    String name;
}

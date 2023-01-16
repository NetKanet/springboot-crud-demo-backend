package com.netkanet.springboothtml.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Student")
public class Student {

    @XmlElement(name = "id")
    private String id;

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "surname")
    private String surname;

    @XmlElement(name = "address1")
    private String address1;

    @XmlElement(name = "district")
    private String district;

    @XmlElement(name = "province")
    private String province;

    @XmlElement(name = "postalcode")
    private String postalCode;

}

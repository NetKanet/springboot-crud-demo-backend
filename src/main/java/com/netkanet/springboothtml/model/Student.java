package com.netkanet.springboothtml.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Student")
public class Student {
    private String id;
    private String name;
    private String surname;
    private String address1;
    private String district;
    private String province;
    private String postalcode;

    public Student(String id, String name, String surname, String address1, String district, String province, String postalcode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address1 = address1;
        this.district = district;
        this.province = province;
        this.postalcode = postalcode;
    }

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElement(name = "address1")
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @XmlElement(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @XmlElement(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @XmlElement(name = "postalcode")
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
}

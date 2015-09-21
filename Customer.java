package faktura;

import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class Customer {

    private String name;
    private String sureName;
    private String address;
    private String nip;
    private String nazwaFirmy;
   // 

    public Customer() {

        setName("Jan");
        setSurename("Kowalski");
        setAddress("Kolejowa 10/3");
        setNip("888-123-123");
        setFirm("Macrosoft");
    }

    public void setName(String name) {

        this.name = name;

    }

    public void setAddress(String address) {

        this.address = address;

    }

    public void setSurename(String surename) {
        this.sureName = surename;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setFirm(String nazwafirmy) {

        this.nazwaFirmy = nazwafirmy;

    }

    public String getName() {

        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public String getAddress() {
        return address;
    }

    public String getFirm() {
        return nazwaFirmy;
    }

    public String getNIP() {
        return nip;
    }

    public void createCustomerFromTable(String[] t) throws IOException, BiffException, WriteException {

        this.name = t[0];
        this.sureName = t[1];
        this.address = t[2];
        this.nazwaFirmy = t[3];
        this.nip = t[4];

    }

}

package com.example.devesh.humanresourcemanager;

/**
 * Created by devesh on 9/11/17.
 */

public class mydata {
    String name;
    String pass;
    String R_pass;
    String Addar;
    String mail;

    public mydata(String name, String pass, String r_pass, String addar, String mail) {
        this.name = name;
        this.pass = pass;
        this.R_pass = r_pass;
        this.Addar = addar;
        this.mail = mail;
    }
    public String getName() {return name;}
    public String getMail() {return mail;}
    public String getAddar() {return Addar;}
    public String getPass() {return pass;}

    }